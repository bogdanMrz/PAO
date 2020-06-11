package com.comparator;

import com.Film;

import java.util.Comparator;

public class BugetCompare implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
        if (o1.getBuget() > o2.getBuget())
            return 1;
        if (o1.getBuget() < o2.getBuget())
            return -1;
        return 0;
    }

    private int rev(Film o1, Film o2){
        return -compare(o1,o2);
    }
    @Override
    public Comparator<Film> reversed() {
        return this::compare;
    }
}
