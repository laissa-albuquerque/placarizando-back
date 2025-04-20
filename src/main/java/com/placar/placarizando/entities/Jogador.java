package com.placar.placarizando.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Table(name = "TB_JOGADOR")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Jogador implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_jogador")
    private UUID idJogador;

    @Column(name = "nome_jogador")
    @NotBlank
    private String nomeJogador;

    @Column
    private Integer nota;

    @Column(name = "codigo_unico", nullable = false)
    @NotBlank
    private String codigoUnico;

    @Column(name = "id_time")
    private UUID idTime;
}
