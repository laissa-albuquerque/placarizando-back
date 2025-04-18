package com.placar.placarizando.services.impl;

import com.placar.placarizando.entities.Time;
import com.placar.placarizando.repositories.TimeRepository;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService {

    private final TimeRepository timeRepository;

    @Override
    public void criarTime(Time time) {
        timeRepository.save(time);
    }

    @Override
    public Time buscarTimePorNome(String nomeTime) {
        return timeRepository.findByNomeTime(nomeTime);
    }
}
