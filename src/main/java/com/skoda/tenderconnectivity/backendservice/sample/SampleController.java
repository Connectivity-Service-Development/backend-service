package com.skoda.tenderconnectivity.backendservice.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

    @GetMapping()
    SampleDTO get() {
        return new SampleDTO(UUID.randomUUID().toString(), "name", "description");
    }
}
