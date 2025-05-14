package com.placar.placarizando.services;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.entities.dto.JogadorDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JogadorService {

    void criarJogador(Jogador jogador);
    void excluirJogador(UUID idJogador);
    Optional<Jogador> buscarJogadorPorId(UUID id);
    List<JogadorDTO> buscarJogadoresPorCampeonato(String codigoCampeonato);
    List<JogadorDTO> buscarJogadoresPorTime(String token, UUID idTime);
    void editarJogador(UUID id, Jogador jogadorAtualizado);
}
