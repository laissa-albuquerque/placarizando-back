package com.placar.placarizando.services.impl;

import com.placar.placarizando.entities.Partida;
import com.placar.placarizando.repositories.PartidaRepository;
import com.placar.placarizando.services.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PartidaServiceImpl implements PartidaService {

    private final PartidaRepository partidaRepository;

    @Override
    public void criarPartida(Partida partida) {
        partida.setDataJogoInicial(LocalDateTime.now());
        partidaRepository.save(partida);
    }
}
