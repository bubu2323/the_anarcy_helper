package com.example.the_anarchy_helper.controller;

import com.example.the_anarchy_helper.dto.FindResourceRequest;
import com.example.the_anarchy_helper.dto.FindResourceResponse;
import com.example.the_anarchy_helper.dto.ResourceType;
import com.example.the_anarchy_helper.service.ResourceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
public class ResourceTypeController {
    private final ResourceTypeService resourceTypeService;

    @PostMapping("/find")
    private FindResourceResponse findWayToGetResource(@RequestBody FindResourceRequest resource){
        return resourceTypeService.findWayToGetResource(resource);
    }
}
