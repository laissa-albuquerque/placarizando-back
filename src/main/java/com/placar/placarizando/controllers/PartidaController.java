package com.placar.placarizando.controllers;

import com.placar.placarizando.entities.Partida;
import com.placar.placarizando.services.PartidaService;
import com.placar.placarizando.services.SetService;
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
    private final SetService setService;
    private final TimeService timeService;

    @PostMapping("/criarPartida")
    public ResponseEntity<Object> criarPartida(@RequestBody Partida partida, @RequestParam String timeA, @RequestParam String timeB) {
        partida.getSet().setIdTimeA(timeService.buscarTimePorNome(timeA).getIdTime());
        partida.getSet().setIdTimeB(timeService.buscarTimePorNome(timeB).getIdTime());
        setService.criarSet(partida.getSet());
        partidaService.criarPartida(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body("Partida criada com sucesso!");
    }
}
