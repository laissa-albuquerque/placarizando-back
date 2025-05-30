package com.placar.placarizando.services;

import com.placar.placarizando.entities.Partida;
import com.placar.placarizando.entities.dto.PartidaDTO;

import java.util.List;

public interface PartidaService {

    void criarPartida(Partida partida, String torneioToken);
    List<PartidaDTO> buscarPartidas(String torneioToken);
}
