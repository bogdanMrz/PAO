package com.comparator;

import com.Actor;

import java.util.Comparator;

public class ImportantaCompare implements Comparator<Actor> {


    @Override
    public int compare(Actor o1, Actor o2) {

        if (o1.getImportanta()>o2.getImportanta())
            return 1;
        if (o1.getImportanta()<o2.getImportanta())
            return -1;        return 0;
    }
    private int rev(Actor o1, Actor o2){
        return -compare(o1,o2);
    }
    @Override
    public Comparator<Actor> reversed() {
        return this::rev;
    }

}
