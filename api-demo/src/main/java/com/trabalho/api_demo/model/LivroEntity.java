package com.trabalho.api_demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String title;

    @NotNull
    @Size(max = 50)
    private String author;

    @NotNull
    @Size(max = 50)
    private String genre;

    @NotNull
    @Pattern(regexp = "\\d{4}", message = "O ano de publicação deve estar no formato YYYY")
    private String publicationYear;

    @NotNull
    @Min(1)
    private Integer pages;

    @NotNull
    private boolean available;

    @Min(1)
    @Max(5)
    private Integer rating;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
