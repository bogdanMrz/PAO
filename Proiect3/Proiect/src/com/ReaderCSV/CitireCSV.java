package com.ReaderCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

abstract public class CitireCSV<T> {

    Scanner scanner;


    public CitireCSV(String filename) {
        try {
            this.scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {

        }

    }

    public boolean hasNext(){
        return scanner.hasNext();
    }

    public abstract T nextInstance();
    public ArrayList<T> getList(){
        ArrayList<T>turi = new ArrayList<T>();

        while (this.hasNext()) {
            T t = this.nextInstance();
            turi.add(t);

        }

        return turi;
    }

}
