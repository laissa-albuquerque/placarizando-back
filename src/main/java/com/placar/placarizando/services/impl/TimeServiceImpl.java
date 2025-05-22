package com.placar.placarizando.services.impl;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.entities.Time;
import com.placar.placarizando.entities.dto.JogadorDTO;
import com.placar.placarizando.repositories.JogadorRepository;
import com.placar.placarizando.repositories.TimeRepository;
import com.placar.placarizando.services.JogadorService;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService {

    private final TimeRepository timeRepository;
    private final JogadorService jogadorService;
    private final JogadorRepository jogadorRepository;

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

    @Override
    public Optional<Time> buscarTimePorId(UUID idTime) {
        return timeRepository.findById(idTime);
    }

    @Override
    public void sortearTime(String codigoTorneio) {
        List<JogadorDTO> jogadoresDisponiveis = jogadorService.buscarJogadoresPorCampeonato(codigoTorneio);
        List<Time> timesDisponiveis = timeRepository.findAllByCodigoTorneio(codigoTorneio);

        boolean todosTemNota = jogadoresDisponiveis.stream().allMatch(j -> j.getNota() != null);

        if (!todosTemNota || timesDisponiveis.size() != 2) return;

        jogadoresDisponiveis.sort(Comparator.comparing(JogadorDTO::getNota).reversed());

        List<Jogador> jogadoresTimeA = new ArrayList<>();
        List<Jogador> jogadoresTimeB = new ArrayList<>();
        int somaNotaA = 0;
        int somaNotaB = 0;

        for (JogadorDTO jogadorDTO : jogadoresDisponiveis) {
            Optional<Jogador> optJogador = jogadorService.buscarJogadorPorId(jogadorDTO.getIdJogador());
            if (optJogador.isEmpty()) continue;

            Jogador jogador = optJogador.get();

            if (jogadoresTimeA.size() < 6 && (somaNotaA <= somaNotaB || jogadoresTimeB.size() >= 6)) {
                jogador.setIdTime(timesDisponiveis.get(0).getIdTime());
                jogadoresTimeA.add(jogador);
                somaNotaA += jogador.getNota();
            } else {
                jogador.setIdTime(timesDisponiveis.get(1).getIdTime());
                jogadoresTimeB.add(jogador);
                somaNotaB += jogador.getNota();
            }
        }

        balancearTimes(jogadoresTimeA, jogadoresTimeB, timesDisponiveis);
        jogadorRepository.saveAll(jogadoresTimeA);
        jogadorRepository.saveAll(jogadoresTimeB);
    }

    private void balancearTimes(List<Jogador> timeA, List<Jogador> timeB, List<Time> times) {
        int somaA = timeA.stream().mapToInt(Jogador::getNota).sum();
        int somaB = timeB.stream().mapToInt(Jogador::getNota).sum();
        int diffAtual = Math.abs(somaA - somaB);

        int melhorDiff = diffAtual;
        Jogador melhorA = null;
        Jogador melhorB = null;

        outer:
        for (Jogador a : timeA) {
            for (Jogador b : timeB) {
                int novaSomaA = somaA - a.getNota() + b.getNota();
                int novaSomaB = somaB - b.getNota() + a.getNota();
                int novaDiff = Math.abs(novaSomaA - novaSomaB);

                if (novaDiff < melhorDiff) {
                    melhorDiff = novaDiff;
                    melhorA = a;
                    melhorB = b;
                }

                if (melhorDiff == 0) break outer;
            }
        }

        if (melhorA != null && melhorB != null) {
            timeA.remove(melhorA);
            timeB.remove(melhorB);

            melhorA.setIdTime(times.get(1).getIdTime());
            melhorB.setIdTime(times.get(0).getIdTime());

            timeA.add(melhorB);
            timeB.add(melhorA);
        }
    }
}
