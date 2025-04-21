package com.placar.placarizando.controllers;

import com.placar.placarizando.services.TorneioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/torneio")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class TorneioController {

    private final TorneioService torneioService;

    @GetMapping
    public ResponseEntity<Object> gerarCodigo() {
        return ResponseEntity.status(HttpStatus.CREATED).body(torneioService.gerarCodigo());
    }

}
