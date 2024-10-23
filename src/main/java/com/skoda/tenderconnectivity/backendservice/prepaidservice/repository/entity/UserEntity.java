package com.skoda.tenderconnectivity.backendservice.prepaidservice.repository.entity;

import com.skoda.tenderconnectivity.backendservice.common.repository.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`user`")
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<UserPrepaidServiceEntity> prepaidServices;

}
