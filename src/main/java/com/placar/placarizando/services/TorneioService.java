package com.placar.placarizando.services;

import com.placar.placarizando.entities.Torneio;

import java.util.Optional;

public interface TorneioService {

    String gerarCodigo();
    Optional<Torneio> buscarTorneio(String codigoTorneio);
}
