package com.ppsoo.model.entities;

import com.ppsoo.model.entities.coberturas.Cobertura;
import com.ppsoo.model.entities.recheios.Recheio;

public abstract class Bolo {
    
    public Cobertura cobertura;
	public Recheio recheio;
	public int camada;
	public int id;
	
	public String tipoRecheio() {
		return this.recheio.recheio();
	}
	
	public String tipoCobertura() {
		return this.cobertura.cobertura();
	}
	
	public int quantCamada() {
		return this.camada;
	}

	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id = id;
	}
	
	public abstract double preco();
	
}
