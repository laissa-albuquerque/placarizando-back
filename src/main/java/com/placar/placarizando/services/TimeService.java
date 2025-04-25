package com.placar.placarizando.services;

import com.placar.placarizando.entities.Time;

import java.util.List;

public interface TimeService {

    void criarTime(List<Time> times);
    void deletarTime(Time time);
    Time buscarTimePorNome(String nomeTime);
    List<Time> buscarTimesPorTorneio(String codigoTorneio);
}
