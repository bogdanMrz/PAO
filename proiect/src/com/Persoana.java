package com;

import java.util.Objects;

public class Persoana {
    protected String nume;
    protected String prenume;

    public Persoana() {
        this.nume = "";
        this.prenume = "";
    }

    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana persoana = (Persoana) o;
        return nume.equals(persoana.nume) &&
                prenume.equals(persoana.prenume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume);
    }


}
