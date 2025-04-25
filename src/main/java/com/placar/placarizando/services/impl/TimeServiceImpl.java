package com.placar.placarizando.services.impl;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.entities.Time;
import com.placar.placarizando.repositories.TimeRepository;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService {

    private final TimeRepository timeRepository;

    @Override
    public void criarTime(List<Time> times) {
        if (!times.isEmpty()) {
            timeRepository.saveAll(times);
        }
    }

    @Override
    public List<Time> buscarTimesPorTorneio(String codigoTorneio) {
        return timeRepository.findAllByCodigoTorneio(codigoTorneio);
    }

    @Override
    public Time buscarTimePorNome(String nomeTime) {
        return timeRepository.findByNomeTime(nomeTime);
    }

    @Override
    public void deletarTime(Time time) {
        timeRepository.delete(time);
    }
}
