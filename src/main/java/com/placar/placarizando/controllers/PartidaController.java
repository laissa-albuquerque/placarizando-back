package com.placar.placarizando.controllers;

import com.placar.placarizando.entities.Partida;
import com.placar.placarizando.entities.Set;
import com.placar.placarizando.services.PartidaService;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/partida")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaService partidaService;
    private final TimeService timeService;

    @PostMapping("/criarPartida")
    public ResponseEntity<Object> criarPartida(@RequestBody Partida partida,
                                               @RequestParam String timeA,
                                               @RequestParam String timeB,
                                               @CookieValue(value = "torneio_token", required = false) String torneioToken) {
        partida.getSet().setIdTimeA(timeService.buscarTimePorNome(timeA).getIdTime());
        partida.getSet().setIdTimeB(timeService.buscarTimePorNome(timeB).getIdTime());

        Set set = partida.getSet();
        set.setIdTimeA(timeService.buscarTimePorNome(timeA).getIdTime());
        set.setIdTimeB(timeService.buscarTimePorNome(timeB).getIdTime());
        set.setCodigoTorneio(torneioToken);

        partidaService.criarPartida(partida, torneioToken);
        return ResponseEntity.status(HttpStatus.CREATED).body("Partida criada com sucesso!");
    }
}
