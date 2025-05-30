package com.placar.placarizando.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PartidaDTO {
    private UUID idPartida;
    private String dataJogoInicial;
    private int setsVencidos;
    private int setsPerdidos;
    private int vencedorTimeA;
    private int vencedorTimeB;
    private String corTimeA;
    private String corTimeB;
    private String nomeTimeA;
    private String nomeTimeB;
}
