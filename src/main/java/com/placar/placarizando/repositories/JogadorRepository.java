package com.placar.placarizando.repositories;

import com.placar.placarizando.dto.JogadorComNotaDTO;
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

    Jogador findByNomeJogador(String nomeTime);
    Optional<Jogador> findByNomeJogadorAndCodigoTorneio(String nomeJogador, String codigoTorneio);
    List<Jogador> findAllByCodigoTorneio(String codigoTorneio);

    @Query(value = """
        SELECT j.nome_jogador as nomeJogador, j.nota as nota
        FROM tb_jogador j
        INNER JOIN tb_time t ON t.codigo_torneio = j.codigo_torneio
        AND t.id_time = j.id_time
        WHERE LOWER(TRIM(t.nome_time)) = LOWER(TRIM(:nomeTime))
        AND LOWER(TRIM(j.codigo_torneio)) = LOWER(TRIM(:token))
    """, nativeQuery = true)
    List<JogadorComNotaDTO> buscarJogadoresRelacionadosAoTime(@Param("token") String token, @Param("nomeTime") String nomeTime);

}
