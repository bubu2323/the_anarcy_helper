package com.example.the_anarchy_helper.service;


import com.example.the_anarchy_helper.dto.FindResourceRequest;
import com.example.the_anarchy_helper.dto.FindResourceResponse;


public interface ResourceTypeService {
    FindResourceResponse findWayToGetResource(FindResourceRequest resource);
}
