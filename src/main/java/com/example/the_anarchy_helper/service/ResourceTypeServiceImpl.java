package com.example.the_anarchy_helper.service;

import com.example.the_anarchy_helper.dto.*;
import com.example.the_anarchy_helper.entity.Requirement;
import com.example.the_anarchy_helper.entity.Resource;
import com.example.the_anarchy_helper.entity.RewardAction;
import com.example.the_anarchy_helper.entity.RewardActionResult;
import com.example.the_anarchy_helper.repository.*;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.cfg.MapperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ResourceTypeServiceImpl implements ResourceTypeService {
    @Autowired
    public RewardActionRequirementRepository rewardActionRequirementRepository;
    @Autowired
    public RewardActionResultRepository rewardActionResultRepository;
    @Autowired
    public RequirementsRepository requirementsRepository;
    @Autowired
    public ResourceRepository resourceRepository;
    @Autowired
    public RewardActionsRepository rewardActionsRepository;
    @Autowired
    private RewardActionsRequirementsRepository rewardActionsRequirementsRepository;
    @Autowired
    private MapperBuilder mapperBuilder;

    @Override
    public FindResourceResponse findWayToGetResource(FindResourceRequest request) {
        List<String> ownedResources = request.getOwnedResourceType()
                .stream()
                .map(ownedResource -> ownedResource.getName())
                .toList();

        List<Resource> resourceList = resourceRepository.findByNameIn(ownedResources);
        List<Integer> ownedResourceIds = resourceList
                .stream()
                .map(Resource::getId)
                .toList();


        Resource neededResource = resourceRepository
                .findByName(request.getNeededResourceType().getName())
                .orElseThrow(() -> new RuntimeException("Resource not found"));

        List<RewardActionResult> actionResults = rewardActionResultRepository
                .findByResourceId(neededResource.getId());


        List<Integer> neededRewardActionIds = actionResults
                .stream()
                .map(rewardActionResult -> rewardActionResult.getRewardAction().getId())
                .toList();

        List<Requirement> requirementForOwnedResource = requirementsRepository.findByRequirement_IdIn(ownedResourceIds);

        List<Integer> ownedRewardActionIds = requirementForOwnedResource
                .stream()
                .flatMap(requirement -> rewardActionsRequirementsRepository.findByRequirementId(requirement.getId())
                        .stream())
                .map(rewardActionRequirement -> rewardActionRequirement.getRewardAction().getId())
                .toList();

        List<Integer> result = neededRewardActionIds
                .stream()
                .filter(ownedRewardActionIds::contains)
                .toList();

        List<RewardAction> rewardActionList = rewardActionsRepository.findByIdIn(result);

        Necessity necessity = request.getNecessity();
        List<RewardAction> filteredResult =
                switch (necessity) {
                    case PROGRAMMED ->
                            rewardActionList.stream().filter(rewardAction -> !rewardAction.getImmediate()).toList();
                    case IMMEDIATELY ->
                            rewardActionList.stream().filter(rewardAction -> rewardAction.getImmediate()).toList();
                    case INDIFFERENT -> rewardActionList;
                };

        log.info("filteredResult {}", filteredResult);


        List<Actions> list = filteredResult
                .stream()
                .map(r -> {
                            Actions actions = new Actions();
                            actions.setName(r.getActionName());
                            return actions;
                        })
                .toList();
        FindResourceResponse response = new FindResourceResponse();
        response.setActionsForReward(list);


        return response;
    }
}
