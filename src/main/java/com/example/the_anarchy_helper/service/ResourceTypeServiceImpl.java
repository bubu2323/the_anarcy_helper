package com.example.the_anarchy_helper.service;

import com.example.the_anarchy_helper.dto.*;
import com.example.the_anarchy_helper.entity.Requirement;
import com.example.the_anarchy_helper.entity.Resource;
import com.example.the_anarchy_helper.entity.RewardAction;
import com.example.the_anarchy_helper.entity.RewardActionResult;
import com.example.the_anarchy_helper.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.cfg.MapperBuilder;

import java.util.Collections;
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

        //recupera tutte le azioni e requisiti che hanno come ricompensa la risorsa desiderata
        //esempio  RewardActionResult(id=6, rewardAction=RewardAction(id=5, actionName=Convert to soldiers (and soldier production) in the Training grounds, immediate=true),
        // resource=Resource(id=4, name=Soldier, color=red, category=Category(id=1, name=human)))

        List<RewardActionResult> rewardActionResultList =
                rewardActionResultRepository.findByResourceId(neededResource.getId());
        rewardActionResultList
                .forEach(rewardActionEl -> log.info("rewardActionEl {}", rewardActionEl.toString()));

        List<Integer> rewardActionIds = rewardActionResultList
                .stream()
                .map(rewardActionResult -> rewardActionResult.getRewardAction().getId())
                .toList();

        //ricerca in requirementsRepository tutti i requisiti per ottenere la risorsa desiderata
        List<Requirement> requirementsToGetResult = requirementsRepository.findByRequirement_IdIn(ownedResourceIds);

        requirementsToGetResult
                .forEach(rewardActionEl -> log.info("requirementsToGetResult {}", rewardActionEl.toString()));
        //requirementsToGetResult Requirement(id=2, isAction=false, isResource=true, requirement=Resource(id=2, name=Craftsman, color=black, category=Category(id=1, name=human)), prerequisiteAction=null)


        //tutte le azioni che hanno come requisito la risorsa posseduta
        List<Integer> ownedRewardActionIds = this.getRewardActionIdsByRequirements(requirementsToGetResult);

        //ricerca tra tutte le ricompense che si possono ottenere quelle che hanno come requisito la risorsa posseduta
        List<Integer> result = rewardActionIds
                .stream()
                .filter(ownedRewardActionIds::contains)
                .toList();

        //risultato: tutte le azioni per ottenere la ricompensa desiderata
        List<RewardAction> rewardActionList = rewardActionsRepository.findByIdIn(result);

        rewardActionList
                .forEach(rwl -> log.info("rewardActionList {}", rwl.toString()));

        //rewardActionList RewardAction(id=8, actionName=Fill in the Ramparts line in the Leadership row (and Soldier production), immediate=false)

        Necessity necessity = request.getNecessity();

        //filtra le azioni ottenute in base alla necessita'
        List<RewardAction> filteredResult = this.getRewardActionsByNecessity(necessity, rewardActionList);

        log.debug("filteredResult {}", filteredResult);

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

    private @NonNull FindResourceResponse buildFindResourceResponse(List<RewardAction> filteredResult) {
        List<Actions> list = filteredResult
                .stream()
                .map(this::buildAction)
                .toList();
        FindResourceResponse response = new FindResourceResponse();
        response.setActionsForReward(list);
        return response;
    }

    private Actions buildAction(RewardAction r) {
        return Actions.builder()
                .name(r.getActionName())
                .area(r.getArea().getName())
                .build();
    }

    private List<RewardAction> getRewardActionsByNecessity(Necessity necessity, List<RewardAction> rewardActionList) {
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
        List<ResourceType> resource = request.getOwnedResourceType();
        if (resource == null) {
            return Collections.emptyList();
        }
        List<String> resourceNames = resource
                .stream()
                .map(ownedResource -> ownedResource.getName())
                .toList();

        List<Resource> resourceList = resourceRepository.findByNameIn(resourceNames);

        if (resourceList.isEmpty()) {
            throw new NoSuchElementException("resource not found.");
        }

        return resourceList
                .stream()
                .map(Resource::getId)
                .toList();
    }
}
