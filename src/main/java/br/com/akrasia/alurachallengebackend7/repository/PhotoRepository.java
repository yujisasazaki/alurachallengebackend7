package br.com.akrasia.alurachallengebackend7.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.akrasia.alurachallengebackend7.model.photo.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    Optional<Photo> findById(Long id);

}