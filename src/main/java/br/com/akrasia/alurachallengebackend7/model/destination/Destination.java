package br.com.akrasia.alurachallengebackend7.model.destination;

import java.math.BigDecimal;

import br.com.akrasia.alurachallengebackend7.model.photo.Photo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "destination")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

    public void update(Photo photo, String name, BigDecimal price) {
        if (photo != null) {
            this.photo = photo;
        }
        if (name != null) {
            this.name = name;
        }
        if (price != null) {
            this.price = price;
        }
    }
}
