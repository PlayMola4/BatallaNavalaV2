package com.example.batallanavalav2;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.Random;

public class HelloController {

    @FXML
    private Label labelBarco;
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
    public void btnEmpezar(ActionEvent actionEvent) {
        Boat boat = new Boat(labelBarco, 1024, 768, btnEmpezar);
    }
}