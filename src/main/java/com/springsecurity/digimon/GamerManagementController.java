package com.springsecurity.digimon;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping( "management/api/v1/digimons")
public class GamerManagementController {

    private static final List<Digimon> DIGIMONS = Arrays.asList(
            new Digimon(1, "Agumon"),
            new Digimon(2, "Betsumon"),
            new Digimon(3, "Beelzemon")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Digimon> getAllDegimons(){
        System.out.println("getAllDegimons");
        return DIGIMONS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('player:upgrade')")
    public void createNewDigimon(Digimon digimon){
        System.out.println("createNewDigimon");
        System.out.println(digimon);
    }

    @DeleteMapping(path = "{digimonId}")
    @PreAuthorize("hasAuthority('player:upgrade')")
    public void deleteDigimon(@PathVariable("digimonId") Integer digimonId){
        System.out.println("deleteDigimon");
        System.out.println(digimonId);
    }

    @PutMapping(path = "{digimonId}")
    @PreAuthorize("hasAuthority('player:upgrade')")
    public void updateDigimon(@PathVariable("digimonId") Integer digimonId, @RequestBody Digimon digimon){
        System.out.println("updateDigimon");
        System.out.println(String.format("%s %s", digimonId, digimon));
    }
}
