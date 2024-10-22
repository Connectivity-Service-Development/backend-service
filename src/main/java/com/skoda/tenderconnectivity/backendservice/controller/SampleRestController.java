package com.skoda.tenderconnectivity.backendservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SampleRestController {

    @Tag(name = "get", description = "GET sample")
    @GetMapping("/sample")
    public List<Sample> getSample() {
        return List.of(new Sample("sample1"), new Sample("sample2"));
    }
}
