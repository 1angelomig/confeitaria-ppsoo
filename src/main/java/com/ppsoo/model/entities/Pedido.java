package com.ppsoo.model.entities;

public class Pedido {
    Cliente cliente;
    Bolo bolo;
    int id;
    double preco;

    public Pedido(Bolo bolo, Cliente cliente) {
    this.bolo = bolo;
    this.cliente = cliente;
    this.preco = bolo.preco();
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Cliente getCliente() {
    return cliente;
    }

    public void setCliente(Cliente cliente) {
    this.cliente = cliente;
    }

}
