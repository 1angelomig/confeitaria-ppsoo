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

    public Bolo criaBolo(){
        BoloBase bolo = new BoloBase();
        Bolo boloAux = bolo;
        return boloAux;
    }

    public Bolo adicionaRecheio(Bolo bolo, String recheio){
        if(recheio.equals("recheioMorango")){
            bolo = new RecheioMorango(bolo);
        }

        if(recheio.equals("recheioChocolate")){
            bolo = new RecheioMorango(bolo);
        }

        return bolo;
    }

    public Bolo adicionaCobertura(Bolo bolo, String cobertura){
        if(cobertura.equals("coberturaMorango")){
            bolo = new CoberturaMorango(bolo);
        }

        if(cobertura.equals("coberturaChocolate")){
            bolo = new CoberturaChocolate(bolo);
        }
        
        return bolo;
    }

    public Bolo adicionaCamadas(Bolo bolo, int camadas){
        if(camadas > 0){
            for (int i = 0; i < camadas; i++) {
                bolo = new Camada(bolo);
            }
        }
        
        return bolo;
    }

    public void cadastroCliente(String email, String senha){
        Cliente cliente = new Cliente(email, senha);
        System.out.println("cliente criado");
        cliente.setId(lastIndexCliente++);
        System.out.println("cliente com id");
        this.clientes.add(cliente);
        System.out.println("cliente na lista " +  cliente.getId() + " "+ this.clientes.size());
    }

    public Cliente logarCliente(String email, String senha){
        for (Cliente cliente : clientes) {
            if(cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)){
                System.out.println("retornando cliente " + cliente.getId());
                return cliente;
            }
        }

        System.out.println("retornando nada");
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

    public void fazPedido(Bolo bolo, Cliente cliente){
        Pedido pedido = new Pedido(bolo, cliente);
        pedido.setId(lastIndexPedido++);
        this.pedidos.add(pedido);
    }

    public List<Pedido> lerPedidos(Cliente cliente){
        List<Pedido> pedidosCliente = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if(pedido.getCliente().equals(cliente)){
                pedidosCliente.add(pedido);
            }
        }

        System.out.println("retornando pedidos");
        return pedidosCliente;
    }

}
