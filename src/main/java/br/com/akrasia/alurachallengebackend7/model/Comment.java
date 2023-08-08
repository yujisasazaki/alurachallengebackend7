package br.com.akrasia.alurachallengebackend7.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {

    @Id
    private Long id;

    private String author;

    private String content;

    private String filePath;

}
