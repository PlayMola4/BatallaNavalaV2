package com.example.batallanavalav2;

import javafx.scene.image.ImageView;

import java.util.Random;

public class Barcos {
    private String nombreBarco;
    private int vida;
    private int velocidad;
    private int sonar;
    private int potenciaFuego;
    private ImageView imagenBarco;

    private String equipo;
    private double x;

    private double direction;

    public Barcos(String nombreBarco, ImageView imagenBarco, String equipo) {
        this.nombreBarco = nombreBarco;
        this.imagenBarco = imagenBarco;
        this.equipo = equipo;

        this.direction = 45;

        if (nombreBarco.equals("destructor")) {
            velocidad = 5;
            potenciaFuego = 50;
            vida = 80;
            sonar = 15;
            imagenBarco.setFitHeight(15);
            imagenBarco.setFitWidth(45);
        } else if (nombreBarco.equals("acorazado")) {
            velocidad = 3;
            potenciaFuego = 80;
            vida = 120;
            sonar = 20;
            imagenBarco.setFitHeight(25);
            imagenBarco.setFitWidth(55);
        } else if (nombreBarco.equals("submarino")) {
            velocidad = 2;
            potenciaFuego = 60;
            vida = 30;
            imagenBarco.setFitHeight(15);
            imagenBarco.setFitWidth(35);
        } else if (nombreBarco.equals("lancha")) {
            velocidad = 10;
            potenciaFuego = 60;
            vida = 30;
            sonar = 20;
            imagenBarco.setFitHeight(15);
            imagenBarco.setFitWidth(25);
        }
    }

    public int shoot() {
        Random random = new Random();
        int numeroRandom = random.nextInt(100);
        if (numeroRandom < 25) {
            return potenciaFuego = 0;
        } else if (numeroRandom <= 50) {
            return potenciaFuego / 2;
        } else {
            return potenciaFuego;
        }
    }

    public String getNombreBarco() {
        return nombreBarco;
    }

    public void setNombreBarco(String nombreBarco) {
        this.nombreBarco = nombreBarco;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getSonar() {
        return sonar;
    }

    public void setSonar(int sonar) {
        this.sonar = sonar;
    }

    public int getPotenciaFuego() {
        return potenciaFuego;
    }

    public void setPotenciaFuego(int potenciaFuego) {
        this.potenciaFuego = potenciaFuego;
    }

    public ImageView getImagenBarco() {
        return imagenBarco;
    }

    public void setImagenBarco(ImageView imagenBarco) {
        this.imagenBarco = imagenBarco;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    private void movimiento(Double positionX, Double positionY) {
        // Movimiento del Barco y su velocidad
        imagenBarco.setLayoutX(positionX);
        imagenBarco.setLayoutY(positionY);
    }
}