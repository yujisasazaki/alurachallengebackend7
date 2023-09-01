package br.com.akrasia.alurachallengebackend7.model.comment;

import org.springframework.web.multipart.MultipartFile;

import br.com.akrasia.alurachallengebackend7.validation.ImageFile;
import jakarta.validation.constraints.NotBlank;

public record CommentForm (
  
    @NotBlank
    String author,

    @NotBlank
    String content,

    @ImageFile
    MultipartFile file
){}