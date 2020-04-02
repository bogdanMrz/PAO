package com;

public class Angajat extends Persoana {
    protected int salariu;

    public Angajat(String nume, String prenume, int salariu) {
        super(nume, prenume);
        this.salariu = salariu;
    }
    Angajat(String nume, String prenume){
        super(nume, prenume);
    }
    public Angajat() {
        super();
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }


    @Override
    public String toString() {
        return "Angajat{" +
                "salariu=" + salariu +
                ", nume=" + nume +
                ", prenume=" + prenume  +
                '}';
    }

    public Angajat copy(){
        return new Angajat(nume,prenume,salariu);
    }


}
