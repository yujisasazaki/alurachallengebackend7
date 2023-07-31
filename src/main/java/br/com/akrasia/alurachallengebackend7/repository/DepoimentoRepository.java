package br.com.akrasia.alurachallengebackend7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.akrasia.alurachallengebackend7.model.Depoimento;

public interface DepoimentoRepository extends JpaRepository<Depoimento, Long>{
    
}
