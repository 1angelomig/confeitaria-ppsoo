package com.ppsoo.model.repositories;

import java.util.ArrayList;
import java.util.List;

import com.ppsoo.model.entities.Pedido;

public class PedidoRepository {

    private List<Pedido> pedidos = null;
    private static int lastId = 0;

    public PedidoRepository() {
        this.pedidos = new ArrayList<>();
    }

    public void create(Pedido pedido) {
        pedido.setId(lastId++);
        this.pedidos.add(pedido);
    }

    public Pedido read(int id) {
        for (Pedido pedido : pedidos) {
            if(pedido.getId() == id){
                return pedido;
            }
        }
        return null;
    }

    public void update(Pedido pedido) {
        for (Pedido pd : pedidos) {
            if(pd.getId() == pedido.getId()){
                pd.setBolo(pedido.getBolo());
                return;
            }
        }
    }

    public void delete(int id) {
        for (Pedido pedido : pedidos) {
            if(pedido.getId() == id){
                this.pedidos.remove(pedido);
            }
        }
    }

    public List<Pedido> readAll(){
        return this.pedidos;
    }
    
}
