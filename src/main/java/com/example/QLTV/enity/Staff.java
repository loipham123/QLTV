package com.example.QLTV.enity;

import com.example.QLTV.enity.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Staff extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "id", columnDefinition = "CHAR(36)")
    UUID id;

    @Column(unique = true, nullable = false)
    String staffCode;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}