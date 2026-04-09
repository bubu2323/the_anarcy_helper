package com.example.the_anarchy_helper.service;

import com.example.the_anarchy_helper.dto.Actions;
import com.example.the_anarchy_helper.dto.FindResourceRequest;
import com.example.the_anarchy_helper.dto.FindResourceResponse;
import com.example.the_anarchy_helper.dto.Necessity;
import com.example.the_anarchy_helper.entity.Requirement;
import com.example.the_anarchy_helper.entity.Resource;
import com.example.the_anarchy_helper.entity.RewardAction;
import com.example.the_anarchy_helper.entity.RewardActionResult;
import com.example.the_anarchy_helper.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NotFound;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import tools.jackson.databind.cfg.MapperBuilder;

import java.util.List;
import java.util.NoSuchElementException;

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
        List<Integer> ownedResourceIds = this.getResourceIds(request);

        Resource neededResource = resourceRepository
                .findByName(request.getNeededResourceType().getName())
                .orElseThrow(() -> new NoSuchElementException("Resource not found"));

        List<RewardActionResult> rewardActionResultList =
                rewardActionResultRepository.findByResourceId(neededResource.getId());

        List<Integer> rewardActionIds = rewardActionResultList
                .stream()
                .map(rewardActionResult -> rewardActionResult.getRewardAction().getId())
                .toList();

        //search into requirementRepository each requirement by owned resource
        List<Requirement> requirementsToGetResult = requirementsRepository.findByRequirement_IdIn(ownedResourceIds);

        List<Integer> ownedRewardActionIds = this.getRewardActionIdsByRequirements(requirementsToGetResult);

        List<Integer> result = rewardActionIds
                .stream()
                .filter(ownedRewardActionIds::contains)
                .toList();

        List<RewardAction> rewardActionList = rewardActionsRepository.findByIdIn(result);

        Necessity necessity = request.getNecessity();
        List<RewardAction> filteredResult = this.getRewardActionsByNecessity(necessity, rewardActionList);

        log.info("filteredResult {}", filteredResult);

        return this.buildFindResourceResponse(filteredResult);
    }


    //    --- private methods --- //

    /**
     * Retrieves all reward action IDs associated with the given requirements.
     * For each requirement, fetches all reward_actions_requirements that reference it,
     * flattens the results into a single stream and extracts the reward_action_id.
     *
     * @param requirements list of requirements matching the owned resources
     * @return list of reward action IDs that require the owned resources
     */
    private @NonNull List<Integer> getRewardActionIdsByRequirements(List<Requirement> requirements) {
        return requirements
                .stream()
                .flatMap(requirement -> rewardActionsRequirementsRepository
                        .findByRequirementId(requirement.getId())
                        .stream())
                .map(rewardActionRequirement -> rewardActionRequirement.getRewardAction().getId())
                .toList();
    }

    private static @NonNull FindResourceResponse buildFindResourceResponse(List<RewardAction> filteredResult) {
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

    private static List<RewardAction> getRewardActionsByNecessity(Necessity necessity, List<RewardAction> rewardActionList) {
        return
                switch (necessity) {
                    case PROGRAMMED ->
                            rewardActionList.stream().filter(rewardAction -> !rewardAction.getImmediate()).toList();
                    case IMMEDIATELY ->
                            rewardActionList.stream().filter(rewardAction -> rewardAction.getImmediate()).toList();
                    case INDIFFERENT -> rewardActionList;
                };
    }

    private @NonNull List<Integer> getResourceIds(FindResourceRequest request) {
        List<String> resource = request.getOwnedResourceType()
                .stream()
                .map(ownedResource -> ownedResource.getName())
                .toList();

        List<Resource> resourceList = resourceRepository.findByNameIn(resource);

        if (resourceList.isEmpty()) {
            throw new NoSuchElementException("resource not found.");
        }

        return resourceList
                .stream()
                .map(Resource::getId)
                .toList();
    }
}
