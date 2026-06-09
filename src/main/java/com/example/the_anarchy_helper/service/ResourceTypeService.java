package com.example.the_anarchy_helper.service;


import com.example.the_anarchy_helper.domain.dto.FindResourceRequest;
import com.example.the_anarchy_helper.domain.dto.FindResourceResponse;


public interface ResourceTypeService {
    FindResourceResponse findWayToGetResource(FindResourceRequest resource);
}
