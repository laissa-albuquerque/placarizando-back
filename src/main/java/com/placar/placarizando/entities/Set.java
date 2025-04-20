package com.placar.placarizando.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Table(name = "TB_SET")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Set implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_set")
    private UUID idSet;

    @Column(name = "primeiro_set_timeA")
    private int primeiroSetTimeA;

    @Column(name = "primeiro_set_timeB")
    private int primeiroSetTimeB;

    @Column(name = "segundo_set_timeA")
    private int segundoSetTimeA;

    @Column(name = "segundo_set_timeB")
    private int segundoSetTimeB;

    @Column(name = "terceiro_set_timeA")
    private int terceiroSetTimeA;

    @Column(name = "terceiro_set_timeB")
    private int terceiroSetTimeB;

    @Column(name = "id_timeA", nullable = false)
    @NotNull
    private UUID idTimeA;

    @Column(name = "id_timeB", nullable = false)
    @NotNull
    private UUID idTimeB;

    @Column(name = "vencedor_partida_timeA")
    private Boolean vencedorPartidaTimeA;

    @Column(name = "vencedor_partida_timeB")
    private Boolean vencedorPartidaTimeB;

    @Column(name = "codigo_unico", nullable = false)
    @NotBlank
    private String codigoUnico;
}
