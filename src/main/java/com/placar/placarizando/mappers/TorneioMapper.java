package com.placar.placarizando.mappers;

import com.placar.placarizando.entities.Torneio;
import org.springframework.stereotype.Component;

@Component
public class TorneioMapper {

    public static Torneio toTorneio(String codigo) {
        return Torneio.builder()
                .codigoTorneio(codigo)
                .build();
    }
}
