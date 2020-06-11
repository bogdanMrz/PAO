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

public class Film implements Comparable<Film>{
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
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        return premiera;
    }

    public void setPremiera(LocalDateTime premiera) {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.premiera = premiera;
    }
    public void setPremiera(int an, int luna, int zi, int ora, int minute){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.premiera = LocalDateTime.of(an,luna,zi,ora,minute);
    }
    /**
    public void setPremiera(String data){
        this.premiera = new SimpleDateFormat("dd.MM.yyyy:kk-mm").parse(data, new ParsePosition(0));
    }
    */

    public ArrayList<Actor>getActori(){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<Actor>actori = new ArrayList<Actor>(distributie.size());

        for (Actor actor:distributie.keySet()){
            actori.add(actor.copy());
        }

        return actori;
    }

    public ArrayList<Angajat> getEchipa() {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<Angajat>copieEchipa = new ArrayList<Angajat>(echipa.size());

        for(Angajat membruEchipa:echipa){
            copieEchipa.add(membruEchipa.copy());
        }
        return copieEchipa;
    }

    public void addEchipa(Angajat angajat){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


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
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(personaj == null){
            personaj = new Personaj();
        }
        if(adugaCheltuiala(actor.salariu)) {
            distributie.put(actor.copy(), personaj.copy());
            echipa.add(actor.copy());
        }
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

    public HashMap<Actor, Personaj> getDistributie() {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        HashMap<Actor, Personaj>copieDistributie =  new HashMap<Actor, Personaj>(distributie.size());

        for(Actor actor:distributie.keySet()){
            copieDistributie.put(actor.copy(), distributie.get(actor).copy());
        }
        return copieDistributie;
    }

    public int getBuget() {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        return buget;
    }

    public void setBuget(int buget) {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.buget = buget;
    }

    public int getTotalIncasari() {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        return incasari.getTotal();
    }

    public Incasari getIncasari() {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        return incasari.copy();
    }

    public void setIncasari(Incasari incasari) {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.incasari = incasari;
    }

    public ArrayList<Locatie> getLocatii() {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<Locatie>copieLocatii =  new ArrayList<Locatie>(locatii.size());
        for(Locatie locatie:locatii){
            copieLocatii.add(locatie.copy());
        }
        return copieLocatii;

    }

    public String getTrailer() {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        return trailer;
    }

    public void setTrailer(String trailer) {
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.trailer = trailer;
    }

    public void plataStream(int plata){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        incasari.plataStream(plata);
    }

    public void plataCinema(int plata){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        incasari.plataCinema(plata);
    }

    public void plataDrepturi(int plata){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        incasari.plataDrepturi(plata);
    }

    public void plataPublicitate(int plata){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        incasari.plataPublicitate(plata);
    }

    public void addLocatie(Locatie locatie){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        locatii.add(locatie);
    }

    public Locatie getLocatie(int i){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        return locatii.get(i).copy();
    }

    public Personaj personajPentru(Actor actor){
        return distributie.get(actor).copy();
    }

    public int getProfit(){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  this.getTotalIncasari() - cheltuieli;
    }

    public int getBugetRamas(){
        return buget - cheltuieli;
    }

    public int getCheltuieli() {
        return cheltuieli;
    }

    public boolean adugaCheltuiala(int suma){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        int maiTrebuie = this.ramaneInBuget(suma);
        if( maiTrebuie > 0){
            cheltuieli += suma;
            return true;
        }

        System.out.println("Buget depasit cu "+maiTrebuie);
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
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.cheltuieli = cheltuieli;
    }

    public void suplimenteazaBuget(int suma){
        try {

            Audit.add(this.getClass().getSimpleName()
                    .toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    @Override
    public int compareTo(Film o) {
        if (this.getProfit() > o.getProfit())
            return 1;

        if (this.getProfit() < o.getProfit())
            return -1;

        return 0;
    }

}
