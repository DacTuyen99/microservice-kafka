package com.cdtuyen.bookService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    private Long id;
    private String name;
    private String author;
    private Boolean isReady;
}
