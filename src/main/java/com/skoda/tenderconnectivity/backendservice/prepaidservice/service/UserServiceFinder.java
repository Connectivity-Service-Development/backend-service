package com.skoda.tenderconnectivity.backendservice.prepaidservice.service;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain.UserPrepaidService;

import java.util.List;

public interface UserServiceFinder {
    List<UserPrepaidService> getUserPrepaidServices(Long userId);
}
