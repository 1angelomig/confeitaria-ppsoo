package com.ppsoo.model.entities;

public class BoloBase extends Bolo {

	public BoloBase() {
		this.camada = 1;
		this.cobertura = null;
		this.recheio = null;
	}
	
	@Override
	public double preco() {
		return 5;
	}

}
