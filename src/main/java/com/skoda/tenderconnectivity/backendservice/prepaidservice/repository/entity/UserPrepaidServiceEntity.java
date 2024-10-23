package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity;

import com.skoda.tenderconnectivity.backendservice.common.repository.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_prepaid_service")
public class UserPrepaidServiceEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "prepaid_service_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PrepaidServiceEntity prepaidService;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    private boolean isActive;
}
