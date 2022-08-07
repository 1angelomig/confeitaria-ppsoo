package com.ppsoo.model.entities.bolos;

import com.ppsoo.model.entities.Bolo;
import com.ppsoo.model.entities.coberturas.Cobertura;
import com.ppsoo.model.entities.recheios.Recheio;

public class BoloBase extends Bolo {

	public BoloBase() {
		this.camada = 1;
	}
	
	@Override
	public double preco() {
		// TODO Auto-generated method stub
		return 10.00;
	}
	
	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}
	
	public void setRecheio(Recheio recheio) {
		this.recheio = recheio;
	}

}
