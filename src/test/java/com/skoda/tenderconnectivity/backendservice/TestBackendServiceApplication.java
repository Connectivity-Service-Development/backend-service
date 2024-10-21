package com.skoda.tenderconnectivity.backendservice;

import org.springframework.boot.SpringApplication;

public class TestBackendServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(BackendServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
