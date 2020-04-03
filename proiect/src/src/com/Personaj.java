package com;

public class Personaj extends Persoana {
    private  short varsta;

    public short getVarsta() {
        return varsta;
    }

    public Personaj() {
        super("Neimportant", "");
    }

    public Personaj(short varsta) {
        super("Neimportant", "");
        this.varsta = varsta;
    }
    public Personaj(String nume, String prenume) {
        super(nume, prenume);
    }
    public Personaj(String nume, String prenume, short varsta) {
        super(nume, prenume);
        this.varsta = varsta;
    }
    public Personaj(String nume, short varsta){
        super(nume, "");
        this.varsta = varsta;
    }

    public void setVarsta(short varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Personaj{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }

    public Personaj copy(){
        return new Personaj(nume,prenume,varsta);
    }
}
