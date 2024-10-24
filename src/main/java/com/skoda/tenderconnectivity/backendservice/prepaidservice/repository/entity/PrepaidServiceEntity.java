package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity;

import com.skoda.tenderconnectivity.backendservice.common.repository.Auditable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
    @Column(name = "bullet_points", columnDefinition = "TEXT[]")
    @JdbcTypeCode(SqlTypes.ARRAY)
    private List<String> bulletPoints;

    @OneToMany(mappedBy = "prepaidService", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<UserPrepaidServiceEntity> userPrepaidServices;
}
