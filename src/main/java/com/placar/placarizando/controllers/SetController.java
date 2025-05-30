package com.placar.placarizando.controllers;

import com.placar.placarizando.services.SetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/set")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class SetController {

    private final SetService setService;


}
