package br.com.akrasia.alurachallengebackend7.model.comment;

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
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String content;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

    public void update(Photo photo, String author, String content) {
        if (photo != null) {
            this.photo = photo;
        }
        if (author != null) {
            this.author = author;
        }
        if (content != null) {
            this.content = content;
        }
    }

}
