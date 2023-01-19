package com.example.batallanavalav2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.Random;

public class Boat {
    private Label label;
    private double speed = 5; // 5 pixels per second
    private double xDirection = 1; // 1 for right, -1 for left
    private double yDirection = 1; // 1 for down, -1 for up
    private double windowWidth;
    private double windowHeight;
    private Timeline timeline;
    private Random random;

    private Button botonEmpezar;

    public Boat(Label label, double windowWidth, double windowHeight, Button botonEmpezar) {
        this.label = label;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.botonEmpezar = botonEmpezar;
        random = new Random();
        xDirection = (random.nextBoolean()) ? 1 : -1;
        yDirection = (random.nextBoolean()) ? 1 : -1;
        //create the timeline
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.03), e -> move()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void move() {
        // move the label
        label.setLayoutX(label.getLayoutX() + speed * xDirection);
        label.setLayoutY(label.getLayoutY() + speed * yDirection);

        // check if the label hits the wall
        if (label.getLayoutX() >= 1024 || label.getLayoutX() <= 0) {
            xDirection *= -1;
            xDirection = (random.nextBoolean()) ? 1 : -1;
            System.out.println("Coordenada X: " + label.getLayoutX());
        }
        if (label.getLayoutY() >= 768 || label.getLayoutY() <= 0) {
            yDirection *= -1;
            yDirection = (random.nextBoolean()) ? 1 : -1;
            System.out.println("Coordenada Y: " + label.getLayoutY());
        }
    }
}