package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.jparepository.PrepaidServiceRepository;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.PrepaidServiceFinder;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain.PrepaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PrepaidServiceFinderImpl implements PrepaidServiceFinder {

    private final PrepaidServiceRepository repository;

    @Override
    public List<PrepaidService> getAllPrepaidServices() {
        return repository.findAll().stream()
                .map(entity -> new PrepaidService(
                        entity.getId(),
                        entity.getServiceName(),
                        entity.getDescription()))
                .collect(Collectors.toList());
    }
}
