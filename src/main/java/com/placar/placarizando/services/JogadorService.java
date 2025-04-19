package com.placar.placarizando.services;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.entities.Time;

public interface JogadorService {

    void criarJogador(Jogador jogador);
    void excluirJogador(Jogador jogador);

    Jogador buscarJogadorPorNome(String nomeTime);

}
