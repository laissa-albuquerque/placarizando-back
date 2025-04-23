package com.placar.placarizando.services.impl;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.repositories.JogadorRepository;
import com.placar.placarizando.services.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Jogador buscarJogadorPorNome(String nomeJogador) {
        return jogadorRepository.findByNomeJogador(nomeJogador);
    }

    @Override
    public List<Jogador> buscarJogadoresPeloCodigoCampeonato(String codigoCampeonato) {
        return jogadorRepository.findAllByCodigoTorneio(codigoCampeonato);
    }

    @Override
    public void excluirJogador(Jogador jogador) {
        jogadorRepository.delete(jogador);
    }
}
