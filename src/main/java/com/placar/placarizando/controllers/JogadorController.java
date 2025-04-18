package com.placar.placarizando.controllers;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.services.JogadorService;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/jogador")
@RequiredArgsConstructor
public class JogadorController {

    private final JogadorService jogadorService;
    private final TimeService timeService;

    @PostMapping("/criarJogador")
    public ResponseEntity<Object> criarJogador(@RequestBody Jogador jogador,
                                               @RequestParam String nomeTime) {
        jogador.setTime(timeService.buscarTimePorNome(nomeTime));
        jogadorService.criarJogador(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body("Jogador criado com sucesso!");
    }
}
