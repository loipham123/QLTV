package com.example.QLTV.enity;

import com.example.QLTV.enity.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {
    @Id
    @UuidGenerator
    @Column(name = "id", columnDefinition = "CHAR(36)")
    UUID id;

    @Column(unique = true, nullable = false)
    String email;

    String password;
    String fullName;
    String phone;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    @OneToOne(mappedBy = "user")
    Student student;

    @OneToOne(mappedBy = "user")
    Staff staff;

    @OneToMany(mappedBy = "user")
    List<UserRole> userRoles;

    @OneToMany(mappedBy = "user")
    List<Notification> notifications;
}