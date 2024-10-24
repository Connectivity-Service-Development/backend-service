package com.skoda.tenderconnectivity.backendservice.prepaidservice.controller;


import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity.PrepaidServiceEntity;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity.UserEntity;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity.UserPrepaidServiceEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/technical")
@RequiredArgsConstructor
@Tag(name = "For demo only", description = "Reset the state of app, so there is 1 service expired and 1 not.")
public class TechnicalController {
    private final EntityManager entityManager;

    @DeleteMapping
    @Transactional
    public void deleteAllUserPrepaidService() {
        entityManager.createQuery("DELETE FROM UserPrepaidServiceEntity ").executeUpdate();
        var user = entityManager
                .createQuery("select u from UserEntity u ", UserEntity.class)
                .getResultList().getFirst();

        var itOnline = entityManager
                .createQuery("select ps from PrepaidServiceEntity ps where ps.serviceName = 'INFOTAINMENT_ONLINE'", PrepaidServiceEntity.class)
                .getSingleResult();
        var iSpeedAssist = entityManager
                .createQuery("select ps from PrepaidServiceEntity ps where ps.serviceName = 'INTELLIGENT_SPEED_ASSIST'", PrepaidServiceEntity.class)
                .getSingleResult();

        var userPrepaidServiceEntity = UserPrepaidServiceEntity.builder()
                .user(user)
                .prepaidService(itOnline)
                .expirationDate(LocalDate.now().minusDays(4))
                .build();

        var userPrepaidServiceEntity2 = UserPrepaidServiceEntity.builder()
                .user(user)
                .prepaidService(iSpeedAssist)
                .expirationDate(LocalDate.now().plusDays(4))
                .build();

        entityManager.persist(userPrepaidServiceEntity);
        entityManager.persist(userPrepaidServiceEntity2);
    }
}
