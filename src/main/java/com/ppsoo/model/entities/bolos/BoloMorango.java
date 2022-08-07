package com.ppsoo.model.entities.bolos;

import com.ppsoo.model.entities.Bolo;
import com.ppsoo.model.entities.coberturas.CoberturaMorango;
import com.ppsoo.model.entities.recheios.RecheioMorango;

public class BoloMorango extends Bolo {

    public BoloMorango(){
        this.cobertura = new CoberturaMorango();
        this.recheio = new RecheioMorango();
        this.camada = 1;
    }

    @Override
    public double preco() {
        return 10;
    }

}
