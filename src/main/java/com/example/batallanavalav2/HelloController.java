package com.example.batallanavalav2;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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

    public void initialize() {
        ImageView destructorRojo = new ImageView();
        destructorRojo.setImage(new Image(getClass().getResourceAsStream("imagenes/destructorRojo.png")));
        destructorRojo.setLayoutX(28);
        destructorRojo.setLayoutY(371);

        Barcos destructor = new Barcos("destructor", destructorRojo, "Rojo");


        ImageView destructorAzul = new ImageView();
        destructorAzul.setImage(new Image(getClass().getResourceAsStream("imagenes/destructorAzul.png")));
        destructorAzul.setLayoutX(250);
        destructorAzul.setLayoutY(371);

        Barcos destructor2 = new Barcos("acorazado",destructorAzul, "Azul");

        anchorPane.getChildren().addAll(destructor.getImagenBarco(), destructor2.getImagenBarco());
    }
    @FXML
    public void btnEmpezar(ActionEvent actionEvent) {

    }
}