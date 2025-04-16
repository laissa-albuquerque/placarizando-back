package com.placar.placarizando.repositories;

import com.placar.placarizando.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, UUID> {

}
