package br.com.akrasia.alurachallengebackend7.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.akrasia.alurachallengebackend7.model.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

    Optional<Comment> findById(Long id);

    @Query("""
            SELECT
                c
            FROM
                Comment c
            ORDER BY random()
            LIMIT :quantity
            """)
    Optional<List<Comment>> findRandomComments(int quantity);
    
}