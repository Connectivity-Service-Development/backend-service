package com.skoda.tenderconnectivity.backendservice.prepaidservice.service;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain.UserPrepaidService;

import java.util.UUID;

public interface UserPrepaidServiceProlongation {

    UserPrepaidService prolongUserPrepaidService(Long userId, UUID serviceId);

}
