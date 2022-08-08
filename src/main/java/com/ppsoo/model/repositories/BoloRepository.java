package com.ppsoo.model.repositories;

import java.util.ArrayList;
import java.util.List;

import com.ppsoo.model.entities.Bolo;
import com.ppsoo.model.entities.bolos.BoloChocolate;
import com.ppsoo.model.entities.bolos.BoloMorango;

public class BoloRepository {
    
    private List<Bolo> bolos = null;
    private static int lastId = 0;

    public BoloRepository() {
        this.bolos = new ArrayList<>();

        BoloChocolate b1 = new BoloChocolate();
        b1.setId(lastId++);
        bolos.add(b1);

        BoloMorango b2 = new BoloMorango();
        b2.setId(lastId++);
        bolos.add(b2);
    }

    public void create(Bolo bolo) {
        bolo.setId(lastId++);
        this.bolos.add(bolo);
    }

    public Bolo read(int id) {
        for (Bolo bolo : bolos) {
            if(bolo.getId() == id){
                return bolo;
            }
        }
        return null;
    }

    public void update(Bolo bolo) {
        for (Bolo bl : bolos) {
            if(bl.getId() == bolo.getId()){
                bl = bolo;
                return;
            }
        }
    }

    public void delete(int id) {
        for (Bolo bolo : bolos) {
            if(bolo.getId() == id){
                this.bolos.remove(bolo);
            }
        }
    }

    public List<Bolo> readAll(){
        return this.bolos;
    }

}
