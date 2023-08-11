package br.com.akrasia.alurachallengebackend7.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.akrasia.alurachallengebackend7.model.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

    Optional<Comment> findById(Long id);
    
}