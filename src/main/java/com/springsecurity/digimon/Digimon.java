package com.springsecurity.digimon;

public class Digimon {

    private final Integer digimonId;
    private final String digimonName;

    public Digimon(Integer digimonId, String digimonName) {
        this.digimonId = digimonId;
        this.digimonName = digimonName;
    }

    public Integer getDigimonId() {
        return digimonId;
    }

    public String getDigimonName() {
        return digimonName;
    }
}
