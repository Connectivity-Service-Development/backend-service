package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.jparepository;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity.UserPrepaidServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserPrepaidServiceRepository extends JpaRepository<UserPrepaidServiceEntity, UUID> {
    List<UserPrepaidServiceEntity> findByUser_Id(Long userId);

    @Query("delete from UserPrepaidServiceEntity ups where ups.user.id = :userId and ups.prepaidService.id = :prepaidServiceId ")
    @Modifying
    void deleteUserPrepaidService(Long userId, UUID prepaidServiceId);
}

