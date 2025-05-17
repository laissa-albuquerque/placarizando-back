package com.placar.placarizando.controllers;

import com.placar.placarizando.entities.Partida;
import com.placar.placarizando.entities.Set;
import com.placar.placarizando.services.PartidaService;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/partida")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaService partidaService;
    private final TimeService timeService;

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
