package com.cdtuyen.borrowingService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "borrowing")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Borrowing {
    @Id
    @SequenceGenerator(name = "borrowing_sequence", sequenceName = "borrowing_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "borrowing_sequence")
    private Long id;
    private Long bookId;
    private Long employeeId;
    private Date borrowingDate;
    private Date returnDate;
}
