package com.placar.placarizando.services;

import com.placar.placarizando.dto.JogadorComNotaDTO;
import com.placar.placarizando.entities.Jogador;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JogadorService {

    void criarJogador(Jogador jogador);
    void excluirJogador(Jogador jogador);
    void editarJogador(UUID id, Jogador jogadorAtualizado);
    Jogador buscarJogadorPorNome(String nomeTime);
    List<Jogador> buscarJogadoresPeloCodigoCampeonato(String codigoCampeonato);
    List<JogadorComNotaDTO> buscarJogadoresRelacionadosAoTime(String token, String nomeTime);
}
