package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.jparepository;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity.UserPrepaidServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserPrepaidServiceRepository extends JpaRepository<UserPrepaidServiceEntity, UUID> {
    List<UserPrepaidServiceEntity> findByUser_Id(Long userId);
}

