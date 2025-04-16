package com.placar.placarizando.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
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

    @Column(name = "id_timeA")
    private Integer idTimeA;

    @Column(name = "id_timeB")
    private Integer idTimeB;

    @Column(name = "vencedor_timeA_partida")
    private Boolean vencedorTimeAPartida;

    @Column(name = "vencedor_timeB_partida")
    private Boolean vencedorTimeBPartida;
}
