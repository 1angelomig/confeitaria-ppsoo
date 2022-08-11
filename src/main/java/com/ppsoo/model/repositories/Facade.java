package com.ppsoo.model.repositories;

import java.util.ArrayList;
import java.util.List;

import com.ppsoo.model.entities.Bolo;
import com.ppsoo.model.entities.BoloBase;
import com.ppsoo.model.entities.Cliente;
import com.ppsoo.model.entities.Pedido;
import com.ppsoo.model.entities.condimentos.Camada;
import com.ppsoo.model.entities.condimentos.coberturas.CoberturaChocolate;
import com.ppsoo.model.entities.condimentos.coberturas.CoberturaMorango;
import com.ppsoo.model.entities.condimentos.recheios.RecheioChocolate;
import com.ppsoo.model.entities.condimentos.recheios.RecheioMorango;

public class Facade {

    private static Facade myself = null;
    
    List<Cliente> clientes = null;
    List<Pedido> pedidos = null;
    static int lastIndexPedido = 1;
    static int lastIndexCliente = 1;

    public Facade(){
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public static Facade getCurrentInstance(){
        if(myself == null){
            myself = new Facade();
        }
        
        return myself;
    }

    public void fazPedido(String recheio, String cobertura, int camadas, int idCliente){
        BoloBase boloAux = new BoloBase();
        Bolo bolo = boloAux;

        //recheios
        if(recheio.equals("recheioMorango")){
            bolo = new RecheioMorango(bolo);
        }

        if(recheio.equals("recheioChocolate")){
            bolo = new RecheioChocolate(bolo);
        }

        //coberturas
        if(cobertura.equals("coberturaMorango")){
            bolo = new CoberturaMorango(bolo);
        }

        if(cobertura.equals("coberturaChocolate")){
            bolo = new CoberturaChocolate(bolo);
        }

        //camadas
        if(camadas > 0){
            for (int i = 0; i < camadas; i++) {
                bolo = new Camada(bolo);
            }
        }

        //pedido
        Pedido pedido = new Pedido(bolo, this.getCliente(idCliente));
        pedido.setId(lastIndexPedido++);
        this.pedidos.add(pedido);
    }

    public void cadastroCliente(String email, String senha){
        Cliente cliente = new Cliente(email, senha);
        cliente.setId(lastIndexCliente++);
        this.clientes.add(cliente);
    }

    public Cliente logarCliente(String email, String senha){
        for (Cliente cliente : clientes) {
            if(cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)){
                return cliente;
            }
        }

        return null;
    }

    public Cliente getCliente(int id){
        for (Cliente cliente : clientes) {
            if(cliente.getId() == id){
                return cliente;
            }
        }
        
        return null;
    }

    public List<Pedido> lerPedidos(Cliente cliente){
        List<Pedido> pedidosCliente = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if(pedido.getCliente().equals(cliente)){
                pedidosCliente.add(pedido);
            }
        }

        return pedidosCliente;
    }

}
