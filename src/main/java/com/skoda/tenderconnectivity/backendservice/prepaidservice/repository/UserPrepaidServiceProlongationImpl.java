package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity.UserPrepaidServiceEntity;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.jparepository.PrepaidServiceRepository;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.jparepository.UserPrepaidServiceRepository;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.jparepository.UserRepository;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.UserPrepaidServiceProlongation;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain.UserPrepaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class UserPrepaidServiceProlongationImpl implements UserPrepaidServiceProlongation {

    private final UserPrepaidServiceRepository userPrepaidServiceRepository;
    private final PrepaidServiceRepository prepaidServiceRepository;
    private final UserRepository userRepository;

    /**
     * Delete UserPrepaidService if exists for the user and PrepaidService. Create a new one
     */
    @Override
    public UserPrepaidService prolongUserPrepaidService(Long userId, UUID serviceId) {
        userPrepaidServiceRepository.deleteUserPrepaidService(userId, serviceId);
        var prepaidServiceEntity = prepaidServiceRepository.getReferenceById(serviceId);
        var userEntity = userRepository.getReferenceById(userId);
        var userPrepaidServiceEntity = UserPrepaidServiceEntity.builder()
                .user(userEntity)
                .prepaidService(prepaidServiceEntity)
                .expirationDate(LocalDate.now().plusDays(1L))
                .build();
        userPrepaidServiceEntity = userPrepaidServiceRepository.save(userPrepaidServiceEntity);
        return new UserPrepaidService(prepaidServiceEntity.getId(), userPrepaidServiceEntity.getPrepaidService().getServiceName(), userPrepaidServiceEntity.getExpirationDate());
    }
}
