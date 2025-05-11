package com.hit.example.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    String name;

    String description;

    @Min(0)
    double price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
