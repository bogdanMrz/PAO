package com.ReaderCSV;

import com.Personaj;


public class PersonajCSV  extends CitireCSV<Personaj>{
    public PersonajCSV(String filename) {
        super(filename);
    }

    @Override
    public Personaj nextInstance() {

        String[] fields = scanner.nextLine().split(",");
        return new Personaj(fields[0],fields[1],Short.parseShort(fields[2]));
    }

}
