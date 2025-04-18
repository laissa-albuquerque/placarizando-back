package com.placar.placarizando.controllers;

import com.placar.placarizando.entities.Time;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/time")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @PostMapping("/criarTime")
    public ResponseEntity<Object> criarTime(@RequestBody Time time){
        timeService.criarTime(time);
        return ResponseEntity.status(HttpStatus.CREATED).body("Time criado com sucesso!");
    }
}
