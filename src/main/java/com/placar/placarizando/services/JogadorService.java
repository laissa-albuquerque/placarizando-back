package com.placar.placarizando.services;

import com.placar.placarizando.entities.Jogador;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JogadorService {

    void criarJogador(Jogador jogador);
    void excluirJogador(Jogador jogador);
    Jogador buscarJogadorPorNome(String nomeTime);
    List<Jogador> buscarJogadoresPeloCodigoCampeonato(String codigoCampeonato);
    Jogador editarJogador(UUID id, Jogador jogador);
    List<Jogador> buscarJogadoresPeloTime(UUID idTime);

}
