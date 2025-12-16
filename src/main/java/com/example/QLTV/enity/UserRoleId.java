package com.example.QLTV.enity;

import lombok.*;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode

public class UserRoleId implements Serializable {
    String userId;
    String roleId;
}