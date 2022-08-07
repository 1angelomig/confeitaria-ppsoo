package com.ppsoo.model.entities;

import com.ppsoo.model.entities.coberturas.Cobertura;
import com.ppsoo.model.entities.recheios.Recheio;

public abstract class Bolo {
    
    public Cobertura cobertura;
	public Recheio recheio;
	public int camada;
	
	public String tipoRecheio() {
		return this.recheio.recheio();
	}
	
	public String tipoCobertura() {
		return this.cobertura.cobertura();
	}
	
	public int quantCamada() {
		return this.camada;
	}
	
	public abstract double preco();
	
}
