package com.verbum.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "USUARIO")
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="IDUSUARIO", unique = true, nullable = false)
    @Id
    private UUID id;

    @Column(name = "NOME",nullable = false)
    private String name;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "BIOGRAFIA", nullable = true)
    private String biography;

    @Column(name = "PROFILEURL", nullable = true)
    private String image;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime created_at;

    @Column(name = "UPDATED_AT", nullable = true)
    private LocalDateTime updated_at;
}
