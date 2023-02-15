package com.example.batallanavalav2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;

public class ControlDeJuego {
    ArrayList<Barcos> barcos;
    Timeline equipoGanador;
    String ganador = "";

    public ControlDeJuego() {
        barcos = new ArrayList<Barcos>();

    }

    public synchronized ArrayList<Barcos> getBarcos() {
        return barcos;
    }

    public synchronized void aniadirBarcos(Barcos barco) {
        barcos.add(barco);
    }

    public void ganador() {
        equipoGanador = new Timeline(new KeyFrame(Duration.seconds(0.05), e ->{
            int contadorFor = 0;
            int Azul = 0;
            int Rojo = 0;

            ganador();
            for (Barcos barco : barcos) {
                if (barco.getVida() > 0) {
                    if (barco.getEquipo().equals("Rojo")) {

                        Rojo++;
                    }

                    if (barco.getEquipo().equals("Azul")) {

                        Azul++;

                    }
                    contadorFor++;
                }
            }

            if (Rojo >= 1 && Azul == 0) {
                ganador = "Rojo";
                equipoGanador.stop();
            }

            if (Azul >= 1 && Rojo == 0) {
                ganador = "Azul";
                equipoGanador.stop();
            }
        }));
        equipoGanador.setCycleCount(Timeline.INDEFINITE);
        equipoGanador.play();

        equipoGanador.setOnFinished(g -> {
            System.out.println("Ganador: " + ganador);
        });
    }
}
