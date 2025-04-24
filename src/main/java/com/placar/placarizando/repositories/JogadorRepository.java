package com.placar.placarizando.repositories;

import com.placar.placarizando.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, UUID> {

    Jogador findByNomeJogador(String nomeTime);
    Optional<Jogador> findByNomeJogadorAndCodigoTorneio(String nomeJogador, String codigoTorneio);
    List<Jogador> findAllByCodigoTorneio(String codigoTorneio);
    List<Jogador> findAllByIdTime(UUID idTime);
}
