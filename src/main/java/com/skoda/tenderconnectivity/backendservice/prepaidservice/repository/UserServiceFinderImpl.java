package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository;


import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.jparepository.UserPrepaidServiceRepository;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.UserServiceFinder;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain.UserPrepaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserServiceFinderImpl implements UserServiceFinder {

    private final UserPrepaidServiceRepository repository;

    @Override
    public List<UserPrepaidService> getUserPrepaidServices(Long userId) {
        return repository.findByUser_Id(userId)
                .stream()
                .map(entity -> new UserPrepaidService(
                        entity.getId(),
                        entity.getPrepaidService().getServiceName(),
                        entity.getExpirationDate()))
                .collect(Collectors.toList());
    }
}
