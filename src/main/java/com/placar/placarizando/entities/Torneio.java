package com.placar.placarizando.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Table(name = "TB_TORNEIO")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Torneio implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_torneio")
    private UUID idTorneio;

    @Column(name = "codigo_torneio", nullable = false)
    @NotBlank
    private String codigoTorneio;
}
