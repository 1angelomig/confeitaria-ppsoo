package com.ppsoo.model.entities.condimentos.coberturas;

import com.ppsoo.model.entities.Bolo;
import com.ppsoo.model.entities.condimentos.CondimentDecorator;

public class CoberturaChocolate extends CondimentDecorator {

    Bolo bolo;

    public CoberturaChocolate(Bolo bolo) {
        this.bolo = bolo;
        this.setCobertura("Cobertura de Chocolate");
        this.setRecheio(bolo.getRecheio());
        this.setCamada(bolo.getCamada());
    }

    @Override
    public double preco() {
        return this.bolo.preco() + 3;
    }

}
