package com.comparator;

import com.Persoana;

import java.util.Comparator;

public class AlfabeticComparePersoana implements Comparator<Persoana> {
    @Override
    public int compare(Persoana o1, Persoana o2) {

        String numeComplet1 = o1.getNume()+o1.getPrenume(),
                numeComplet2 = o2.getNume()+o2.getPrenume();
        if (numeComplet1.compareTo(numeComplet2)>0)
            return 1;
        if (numeComplet1.compareTo(numeComplet2)<0)
            return -1;
        return 0;
    }

    private int rev(Persoana o1, Persoana o2){
        return -compare(o1,o2);
    }
    @Override
    public Comparator<Persoana> reversed() {
        return this::compare;
    }
}
