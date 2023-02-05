package com.example.batallanavalav2;

import java.util.ArrayList;

public class ControlDeJuego {
    ArrayList<Barcos> barcos;

    public ControlDeJuego() {
        barcos = new ArrayList<Barcos>();

    }

    public synchronized ArrayList<Barcos> getBarcos() {
        return barcos;
    }

    public synchronized void aniadirBarcos(Barcos barco) {
        barcos.add(barco);
    }
}
