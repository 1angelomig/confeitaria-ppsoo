package com.ppsoo.model.entities;

public class Pedido {
    Bolo bolo;
    int id;
    // data

    public Pedido(Bolo bolo) {
        this.bolo = bolo;
        // set data
    }

    public Bolo getBolo() {
        return bolo;
    }

    public void setBolo(Bolo bolo) {
        this.bolo = bolo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
