package com.placar.placarizando.controllers;

import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.services.JogadorService;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Optional<Jogador> jogadores = jogadorService.buscarJogadoresPeloCodigoCampeonato(token);

        if (jogadores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(jogadores);
    }

    @DeleteMapping("/deletarJogador/{id}")
    public ResponseEntity<Object> deletarJogador(@PathVariable UUID id) {
        Jogador jogador = new Jogador();
        jogador.setIdJogador(id);
        jogadorService.excluirJogador(jogador);
        return ResponseEntity.status(HttpStatus.OK).body("Jogador deletado com sucesso!");
    }
}
