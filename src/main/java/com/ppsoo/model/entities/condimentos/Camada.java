package com.ppsoo.model.entities.condimentos;

import com.ppsoo.model.entities.Bolo;

public class Camada extends CondimentDecorator {

	Bolo bolo;
	
	public Camada(Bolo bolo) {
		this.bolo = bolo;
		this.setCobertura(bolo.getCobertura());
		this.setRecheio(bolo.getRecheio());
		this.setCamada(bolo.getCamada() + 1);
	}
	
	@Override
	public double preco() {
		return this.bolo.preco() + 5;
	}

}
