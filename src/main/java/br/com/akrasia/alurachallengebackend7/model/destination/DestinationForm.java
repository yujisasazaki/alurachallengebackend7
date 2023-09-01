package br.com.akrasia.alurachallengebackend7.model.destination;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import br.com.akrasia.alurachallengebackend7.validation.ImageFile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DestinationForm (

    @NotBlank
    String name,

    @NotNull
    BigDecimal price,

    @ImageFile
    MultipartFile file    
){}
