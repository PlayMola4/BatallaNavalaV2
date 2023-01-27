package com.example.batallanavalav2;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Optional;
import java.util.Random;

public class HelloController {

    @FXML
    private Button btnEmpezar;

    private double speed = 5; // 5 pixels per unit of time
    private double xDirection = 1; // 1 for right, -1 for left
    private double yDirection = 1; // 1 for down, -1 for up
    private double windowWidth;
    private double windowHeight;
    private Timeline timeline;
    private Random random;
    @FXML
    private AnchorPane anchorPane;

    private Barcos barcoRojo;
    private Barcos barcoAzul;

    public void initialize() {
        ImageView destructorRojo = new ImageView();
        destructorRojo.setImage(new Image(getClass().getResourceAsStream("imagenes/destructorRojo.png")));
        destructorRojo.setLayoutX(28);
        destructorRojo.setLayoutY(371);

        barcoRojo = new Barcos("destructor", destructorRojo, "Rojo");


        ImageView destructorAzul = new ImageView();
        destructorAzul.setImage(new Image(getClass().getResourceAsStream("imagenes/destructorAzul.png")));
        destructorAzul.setLayoutX(250);
        destructorAzul.setLayoutY(371);

        barcoAzul = new Barcos("acorazado",destructorAzul, "Azul");

        anchorPane.getChildren().addAll(barcoRojo.getImagenBarco(), barcoAzul.getImagenBarco());
    }
    @FXML
    public void btnEmpezar(ActionEvent actionEvent) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), (ActionEvent ae) -> {

            MovimientoGeneral.mover(barcoRojo);
            MovimientoGeneral.detectarBordes(barcoRojo);
            if (MovimientoGeneral.detectarBarcoPorSonar(barcoRojo, barcoAzul)) {

                int disparo = barcoRojo.shoot();
                System.out.println(barcoRojo.getNombreBarco() + " dispara a: " + barcoAzul.getNombreBarco() + " y le quita: " + disparo);
                barcoAzul.setVida(barcoAzul.getVida() - disparo);

                if (barcoAzul.getVida() <= 0) {

                    System.out.println("el " + barcoAzul.getNombreBarco() + " muere");
                    anchorPane.getChildren().remove(barcoAzul.getImagenBarco());
                    equipoGanador();


                } else {
                    System.out.println("Al " + barcoAzul.getNombreBarco() + " le queda: " + barcoAzul.getVida() + " de vida.");

                }

            }


            MovimientoGeneral.mover(barcoAzul);
            MovimientoGeneral.detectarBordes(barcoAzul);

            if (MovimientoGeneral.detectarBarcoPorSonar(barcoAzul, barcoRojo)) {

                int disparo = barcoAzul.shoot();
                System.out.println(barcoAzul.getNombreBarco() + " dispara a: " + barcoRojo.getNombreBarco() + " y le quita: " + disparo);
                barcoRojo.setVida(barcoRojo.getVida() - disparo);

                if (barcoRojo.getVida() <= 0) {

                    System.out.println("el " + barcoRojo.getNombreBarco() + " muere");
                    anchorPane.getChildren().remove(barcoRojo.getImagenBarco());


                } else {
                    System.out.println("Al " + barcoRojo.getNombreBarco() + " le queda: " + barcoRojo.getVida() + " de vida.");

                }
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void equipoGanador() {
        Platform.runLater(()->{


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("¿Estas seguro de confirmar la acción?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                System.out.println("Borrar");
            } else {
                System.out.println("no Borrar");
            }

        });
    }
}