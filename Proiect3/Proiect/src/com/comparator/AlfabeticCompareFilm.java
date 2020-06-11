package com.comparator;

import com.Film;

import java.util.Comparator;

public class AlfabeticCompareFilm implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
        return o1.getNume().compareTo(o2.getNume());
    }

    private int rev(Film o1, Film o2){
        return -compare(o1,o2);
    }
    @Override
    public Comparator<Film> reversed() {
        return this::compare;
    }
}
