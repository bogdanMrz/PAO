package com;


import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Film {
    Scanner reader = new Scanner(System.in);

    private  String nume;
    private int buget;
    private int cheltuieli = 0;
    private Incasari incasari = new Incasari(0,0,0,0);
    private String trailer = "";
    private LocalDateTime premiera = null;

    private HashMap<Actor, Personaj>distributie = new HashMap<Actor, Personaj>();
    private ArrayList<Angajat>echipa = new ArrayList<Angajat>();
    private  ArrayList<Locatie>locatii = new ArrayList<Locatie>();

    public Film() {
        this.nume = "Urmeaza hotarat";
        this.incasari = new Incasari();
    }

    public Film(String nume, int buget, Incasari incasari, String trailer) {
        this.nume = nume;
        this.buget = buget;
        this.incasari = incasari.copy();
        this.trailer = trailer;
    }

    public Film(String nume, int buget, Incasari incasari) {
        this.nume = nume;
        this.buget = buget;
        this.incasari = incasari.copy();
    }

    public Film(String nume, int buget, String trailer) {
        this.nume = nume;
        this.buget = buget;
        this.trailer = trailer;
        this.incasari = new Incasari();
    }

    public Film(String nume, int buget, LocalDateTime premiera) {
        this.nume = nume;
        this.buget = buget;
        this.premiera = premiera;
    }

    public Film(String nume, LocalDateTime premiera) {
        this.nume = nume;
        this.premiera = premiera;
    }

    public void playTrailer(){


        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(trailer));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + trailer);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }



    public LocalDateTime getPremiera() {
        return premiera;
    }

    public void setPremiera(LocalDateTime premiera) {
        this.premiera = premiera;
    }
    public void setPremiera(int an, int luna, int zi, int ora, int minute){
        this.premiera = LocalDateTime.of(an,luna,zi,ora,minute);
    }
    /**
    public void setPremiera(String data){
        this.premiera = new SimpleDateFormat("dd.MM.yyyy:kk-mm").parse(data, new ParsePosition(0));
    }
    */
    public ArrayList<Angajat> getEchipa() {
        ArrayList<Angajat>copieEchipa = new ArrayList<Angajat>(echipa.size());

        for(Angajat membruEchipa:echipa){
            copieEchipa.add(membruEchipa.copy());
        }
        return copieEchipa;
    }

    public void addEchipa(Angajat angajat){
        if(adugaCheltuiala(angajat.salariu)) {
            echipa.add(angajat);

            if(angajat instanceof Actor) {
                if(distributie.containsKey((Actor)angajat)){
                    return;
                }
                Personaj personaj = new Personaj();
                distributie.put((Actor)angajat, personaj);
            }
        }
    }

    public void addDistributie(Actor actor, Personaj personaj){
        if(personaj == null){
            personaj = new Personaj();
        }
        if(adugaCheltuiala(actor.salariu)) {
            distributie.put(actor.copy(), personaj.copy());
            echipa.add(actor.copy());
        }
    }
    public String getNume() {
        return nume;
    }

    public HashMap<Actor, Personaj> getDistributie() {
        HashMap<Actor, Personaj>copieDistributie =  new HashMap<Actor, Personaj>(distributie.size());

        for(Actor actor:distributie.keySet()){
            copieDistributie.put(actor.copy(), distributie.get(actor).copy());
        }
        return copieDistributie;
    }

    public int getBuget() {
        return buget;
    }

    public void setBuget(int buget) {
        this.buget = buget;
    }

    public int getTotalIncasari() {
        return incasari.getTotal();
    }

    public Incasari getIncasari() {
        return incasari.copy();
    }

    public void setIncasari(Incasari incasari) {
        this.incasari = incasari;
    }

    public ArrayList<Locatie> getLocatii() {
        ArrayList<Locatie>copieLocatii =  new ArrayList<Locatie>(locatii.size());
        for(Locatie locatie:locatii){
            copieLocatii.add(locatie.copy());
        }
        return copieLocatii;

    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void plataStream(int plata){
        incasari.plataStream(plata);
    }

    public void plataCinema(int plata){
        incasari.plataCinema(plata);
    }

    public void plataDrepturi(int plata){
        incasari.plataDrepturi(plata);
    }

    public void plataPublicitate(int plata){
        incasari.plataPublicitate(plata);
    }

    public void addLocatie(Locatie locatie){
        locatii.add(locatie);
    }

    public Locatie getLocatie(int i){
        return locatii.get(i).copy();
    }

    public Personaj personajPentru(Actor actor){
        return distributie.get(actor).copy();
    }

    public int getProfit(){
        return  this.getTotalIncasari() - cheltuieli;
    }

    public int getBugetRamas(){
        return buget - cheltuieli;
    }

    public int getCheltuieli() {
        return cheltuieli;
    }

    public boolean adugaCheltuiala(int suma){
        int maiTrebuie = this.ramaneInBuget(suma);
        if( maiTrebuie > 0){
            cheltuieli += suma;
            return true;
        }

        System.out.println("Buget de pasit cu "+maiTrebuie);
        System.out.println("Suplimetezi bugetul?");
        System.out.println("Raspunde cu: 'Da' sau 'Nu'");

        do{
            String raspuns = reader.next();
            if(raspuns == "Da"){
                this.suplimenteazaBuget(maiTrebuie);
                cheltuieli += suma;
                return true;
            }

            if (raspuns == "Nu"){
                return false;
            }
            System.out.println("Raspunde cu: 'Da' sau 'Nu'");

        }while(true);


    }

    public void setCheltuieli(int cheltuieli) {
        this.cheltuieli = cheltuieli;
    }

    public void suplimenteazaBuget(int suma){
        buget += suma;
    }

    private int ramaneInBuget(int suma){
        return buget - cheltuieli + suma;
    }


    @Override
    public String toString() {
        return "Film{" +
                "nume='" + nume + '\'' +
                ", buget=" + buget +
                ", cheltuieli=" + cheltuieli +
                ", incasari=" + incasari +
                ", premiera=" + premiera +
                ", distributie=" + distributie +
                ", echipa=" + echipa +
                ", locatii=" + locatii +
                '}';
    }
}
