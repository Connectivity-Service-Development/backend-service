package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.jparepository;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
