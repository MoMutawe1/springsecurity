package com.springsecurity.digimon;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping( "api/v1/digimons")
public class DigimonController {

    private static final List<Digimon> DIGIMONS = Arrays.asList(
       new Digimon(1, "Agumon"),
       new Digimon(2, "Betsumon"),
       new Digimon(3, "Beelzemon")
    );

    @GetMapping(path = "{digimonId}")
    public Digimon getDigimon(@PathVariable("digimonId")  Integer digimonId){
        return DIGIMONS.stream()
                .filter(digimon -> digimonId.equals(digimon.getDigimonId())).findFirst()
                .orElseThrow(() -> new IllegalStateException("Digimon with Id: " + digimonId + " doesn't exists"));
    }
}
