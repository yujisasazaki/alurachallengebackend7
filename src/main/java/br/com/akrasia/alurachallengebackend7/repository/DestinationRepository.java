package br.com.akrasia.alurachallengebackend7.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.akrasia.alurachallengebackend7.model.destination.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long>{

    Optional<Destination> findById(Long id);

    Optional<List<Destination>> findByName(String name);    
}
