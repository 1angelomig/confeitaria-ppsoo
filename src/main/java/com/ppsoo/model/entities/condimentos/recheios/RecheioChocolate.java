package com.ppsoo.model.entities.condimentos.recheios;

import com.ppsoo.model.entities.Bolo;
import com.ppsoo.model.entities.condimentos.CondimentDecorator;

public class RecheioChocolate extends CondimentDecorator {

    Bolo bolo;

    public RecheioChocolate(Bolo bolo) {
        this.bolo = bolo;
        this.setCobertura(bolo.getCobertura());
        this.setRecheio("Recheio de Chocolate");
        this.setCamada(bolo.getCamada());
    }

    @Override
    public double preco() {
        return this.bolo.preco() + 3;
    }
    
}
