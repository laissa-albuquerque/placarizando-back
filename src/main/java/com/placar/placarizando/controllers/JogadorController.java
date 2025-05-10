package com.placar.placarizando.controllers;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.entities.Time;
import com.placar.placarizando.services.JogadorService;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/jogador")
@RequiredArgsConstructor
public class JogadorController {

    private final JogadorService jogadorService;
    private final TimeService timeService;

    @PostMapping("/criarJogador")
    public ResponseEntity<Object> criarJogadores(@CookieValue("torneio_token") String token, @RequestBody List<Jogador> jogadores) {
        for (Jogador jogador : jogadores) {
            jogador.setCodigoTorneio(token);
            jogadorService.criarJogador(jogador);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Jogadores salvos com sucesso!");
    }

    @GetMapping("/buscarJogadores")
    public ResponseEntity<Object> buscarJogadoresPorCodigo(@CookieValue("torneio_token") String token) {
        List<Jogador> jogadores = jogadorService.buscarJogadoresPorCampeonato(token);

        if (jogadores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(jogadores);
    }

    @GetMapping("/buscarJogadoresPorTime/{idTime}")
    public ResponseEntity<Object> buscarJogadoresPorTime(@CookieValue("torneio_token") String token, @PathVariable UUID idTime) {
        Optional<Time> time = timeService.buscarTimePorId(idTime);

        if(time.isPresent()) {
            List<String> jogadores = jogadorService.buscarJogadoresPorTime(token, idTime);
            if(!jogadores.isEmpty()) return ResponseEntity.status(HttpStatus.OK).body(jogadores);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(List.of());
    }

    @DeleteMapping("/deletarJogador/{id}")
    public ResponseEntity<Object> deletarJogador(@PathVariable UUID id) {
        Optional<Jogador> jogadorExiste = jogadorService.buscarJogadorPorId(id);
        if (jogadorExiste.isPresent()) {
            jogadorService.excluirJogador(id);
            return ResponseEntity.status(HttpStatus.OK).body("Jogador deletado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogador não encontrado!");
    }
}
