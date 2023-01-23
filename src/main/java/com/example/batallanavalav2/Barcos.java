package com.example.batallanavalav2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class Barcos {
    private String nombreBarco;
    private double velocidad = 5; // 5 pixels per second

    private int vida;

    private int potenciaFuego;

    private int sonar;
    private double xDirection = 1; // 1 for right, -1 for left
    private double yDirection = 1; // 1 for down, -1 for up
    private double windowWidth;
    private double windowHeight;
    private Timeline timeline;
    private Random random;

    private Button botonEmpezar;

    private ImageView imagenBarco;

    public Barcos(String nombreBarco, ImageView imagenBarco, double windowWidth, double windowHeight, Button botonEmpezar) {

        if (nombreBarco.equals("destructor")) {
            velocidad = 5;
            potenciaFuego = 50;
            vida = 80;
            sonar = 15;
        } else if (nombreBarco.equals("acorazado")) {
            velocidad = 3;
            potenciaFuego = 80;
            vida = 120;
            sonar = 20;
        } else if (nombreBarco.equals("submarino")) {
            velocidad = 2;
            potenciaFuego = 60;
            vida = 30;
            sonar = 20;
        } else if (nombreBarco.equals("lancha")) {
            velocidad = 10;
            potenciaFuego = 60;
            vida = 30;
            sonar = 20;
        }

        this.imagenBarco = imagenBarco;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.botonEmpezar = botonEmpezar;
        random = new Random();
        initialize();
        //create the timeline
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.03), e -> move()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void move() {
        // Movimiento del Barco y su velocidad
        barco.setLayoutX(barco.getLayoutX() + speed * xDirection);
        barco.setLayoutY(barco.getLayoutY() + speed * yDirection);

        int numeroAleatorio = (int) (Math.random()*2+1);

        // Cuando rebota en el lado derecho de la pantalla
        if (barco.getLayoutX() >= 999 && yDirection == 1) {
            System.out.println("[LADO: DERECHO] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            xDirection = -1;
            barco.setRotate(0);
            barco.setRotate(135);
            numeroAleatorio = (int) (Math.random()*2+1);
        }

        if (barco.getLayoutX() >= 999 && yDirection == 1 && numeroAleatorio == 2) {
            System.out.println("[LADO: DERECHO] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            xDirection = -1;
            yDirection = -1;
            barco.setRotate(0);
            barco.setRotate(225);
            numeroAleatorio = (int) (Math.random()*2+1);
        }

        if (barco.getLayoutX() >= 999 && yDirection == -1) {
            System.out.println("[LADO: DERECHO] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            xDirection = -1;
            barco.setRotate(0);
            barco.setRotate(45);
        }

        // Cuando rebota en el lado izquierdo de la pantalla
        if (barco.getLayoutX() <= 0 && yDirection == 1) {
            System.out.println("[LADO: IZQUIERDO] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            xDirection = 1;
            barco.setRotate(0);
            barco.setRotate(45);
            numeroAleatorio = (int) (Math.random()*2+1);
        }

        if (barco.getLayoutX() <= 0 && yDirection == 1 && numeroAleatorio == 2) {
            System.out.println("[LADO: IZQUIERDO] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            xDirection = 1;
            yDirection = 1;
            barco.setRotate(0);
            barco.setRotate(225);
            numeroAleatorio = (int) (Math.random()*2+1);
        }

        if (barco.getLayoutX() <= 0 && yDirection == -1) {
            System.out.println("[LADO: IZQUIERDO] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            xDirection = 1;
            barco.setRotate(0);
            barco.setRotate(135);
        }

        //Cuando rebota arriba de la pantalla
        if (barco.getLayoutY() <= 0 && xDirection == 1) {
            System.out.println("[LADO: ARRIBA] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            yDirection = 1;
            barco.setRotate(0);
            barco.setRotate(225);
            numeroAleatorio = (int) (Math.random()*2+1);
        }

        if (barco.getLayoutY() <= 0 && xDirection == -1 && numeroAleatorio == 2) {
            System.out.println("[LADO: ARRIBA] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            yDirection = 1;
            xDirection = 1;
            barco.setRotate(0);
            barco.setRotate(45);
            numeroAleatorio = (int) (Math.random()*2+1);
        }

        if (barco.getLayoutY() <= 0 && xDirection == -1) {
            System.out.println("[LADO: ARRIBA] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            yDirection = 1;
            barco.setRotate(0);
            barco.setRotate(135);
        }

        //Cuando rebota abajo de la pantalla
        if (barco.getLayoutY() >= 751 && xDirection == 1) {
            System.out.println("[LADO: ABAJO] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            yDirection = -1;
            barco.setRotate(0);
            barco.setRotate(315);
            numeroAleatorio = (int) (Math.random()*2+1);
        }

        if (barco.getLayoutY() >= 751 && xDirection == 1 && numeroAleatorio == 2) {
            System.out.println("[LADO: ABAJO] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            yDirection = -1;
            xDirection = -1;
            barco.setRotate(0);
            barco.setRotate(135);
            numeroAleatorio = (int) (Math.random()*2+1);
        }

        if (barco.getLayoutY() >= 751 && xDirection == -1) {
            System.out.println("[LADO: ABAJO] Se ha generado el numero: " + numeroAleatorio + " de forma aleatoria");
            yDirection = -1;
            barco.setRotate(0);
            barco.setRotate(225);
        }
    }
    public void initialize() {
        barco.setRotate(45);
    }
}