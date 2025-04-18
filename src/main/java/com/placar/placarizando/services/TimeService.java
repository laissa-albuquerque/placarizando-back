package com.placar.placarizando.services;

import com.placar.placarizando.entities.Time;

public interface TimeService {

    void criarTime(Time time);

    Time buscarTimePorNome(String nomeTime);
}
