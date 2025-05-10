package com.placar.placarizando.services.impl;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.repositories.JogadorRepository;
import com.placar.placarizando.services.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JogadorServiceImpl implements JogadorService {

    private final JogadorRepository jogadorRepository;

    @Override
    public void criarJogador(Jogador jogador) {
        Optional<Jogador> jogadorExistente = jogadorRepository.findByNomeJogadorAndCodigoTorneio(
                jogador.getNomeJogador(), jogador.getCodigoTorneio()
        );

        if (jogadorExistente.isPresent()) {
            throw new RuntimeException("Jogador com o nome " + jogador.getNomeJogador() +
                    " já cadastrado!");
        }

        jogadorRepository.save(jogador);
    }

    @Override
    public Optional<Jogador> buscarJogadorPorId(UUID id) {
        return jogadorRepository.findById(id);
    }

    @Override
    public List<Jogador> buscarJogadoresPorCampeonato(String codigoCampeonato) {
        return jogadorRepository.findAllByCodigoTorneio(codigoCampeonato);
    }

    @Override
    public List<String> buscarJogadoresPorTime(String token, UUID idTime) {
        return jogadorRepository.buscarJogadoresPorTime(token, idTime);
    }

    @Override
    public void excluirJogador(UUID idJogador) {
        jogadorRepository.deleteById(idJogador);
    }
}
