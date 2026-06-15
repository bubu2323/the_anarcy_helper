package com.example.the_anarchy_helper.service;


import com.example.the_anarchy_helper.domain.dto.FindResourceRequest;
import com.example.the_anarchy_helper.domain.dto.FindResourceResponse;
import com.example.the_anarchy_helper.domain.dto.Necessity;


public interface ResourceTypeService {
    FindResourceResponse findByFindResourceRequest(FindResourceRequest resource);

    FindResourceResponse findAllWaysToGetResult(String neededResource, Necessity necessity);
}
