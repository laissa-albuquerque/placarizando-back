package com.placar.placarizando.controllers;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.entities.Time;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/time")
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @PostMapping("/criarTime")
    public ResponseEntity<Object> criarTime(@RequestBody Time time){
        timeService.criarTime(time);
        return ResponseEntity.status(HttpStatus.CREATED).body("Time criado com sucesso!");
    }
    @DeleteMapping("/deletarTime/{id}")
    public ResponseEntity<Object> deletarTime(@PathVariable UUID id) {
        Time time = new Time();
        time.setIdTime(id);
        timeService.deletarTime(time);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Time deletado com sucesso!");
    }

}
