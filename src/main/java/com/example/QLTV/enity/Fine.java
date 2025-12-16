package com.example.QLTV.enity;

import com.example.QLTV.enity.enums.FineStatus;
import com.example.QLTV.enity.enums.FineType;
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
public class Fine extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "id", columnDefinition = "CHAR(36)")
    UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id")
    Loan loan;

    @Enumerated(EnumType.STRING)
    @Column(name = "fine_type")
    FineType fineType;

    Double amount;

    @Enumerated(EnumType.STRING)
    FineStatus status;

    @OneToMany(mappedBy = "fine", cascade = CascadeType.ALL)
    List<FinePayment> payments;
}