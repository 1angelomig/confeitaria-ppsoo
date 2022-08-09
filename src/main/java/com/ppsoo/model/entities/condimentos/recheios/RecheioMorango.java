package com.ppsoo.model.entities.condimentos.recheios;

import com.ppsoo.model.entities.Bolo;
import com.ppsoo.model.entities.condimentos.CondimentDecorator;

public class RecheioMorango extends CondimentDecorator {

    Bolo bolo;

    public RecheioMorango(Bolo bolo) {
        this.bolo = bolo;
        this.setCobertura(bolo.getCobertura());
        this.setRecheio("Recheio de Morango");
        this.setCamada(bolo.getCamada());
    }

    @Override
    public double preco() {
        return this.bolo.preco() + 3;
    }

}
