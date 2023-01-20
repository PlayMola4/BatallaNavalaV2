package com.example.batallanavalav2;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

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
    private ImageView imgDestructor;
    @FXML
    private ImageView imgDestructor1;

    @FXML
    public void btnEmpezar(ActionEvent actionEvent) {
        Destructor destructor = new Destructor(imgDestructor, 1024, 768, btnEmpezar);
        Destructor destructor2 = new Destructor(imgDestructor1, 1024, 768, btnEmpezar);
    }
}