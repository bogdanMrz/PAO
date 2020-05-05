package com;

import java.io.IOException;
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
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nume;
    }

    public void setNume(String nume) {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.nume = nume;
    }

    public String getPrenume() {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prenume;
    }

    public void setPrenume(String prenume) {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }
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
