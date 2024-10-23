package com.skoda.tenderconnectivity.backendservice.prepaidservice.domain;

import java.util.List;

public interface UserServiceFinder {
    List<UserPrepaidService> getUserPrepaidServices(Long userId);
}
