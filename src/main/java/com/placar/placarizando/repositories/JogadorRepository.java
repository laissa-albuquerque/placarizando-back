package com.placar.placarizando.repositories;

import com.placar.placarizando.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, UUID> {

    Optional<Jogador> findByNomeJogador(String nomeTime);
    Optional<Jogador> findByNomeJogadorAndCodigoTorneio(String nomeJogador, String codigoTorneio);
    List<Jogador> findAllByCodigoTorneio(String codigoTorneio);

    @Query(value = """
            SELECT j.nome_jogador
            FROM tb_jogador j
            INNER JOIN tb_time t ON t.codigo_torneio = j.codigo_torneio
            WHERE t.nome_time = :nomeTime
            and j.codigo_torneio = :token
            """ , nativeQuery = true)
    List<String> buscarJogadoresRelacionadosAoTime(@Param("token") String token, @Param("nomeTime") String nomeTime);
}
