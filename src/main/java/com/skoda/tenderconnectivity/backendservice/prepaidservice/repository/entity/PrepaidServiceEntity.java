package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity;

import com.skoda.tenderconnectivity.backendservice.common.repository.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "prepaid_service")
public class PrepaidServiceEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String description;
    private BigDecimal price;

    @OneToMany(mappedBy = "prepaidService", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<UserPrepaidServiceEntity> userPrepaidServices;
}
