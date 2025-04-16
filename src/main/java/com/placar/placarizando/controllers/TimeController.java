package com.placar.placarizando.controllers;

import com.placar.placarizando.entities.Time;
import com.placar.placarizando.services.impl.TimeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/time")
@RequiredArgsConstructor
public class TimeController {

    private final TimeServiceImpl timeService;

    @PostMapping("/criarTime")
    public ResponseEntity<Object> criarTime(@RequestBody Time time){
        timeService.criarTime(time);
        return ResponseEntity.status(HttpStatus.CREATED).body("Time criado com sucesso!");
    }
}
