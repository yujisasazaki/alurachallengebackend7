package br.com.akrasia.alurachallengebackend7.model;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentForm (
  
    @NotBlank
    String author,

    @NotBlank
    String content,

    @NotNull
    MultipartFile file
){}