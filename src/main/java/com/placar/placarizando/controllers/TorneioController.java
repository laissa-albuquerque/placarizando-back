package com.placar.placarizando.controllers;

import com.placar.placarizando.services.TorneioService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping(value = "/torneio")
@RequiredArgsConstructor
public class TorneioController {

    private final TorneioService torneioService;

    @GetMapping
    public ResponseEntity<Object> gerarCodigo(HttpServletResponse response) {

        String codigoTorneio = torneioService.gerarCodigo();

        ResponseCookie cookie = ResponseCookie.from("torneio_token", codigoTorneio)
                .httpOnly(true)
                .secure(false)
                .sameSite("Strict")
                .path("/")
                .maxAge(Duration.ofMinutes(3))
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(torneioService.gerarCodigo());
    }

}
