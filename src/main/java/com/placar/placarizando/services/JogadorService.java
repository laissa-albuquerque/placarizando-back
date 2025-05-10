package com.placar.placarizando.services;

import com.placar.placarizando.entities.Jogador;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JogadorService {

    void criarJogador(Jogador jogador);
    void excluirJogador(UUID idJogador);
    Optional<Jogador> buscarJogadorPorId(UUID id);
    List<Jogador> buscarJogadoresPorCampeonato(String codigoCampeonato);
    List<String> buscarJogadoresPorTime(String token, UUID idTime);
}
