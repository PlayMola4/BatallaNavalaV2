package com.example.batallanavalav2;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class ControlDeJuego {
    ArrayList<Barcos> barcos;
    Timeline equipoGanador;
    String ganador = "";
    DialogPane dialogoGanador;

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
                mostrarEquipoGanador(ganador);
                equipoGanador.stop();
            }

            if (Azul >= 1 && Rojo == 0) {
                ganador = "Azul";
                mostrarEquipoGanador(ganador);
                equipoGanador.stop();
            }
        }));
        equipoGanador.setCycleCount(Timeline.INDEFINITE);
        equipoGanador.play();

        equipoGanador.setOnFinished(g -> {
            System.out.println("Ganador: " + ganador);
        });
    }

    public void mostrarEquipoGanador(String equipo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0.5));
        pauseTransition.setOnFinished(event -> {
            Platform.runLater(() -> {
                dialogoGanador = alert.getDialogPane();
                if (ganador.equals("Rojo")) {

                    alert.setTitle("El equipo ganador es el: " + ganador);


                } else {

                    alert.setTitle("El equipo ganador es el: " + ganador);
                }

                //mediaPlayer2.stop();
                dialogoGanador.getStyleClass().add("dialog");
                alert.setContentText("El equipo ganador es el: " + ganador);
                //Inicio inicio = new Inicio();
                alert.showAndWait().ifPresent(response -> {
                    // mediaPlayer.stop();
                    // inicio.start(new Stage());
                });
            });
        });
        pauseTransition.play();
    }
}
