package com;

public class Incasari implements Cloneable  {
    private int cinema;
    private int stream;
    private int drepturiAutor;
    private int pulicitate;


    public Incasari() {

    }


    public Incasari(int cinema, int stream, int drepturiAutor, int pulicitate) {
        this.cinema = cinema;
        this.stream = stream;
        this.drepturiAutor = drepturiAutor;
        this.pulicitate = pulicitate;
    }

    public Incasari(Incasari incasari){
        this.cinema = incasari.cinema;
        this.stream = incasari.stream;
        this.drepturiAutor = incasari.drepturiAutor;
        this.pulicitate = incasari.pulicitate;
    }

    public int getCinema() {
        return cinema;
    }

    public int getStream() {
        return stream;
    }

    public int getDrepturiAutor() {
        return drepturiAutor;
    }

    public void setCinema(int cinema) {
        this.cinema = cinema;
    }

    public void setStream(int stream) {
        this.stream = stream;
    }

    public void setDrepturiAutor(int drepturiAutor) {
        this.drepturiAutor = drepturiAutor;
    }

    public int getPulicitate() {
        return pulicitate;
    }

    public void setPulicitate(int pulicitate) {
        this.pulicitate = pulicitate;
    }

    public int getTotal() {
        return cinema + stream + drepturiAutor + pulicitate;
    }

    public void plataStream(int plata){
        stream += plata;
    }

    public void plataDrepturi(int plata){
        drepturiAutor += plata;
    }

    public void plataCinema(int plata){
        cinema += plata;
    }

    public void plataPublicitate(int plata){
        pulicitate += plata;
    }

    @Override
    public String toString() {
        return "Incasari{" +
                "cinema=" + cinema +
                ", stream=" + stream +
                ", drepturiAutor=" + drepturiAutor +
                ", pulicitate=" + pulicitate +
                '}';
    }

    public Incasari copy(){
        return new Incasari(cinema,stream,drepturiAutor,pulicitate);

    }
}
