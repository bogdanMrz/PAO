package com;

import java.io.IOException;

public class Actor extends Angajat {

    byte importanta;
    int bonus = 0;

    public Actor(String nume, String prenume, int salariu, byte importanta) {
        super(nume, prenume, salariu);
        this.importanta = importanta;
    }

    public Actor(String nume, String prenume, byte importanta) {
        super(nume, prenume);
        this.importanta = importanta;
    }

    public Actor(String nume, String prenume, int salariu) {
        super(nume, prenume, salariu);
    }

    public Actor(String nume, String prenume) {
        super(nume, prenume);
    }

    public Actor() {
        super("Neimportant","");
    }


    public int getBonus(){return bonus;}

    public byte getImportanta(){return importanta;}

    public void setImportanta(byte importanta) {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.importanta = importanta;
    }

    public void calculeazaBonus(Film film){


        if(importanta<100)
            return;

        int profit = film.getProfit();

        if(profit <= 0)
            return;

        bonus = profit/20;

    }

    @Override
    public String toString() {
        return "Actor{" +
                "nume=" + nume +
                ", prenume=" + prenume +
                ", salariu=" + salariu +
                ", importanta=" + importanta +
                '}';
    }

    public Actor copy(){
        return new Actor(nume,prenume,salariu,importanta);
    }
}
