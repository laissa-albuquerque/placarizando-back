package com.placar.placarizando.services.impl;

import com.placar.placarizando.entities.Set;
import com.placar.placarizando.repositories.SetRepository;
import com.placar.placarizando.services.SetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SetServiceImpl implements SetService {

    private final SetRepository setRepository;

    @Override
    public void criarSet(Set set) {
        setRepository.save(set);
    }
}
