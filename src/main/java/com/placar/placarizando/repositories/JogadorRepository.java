package com.placar.placarizando.repositories;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.entities.dto.JogadorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, UUID> {

    Jogador findByNomeJogador(String nomeTime);
    Optional<Jogador> findByNomeJogadorAndCodigoTorneio(String nomeJogador, String codigoTorneio);
    List<JogadorDTO> findAllByCodigoTorneio(String codigoTorneio);

    @Query(value = """
            SELECT j.id_jogador, j.nome_jogador, j.nota
            FROM tb_jogador j
                INNER JOIN tb_time t ON j.id_time = t.id_time
            WHERE j.id_time = :idTime
                AND j.codigo_torneio = :token;
    """, nativeQuery = true)
    List<JogadorDTO> buscarJogadoresPorTime(@Param("token") String token, @Param("idTime") UUID idTime);

}
