package com.ReaderCSV;

import com.Angajat;

public class AngajatCSV extends CitireCSV<Angajat> {
    public AngajatCSV(String filename) {
        super(filename);
    }

    @Override
    public Angajat nextInstance() {

        String[] fields = scanner.nextLine().split(",");

        return new Angajat(fields[0], fields[1], Integer.parseInt(fields[2]));
    }

}


