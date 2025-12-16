package com.example.QLTV.enity;

import com.example.QLTV.enity.enums.IncidentPriority;
import com.example.QLTV.enity.enums.IncidentStatus;
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
public class Incident extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "id", columnDefinition = "CHAR(36)")
    UUID id;

    String createdBy;
    String title;
    String description;

    @Enumerated(EnumType.STRING)
    IncidentPriority priority;

    @Enumerated(EnumType.STRING)
    IncidentStatus status;
}