package com.skoda.tenderconnectivity.backendservice.prepaidservice.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/technical")
@RequiredArgsConstructor
@Tag(name = "For demo only", description = "For demo")
public class TechnicalController {
    private final EntityManager entityManager;

    @DeleteMapping
    @Transactional
    void deleteAllUserPrepaidService() {
        entityManager.createQuery("DELETE FROM UserPrepaidServiceEntity ").executeUpdate();
    }
}
