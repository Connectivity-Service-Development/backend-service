package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.jparepository;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity.PrepaidServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrepaidServiceRepository extends JpaRepository<PrepaidServiceEntity, UUID> {
}
