package com.placar.placarizando.controllers;

import com.placar.placarizando.entities.Partida;
import com.placar.placarizando.entities.Set;
import com.placar.placarizando.entities.dto.PartidaDTO;
import com.placar.placarizando.services.PartidaService;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/partida")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaService partidaService;
    private final TimeService timeService;

    @GetMapping("/buscarPartidas")
    public ResponseEntity<List<PartidaDTO>> buscarPartidas(@CookieValue(value = "torneio_token") String torneioToken) {
        List<PartidaDTO> partidas = partidaService.buscarPartidas(torneioToken);

        if (partidas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(partidas);
        }
    }

    @PostMapping("/criarPartida/{idTimeA}/{idTimeB}")
    public ResponseEntity<Object> criarPartida(@RequestBody Partida partida,
                                               @PathVariable("idTimeA") UUID idTimeA,
                                               @PathVariable("idTimeB") UUID idTimeB,
                                               @CookieValue(value = "torneio_token") String torneioToken) {

        UUID timeAId = timeService.buscarTimePorId(idTimeA).get().getIdTime();
        UUID timeBId = timeService.buscarTimePorId(idTimeB).get().getIdTime();

        Set set = partida.getSet();
        set.setIdTimeA(timeAId);
        set.setIdTimeB(timeBId);
        set.setCodigoTorneio(torneioToken);

        partidaService.criarPartida(partida, torneioToken);
        return ResponseEntity.status(HttpStatus.CREATED).body("Partida criada com sucesso!");
    }
}
