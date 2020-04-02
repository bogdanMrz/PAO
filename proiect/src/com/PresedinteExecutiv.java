package com;

public class PresedinteExecutiv extends Angajat {
    private static PresedinteExecutiv single_instance = null;

    private PresedinteExecutiv(String nume, String prenume, int salariu) {
        super(nume, prenume, salariu);
    }

    private PresedinteExecutiv(String nume, String prenume) {
        super(nume, prenume);
    }

    private PresedinteExecutiv(){
        super();
    }
    public static PresedinteExecutiv get(){
        if(single_instance == null){
            single_instance = new PresedinteExecutiv("Vacant","");
        }
        return single_instance;
    }

    public static void set(Persoana persoana, int salariu){
        single_instance = new PresedinteExecutiv(persoana.getNume(), persoana.getPrenume(), salariu);
    }

    public static void set(String nume, String prenume, int salariu){
        single_instance = new PresedinteExecutiv(nume, prenume, salariu);
    }

}
