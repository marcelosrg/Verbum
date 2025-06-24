package com.verbum.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "POST")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Post {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "TITULO", nullable = false)
    private String title;

    @Column(name = "CONTEUDO", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "DATA_PUBLICACAO")
    private LocalDateTime publicationDate;

    @Column(name = "PUBLICADO")
    private Boolean published = false;

    @Column(name = "CAPA_IMAGEM")
    private String urlImage;

    @CreatedDate
    @Column(name = "CREATED_AT")
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    private LocalDateTime updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private User user;
}