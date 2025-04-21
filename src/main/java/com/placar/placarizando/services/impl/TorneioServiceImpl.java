package com.placar.placarizando.services.impl;

import com.placar.placarizando.services.TorneioService;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

@Service
public class TorneioServiceImpl implements TorneioService {

    @Override
    public String gerarCodigo() {
        RandomStringGenerator gerador = new RandomStringGenerator.Builder()
                .withinRange(33, 126)
                .build();

        return "placar-" + gerador.generate(6);
    }
}
