package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity;

import com.skoda.tenderconnectivity.backendservice.common.repository.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "prepaid_service")
public class PrepaidServiceEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;

    private String serviceName;
    private String description;
    private BigDecimal price;

    @OneToMany(mappedBy = "prepaidService", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<UserPrepaidServiceEntity> userPrepaidServices;
}
