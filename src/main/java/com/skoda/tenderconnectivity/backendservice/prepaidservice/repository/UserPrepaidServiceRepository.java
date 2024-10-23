package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity.UserPrepaidServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPrepaidServiceRepository extends JpaRepository<UserPrepaidServiceEntity, Long> {
    List<UserPrepaidServiceEntity> findByUser_Id(Long userId);
}

