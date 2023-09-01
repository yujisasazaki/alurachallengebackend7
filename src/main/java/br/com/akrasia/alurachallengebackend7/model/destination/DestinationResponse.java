package br.com.akrasia.alurachallengebackend7.model.destination;

import java.math.BigDecimal;

public record DestinationResponse (
    String name,
    BigDecimal price,
    String photoUrl
){

    public DestinationResponse(Destination destination, String photoUrl) {
        this(destination.getName(), destination.getPrice(), photoUrl);
    }
    
}
