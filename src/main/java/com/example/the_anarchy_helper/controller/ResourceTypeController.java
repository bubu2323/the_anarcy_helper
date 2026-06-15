package com.example.the_anarchy_helper.controller;

import com.example.the_anarchy_helper.domain.dto.FindResourceRequest;
import com.example.the_anarchy_helper.domain.dto.FindResourceResponse;
import com.example.the_anarchy_helper.domain.dto.Necessity;
import com.example.the_anarchy_helper.domain.dto.ResourceType;
import com.example.the_anarchy_helper.service.ResourceTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
public class ResourceTypeController {
    private final ResourceTypeService resourceTypeService;

    @PostMapping("/find")
    private FindResourceResponse findByFindResourceRequest(@Valid @RequestBody FindResourceRequest resource){
        return resourceTypeService.findByFindResourceRequest(resource);
    }

    @GetMapping("/find")
    private FindResourceResponse findAllWaysToGetResult(@RequestParam String neededResource,
                                                        @RequestParam(required = false) Necessity necessity){
        return resourceTypeService.findAllWaysToGetResult(neededResource, necessity);
    }
}
