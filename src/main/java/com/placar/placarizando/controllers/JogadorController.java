package com.placar.placarizando.controllers;

import com.placar.placarizando.dto.JogadorComNotaDTO;
import com.placar.placarizando.entities.Jogador;
import com.placar.placarizando.services.JogadorService;
import com.placar.placarizando.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

    @PutMapping("/alterarJogador/{id}")
    public ResponseEntity<?> editarJogador(@PathVariable UUID id, @RequestBody Jogador jogador) {
        try {
            jogadorService.editarJogador(id, jogador);
            return ResponseEntity.ok("Jogador atualizado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarJogadores")
    public ResponseEntity<Object> buscarJogadoresPorCodigo(@CookieValue("torneio_token") String token) {
        List<Jogador> jogadores = jogadorService.buscarJogadoresPeloCodigoCampeonato(token);

        if (jogadores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(jogadores);
    }

    @GetMapping("/buscarJogadoresRelacionadosAoTime")
    public ResponseEntity<Object> buscarJogadoresRelacionadosAoTime(@CookieValue("torneio_token") String token, @RequestParam String nomeTime) {
        List<JogadorComNotaDTO> jogadores = jogadorService.buscarJogadoresRelacionadosAoTime(token, nomeTime);

        if (!jogadores.isEmpty())
            return ResponseEntity.ok(jogadores);

        return ResponseEntity.ok(Map.of("mensagem", "Esse time não tem jogadores!"));
    }

    @DeleteMapping("/deletarJogador/{id}")
    public ResponseEntity<Object> deletarJogador(@PathVariable UUID id) {
        Jogador jogador = new Jogador();
        jogador.setIdJogador(id);
        jogadorService.excluirJogador(jogador);
        return ResponseEntity.status(HttpStatus.OK).body("Jogador deletado com sucesso!");
    }
}
