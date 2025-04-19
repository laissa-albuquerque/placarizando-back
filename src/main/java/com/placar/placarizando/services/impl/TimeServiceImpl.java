package com.placar.placarizando.services.impl;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.entities.Time;
import com.placar.placarizando.repositories.TimeRepository;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService {

    private final TimeRepository timeRepository;

    @Override
    public void criarTime(Time time) {
        Optional<Time> timeExists = Optional.ofNullable(this.buscarTimePorNome(time.getNomeTime()));

        if (timeExists.isPresent()) {
            throw new RuntimeException("Time com o nome " + time.getNomeTime() + " já existe!");
        }

        timeRepository.save(time);
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
