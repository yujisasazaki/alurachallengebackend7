package br.com.akrasia.alurachallengebackend7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.akrasia.alurachallengebackend7.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}