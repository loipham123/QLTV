package com.example.QLTV.enity;

import com.example.QLTV.enity.enums.RoleName;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {
    @Id
    @UuidGenerator
    @Column(name = "id", columnDefinition = "CHAR(36)")
    UUID id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    RoleName name;

    String description;

    @OneToMany(mappedBy = "role")
    List<UserRole> userRoles;
}