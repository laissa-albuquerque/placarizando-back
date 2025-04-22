package com.placar.placarizando.services;

import com.placar.placarizando.entities.Jogador;

import java.util.Optional;

public interface JogadorService {

    void criarJogador(Jogador jogador);
    void excluirJogador(Jogador jogador);
    Jogador buscarJogadorPorNome(String nomeTime);
    Optional<Jogador> buscarJogadoresPeloCodigoCampeonato(String codigoCampeonato);

}
