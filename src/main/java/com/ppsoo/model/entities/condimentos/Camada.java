package com.ppsoo.model.entities.condimentos;

import com.ppsoo.model.entities.Bolo;

public class Camada extends CondimentDecorator {

	Bolo bolo;
	
	public Camada(Bolo bolo) {
		this.bolo = bolo;
		this.cobertura = bolo.cobertura;
		this.recheio = bolo.recheio;
		this.camada = (bolo.quantCamada() + 1);
	}
	
	@Override
	public double preco() {
		return this.bolo.preco() + 3.00;
	}

}
