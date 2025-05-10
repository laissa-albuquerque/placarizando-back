package com.placar.placarizando.controllers;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.entities.Time;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/time")
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @PostMapping("/criarTime")
    public ResponseEntity<Object> criarTime(@CookieValue("torneio_token") String token, @RequestBody List<Time> times) {
        times.forEach(time -> time.setCodigoTorneio(token));
        timeService.criarTime(times);
        return ResponseEntity.status(HttpStatus.CREATED).body("Times criados com sucesso!");
    }

    @GetMapping
    public ResponseEntity<Object> buscarTodosOsTimes(@CookieValue("torneio_token") String token) {
        List<Time> timesCadastrados = timeService.buscarTimesPorTorneio(token);
        if(!timesCadastrados.isEmpty()) return ResponseEntity.status(HttpStatus.OK).body(timesCadastrados);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ainda não existem times cadastrados para esse torneio!");
    }

    @DeleteMapping("/deletarTime/{id}")
    public ResponseEntity<Object> deletarTime(@PathVariable UUID id) {
        Time time = new Time();
        time.setIdTime(id);
        timeService.deletarTime(time);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Time deletado com sucesso!");
    }

}
