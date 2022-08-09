package com.ppsoo.model.entities.condimentos.coberturas;

import com.ppsoo.model.entities.Bolo;
import com.ppsoo.model.entities.condimentos.CondimentDecorator;

public class CoberturaMorango extends CondimentDecorator {

    Bolo bolo;

    public CoberturaMorango(Bolo bolo) {
        this.bolo = bolo;
        this.setCobertura("Cobertura de Morango");
        this.setRecheio(bolo.getRecheio());
        this.setCamada(bolo.getCamada());
    }

    @Override
    public double preco() {
        return this.bolo.preco() + 3;
    }
    
}
