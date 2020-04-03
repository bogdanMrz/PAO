package com.comparator;

import com.Angajat;

import java.util.Comparator;

public class SalariuCompare implements Comparator<Angajat> {
    @Override
    public int compare(Angajat o1, Angajat o2) {

        if (o1.getSalariu()>o2.getSalariu())
            return 1;
        if (o1.getSalariu()<o2.getSalariu())
            return -1;
        return 0;
    }
    private int rev(Angajat o1, Angajat o2){
        return -compare(o1,o2);
    }
    @Override
    public Comparator<Angajat> reversed() {
        return this::rev;
    }
}
