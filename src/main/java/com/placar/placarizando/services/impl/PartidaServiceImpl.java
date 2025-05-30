package com.placar.placarizando.services.impl;

import com.placar.placarizando.entities.Partida;
import com.placar.placarizando.entities.Set;
import com.placar.placarizando.entities.Time;
import com.placar.placarizando.entities.dto.PartidaDTO;
import com.placar.placarizando.repositories.PartidaRepository;
import com.placar.placarizando.repositories.TimeRepository;
import com.placar.placarizando.services.PartidaService;
import com.placar.placarizando.services.SetService;
import jakarta.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PartidaServiceImpl implements PartidaService {

    private final PartidaRepository partidaRepository;
    private final TimeRepository timeRepository;

    @Override
    public void criarPartida(Partida partida, String torneioToken) {
        partida.setDataJogoInicial(LocalDateTime.now());
        partida.setCodigoTorneio(torneioToken);
        partidaRepository.save(partida);
    }

    @Override
    public List<PartidaDTO> buscarPartidas(String torneioToken) {
        List<Partida> partidas = partidaRepository.findByCodigoTorneio(torneioToken);
        List<PartidaDTO> partidasDTO = new ArrayList<>();

        for (Partida partida : partidas) {
            partidasDTO.add(this.mapToDTO(partida));
        }

        return partidasDTO;
    }

    public Map<String, Integer> calcularSets(Partida partida) {
        Set set = partida.getSet();

        boolean vencedorA = Boolean.TRUE.equals(set.getVencedorPartidaTimeA());
        boolean vencedorB = Boolean.TRUE.equals(set.getVencedorPartidaTimeB());

        int setsVencidos = 0;
        int setsPerdidos = 0;

        int[][] sets = {
                {set.getPrimeiroSetTimeA(), set.getPrimeiroSetTimeB()},
                {set.getSegundoSetTimeA(), set.getSegundoSetTimeB()},
                {set.getTerceiroSetTimeA(), set.getTerceiroSetTimeB()}
        };

        for (int[] s : sets) {
            int pontosA = s[0];
            int pontosB = s[1];

            if ((pontosA > pontosB && vencedorA) || (pontosB > pontosA && vencedorB)) {
                setsVencidos++;
            } else if ((pontosA > pontosB && !vencedorA) || (pontosB > pontosA && !vencedorB)) {
                setsPerdidos++;
            }
        }

        Map<String, Integer> resultado = new HashMap<>();
        resultado.put("setsVencidos", setsVencidos);
        resultado.put("setsPerdidos", setsPerdidos);
        resultado.put("vencedorTimeA", vencedorA ? 1 : 0);
        resultado.put("vencedorTimeB", vencedorB ? 1 : 0);

        return resultado;
    }

    public PartidaDTO mapToDTO(Partida partida) {
        Set set = partida.getSet();

        Optional<Time> timeA = timeRepository.findById(set.getIdTimeA());
        Optional<Time> timeB = timeRepository.findById(set.getIdTimeB());

        String corTimeA = timeA.isPresent() ? timeA.get().getCorReferencia() : "#f17d60";
        String corTimeB = timeB.isPresent() ? timeB.get().getCorReferencia() : "#00aad3";

        String nomeTimeA = timeA.isPresent() ? timeA.get().getNomeTime() : "Casa";
        String nomeTimeB = timeB.isPresent() ? timeB.get().getNomeTime() : "Visitante";

        Map<String, Integer> resultadoSets = calcularSets(partida);

        int setsVencidos = resultadoSets.getOrDefault("setsVencidos", 0);
        int setsPerdidos = resultadoSets.getOrDefault("setsPerdidos", 0);

        int vencedorTimeA = resultadoSets.getOrDefault("vencedorTimeA", 0);
        int vencedorTimeB = resultadoSets.getOrDefault("vencedorTimeB", 0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH'H'mm");
        String dataJogoInicial = partida.getDataJogoInicial().format(formatter);

        return new PartidaDTO(
                partida.getIdPartida(),
                dataJogoInicial,
                setsVencidos,
                setsPerdidos,
                vencedorTimeA,
                vencedorTimeB,
                corTimeA,
                corTimeB,
                nomeTimeA,
                nomeTimeB
        );
    }
}
