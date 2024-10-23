package com.skoda.tenderconnectivity.backendservice.prepaidservice.service;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain.UserPrepaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceManager {

    private final UserServiceFinder userServiceFinder;

    public List<UserPrepaidService> listUserPrepaidServices(Long userId) {
        return userServiceFinder.getUserPrepaidServices(userId);
    }
}
