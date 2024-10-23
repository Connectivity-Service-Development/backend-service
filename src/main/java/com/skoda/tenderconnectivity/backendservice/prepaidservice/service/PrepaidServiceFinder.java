package com.skoda.tenderconnectivity.backendservice.prepaidservice.service;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain.PrepaidService;

import java.util.List;

public interface PrepaidServiceFinder {
    List<PrepaidService> getAllPrepaidServices();
}
