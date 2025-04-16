package com.placar.placarizando.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "TB_PARTIDA")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Partida implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_partida")
    private UUID idPartida;

    @Column(name = "data_jogo_inicial")
    private LocalDateTime dataJogoInicial;

    @Column(name = "id_set")
    private UUID idSet;

}
