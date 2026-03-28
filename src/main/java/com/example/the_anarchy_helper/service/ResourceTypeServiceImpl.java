package com.example.the_anarchy_helper.service;

import com.example.the_anarchy_helper.dto.FindResourceRequest;
import com.example.the_anarchy_helper.dto.FindResourceResponse;
import com.example.the_anarchy_helper.dto.ResourceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceTypeServiceImpl implements ResourceTypeService {
    @Override
    public FindResourceResponse findWayToGetResource(FindResourceRequest resource) {
        //example i Have Craftsmen and Material so i recevie new List of ResourceType.name = MATERIAL and Worker.workertype.CRAFTSMEN
        // i expect to receive a list of actions  that i can do to

        return null;
    }
}
