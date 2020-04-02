package com;

import java.util.ArrayList;
import java.util.Objects;

public class Locatie {
    private String nume;
    private ArrayList<String>recuzita = new ArrayList<String>();

    public Locatie(String nume) {
        this.nume = nume;
    }
    public  Locatie(String nume, ArrayList<String>recuzita){
        this.nume = nume;
        this.recuzita = new ArrayList<String>(recuzita.size());

        for(String obiect:recuzita){
            this.recuzita.add(obiect);
        }
    }

    public Locatie() {
        this.nume = "Locatie generica";
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public ArrayList<String> getRecuzita() {

        ArrayList<String> copie_recuzita = new ArrayList<String>(recuzita.size());

        for(String obiect:recuzita){
            copie_recuzita.add(obiect);
        }
        return copie_recuzita;
    }

    public void setRecuzita(ArrayList<String> recuzita) {
        this.recuzita = new ArrayList<String>(recuzita.size());

        for(String obiect:recuzita){
            this.recuzita.add(obiect);
        }
    }

    public Locatie copy(){
        return new Locatie(nume, recuzita);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locatie locatie = (Locatie) o;
        return nume.equals(locatie.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume);
    }
}
