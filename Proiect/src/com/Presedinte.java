package com;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Presedinte {
    private static Presedinte single_instance = null;

    private  static String nume, prenume;
    private static int salariu;

    private Presedinte(String nume, String prenume, int salariu) {

        Presedinte.nume = nume;
        Presedinte.prenume = prenume;
        Presedinte.salariu = salariu;
    }

    private Presedinte(String nume, String prenume) {

        Presedinte.nume = nume;
        Presedinte.prenume = prenume;
    }




    private Presedinte(){
        Presedinte.nume = "Vacant";
    }



    public static Presedinte get(){
        if(single_instance == null){
            try (Scanner scanner = new Scanner(new File("presedinte.csv"));) {
                String[] arg = scanner.nextLine().split(",");

                if (arg.length == 2){
                    single_instance = new Presedinte(arg[0],arg[1]);
                }
                else {
                    single_instance = new Presedinte(arg[0],arg[1], Integer.parseInt(arg[2]));
                }
            } catch (FileNotFoundException e) {
                single_instance = new Presedinte();

            }

        }
        return single_instance;
    }


    public static void nou(@NotNull Persoana persoana, int salariu) {
        single_instance = new Presedinte(persoana.getNume(), persoana.getPrenume(), salariu);

    }

    public static void nou(String nume, String prenume, int salariu){


        single_instance = new Presedinte(nume, prenume, salariu);
    }


    public static String getNume() {
        return nume;
    }

    public static String getPrenume() {
        return prenume;
    }

    public static int getSalariu() {
        return salariu;
    }


    @Override
    public String toString() {
        return "Presedinte{ nume=" + nume +
                ", prenume=" + prenume  +
                ", salariu=" + salariu +
                '}';
    }

}
