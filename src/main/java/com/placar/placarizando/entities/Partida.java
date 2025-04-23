package com.placar.placarizando.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private UUID idPartida;

    @Column(name = "data_jogo_inicial", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataJogoInicial;

    @Column(name = "codigo_torneio", nullable = false)
    @NotBlank
    private String codigoTorneio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_set", referencedColumnName = "id_set")
    private Set set;
}
