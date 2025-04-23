package com.placar.placarizando.services.impl;

import com.placar.placarizando.entities.Torneio;
import com.placar.placarizando.repositories.TorneioRepository;
import com.placar.placarizando.services.TorneioService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.placar.placarizando.mappers.TorneioMapper.toTorneio;

@Service
@RequiredArgsConstructor
public class TorneioServiceImpl implements TorneioService {

    private final TorneioRepository torneioRepository;

    @Override
    public String gerarCodigo() {
        RandomStringGenerator gerador = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(Character::isLetterOrDigit)
                .build();

        String codigoGerado;
        do {
            codigoGerado = "placar-" + gerador.generate(6);
        } while (validarSeCodigoExiste(codigoGerado));

        torneioRepository.save(toTorneio(codigoGerado));
        return codigoGerado;
    }

    @Override
    public Optional<Torneio> buscarTorneio(String codigoTorneio) {
        return torneioRepository.findByCodigoTorneio(codigoTorneio);
    }


    private Boolean validarSeCodigoExiste(String codigoGerado) {
        return torneioRepository.findByCodigoTorneio(codigoGerado).isPresent();
    }
}
