package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository;

import com.skoda.tenderconnectivity.backendservice.BackendServiceApplicationTests;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity.PrepaidServiceEntity;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.UserPrepaidServiceProlongation;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class UserPrepaidServiceProlongationImplTest extends BackendServiceApplicationTests {
    @Autowired
    UserPrepaidServiceProlongation userPrepaidServiceProlongation;
    @Autowired
    EntityManager entityManager;

    @Test
    void prolongUserPrepaidService_shouldOk() {
        var ps = entityManager
                .createQuery("select ups.prepaidService from UserPrepaidServiceEntity ups where ups.id is not null", PrepaidServiceEntity.class)
                .getResultList().getFirst();
        var userPrepaidService = userPrepaidServiceProlongation.prolongUserPrepaidService(1L, ps.getId());

        assertEquals("INFOTAINMENT_ONLINE", userPrepaidService.serviceName());
        assertEquals(LocalDate.now().plusMonths(2), userPrepaidService.expirationDate());
        assertFalse(userPrepaidService.isExpired());
    }

}
