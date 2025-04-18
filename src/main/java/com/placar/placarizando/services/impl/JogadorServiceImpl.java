package com.placar.placarizando.services.impl;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.repositories.JogadorRepository;
import com.placar.placarizando.services.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JogadorServiceImpl implements JogadorService {

    private final JogadorRepository jogadorRepository;

    @Override
    public void criarJogador(Jogador jogador) {
        jogadorRepository.save(jogador);
    }
}
