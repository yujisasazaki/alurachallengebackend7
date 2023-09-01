package br.com.akrasia.alurachallengebackend7.model.destination;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import br.com.akrasia.alurachallengebackend7.validation.ImageFile;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record DestinationForm (

    @NotBlank
    String name,

    @DecimalMin(value = "0.0", inclusive = false)
    BigDecimal price,

    @ImageFile
    MultipartFile file    
){}
