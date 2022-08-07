package com.ppsoo.model.entities.bolos;

import com.ppsoo.model.entities.Bolo;
import com.ppsoo.model.entities.coberturas.CoberturaChocolate;
import com.ppsoo.model.entities.recheios.RecheioChocolate;

public class BoloChocolate extends Bolo {

	public BoloChocolate(){
		this.cobertura = new CoberturaChocolate();
		this.recheio = new RecheioChocolate();
		this.camada = 1;
	}

	@Override
	public double preco() {
		return 10;
	}
	
}
