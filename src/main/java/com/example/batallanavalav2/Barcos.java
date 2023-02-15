package com.example.batallanavalav2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class Barcos {

    private Timeline movimientoBarcos;
    private String nombreBarco;
    private int vida;
    private int velocidad;
    private int sonar;
    private int potenciaFuego;
    private boolean modoDeDisparo;
    private ImageView imagenBarco;

    private String equipo;
    private double x;

    private ArrayList<Barcos> barcos;

    private AnchorPane ventana;

    private double direction;

    private long recargaCaniones;

    private boolean isShooting;


    public Barcos(String nombreBarco, ImageView imagenBarco, String equipo, ArrayList<Barcos> barcos, AnchorPane anchorPane) {
        this.nombreBarco = nombreBarco;
        this.imagenBarco = imagenBarco;
        this.ventana = anchorPane;
        this.barcos = barcos;
        this.equipo = equipo;
        this.recargaCaniones = 0;
        this.isShooting = false;

        this.direction = 45;

        if (nombreBarco.equals("destructor")) {
            velocidad = 5;
            potenciaFuego = 50;
            vida = 80;
            sonar = 300;
            recargaCaniones = 6000;
            imagenBarco.setFitHeight(15);
            imagenBarco.setFitWidth(45);
        } else if (nombreBarco.equals("acorazado")) {
            velocidad = 3;
            potenciaFuego = 80;
            vida = 120;
            sonar = 200;
            recargaCaniones = 8000;
            imagenBarco.setFitHeight(25);
            imagenBarco.setFitWidth(55);
        } else if (nombreBarco.equals("submarino")) {
            velocidad = 2;
            potenciaFuego = 60;
            vida = 30;
            recargaCaniones = 4000;
            imagenBarco.setFitHeight(15);
            imagenBarco.setFitWidth(35);
        } else if (nombreBarco.equals("lancha")) {
            velocidad = 10;
            potenciaFuego = 60;
            vida = 30;
            sonar = 75;
            recargaCaniones = 2000;
            imagenBarco.setFitHeight(15);
            imagenBarco.setFitWidth(25);
        }

        movimientoBarcos = new Timeline(new KeyFrame(Duration.seconds(0.05), e ->{
            partidaTerminada();
            if(!modoDeDisparo) {
                deteccionBarcosCercanos();
                detectarBordesVentana();
                movimientoBarco();
            }
            eliminarBarco();
        }));
        movimientoBarcos.setCycleCount(Timeline.INDEFINITE);
        movimientoBarcos.play();
    }

    public synchronized int shoot() {
        Random random = new Random();
        int numeroRandom = random.nextInt(101);
        if (numeroRandom < 25) {
            return 0;
        } else if (numeroRandom <= 50) {
            return potenciaFuego / 2;
        } else {
            return potenciaFuego;
        }
    }

    private long ultimoDisparo = 0;
    public synchronized boolean recargaCaniones() {
        long tiempoActual = System.currentTimeMillis();
        return tiempoActual < ultimoDisparo + recargaCaniones;
    }

    public synchronized void detenerDisparoBarcos(Barcos barco1, Barcos barco2) {
        barco1.setModoDeDisparo(true);
        barco2.setModoDeDisparo(true);
    }

    public synchronized void movimientoBarco() {
        double x = this.getImagenBarco().getLayoutX();
        double y = this.getImagenBarco().getLayoutY();
        double velocidad = this.getVelocidad();
        double direccion = Math.toRadians(this.getDirection());
        x += velocidad * Math.cos(direccion);
        y += velocidad * Math.sin(direccion);
        this.getImagenBarco().setLayoutX(x);
        this.getImagenBarco().setLayoutY(y);
        this.getImagenBarco().setRotate(this.getDirection());
    }

    public synchronized void eliminarBarco() {
        if (this.getVida() <= 0) {
            movimientoBarcos.stop();
            this.vida = 0;
        }
    }

    public synchronized void partidaTerminada() {

        int contadorFor = 0;
        int Azul = 0;
        int Rojo = 0;

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
            movimientoBarcos.stop();
        }

        if (Azul >= 1 && Rojo == 0) {
            movimientoBarcos.stop();
        }
    }

    public synchronized void deteccionBarcosCercanos() {
        if (recargaCaniones() || getVida() <= 0) {
            return;
        }

        for (Barcos barco : barcos) {
            if (barco == this) {
                continue;
            }
            double distancia = Math.sqrt(Math.pow(barco.getImagenBarco().getLayoutX() - this.getImagenBarco().getLayoutX(), 2) +
                    Math.pow(barco.getImagenBarco().getLayoutY() - this.getImagenBarco().getLayoutY(), 2));

            if (barco.getNombreBarco().equals("submarino")) {
                distancia = distancia - 50;
            }

            if (distancia < getSonar() && this.getEquipo() != barco.getEquipo() && barco.getVida() > 0) {
                detenerDisparoBarcos(this, barco);
                ultimoDisparo = System.currentTimeMillis();
                int disparar = this.shoot();
                System.out.println("El barco: " + this.getNombreBarco()+"  | del equipo: "+ this.getEquipo() + " dispara a: " + barco.getNombreBarco()+ "  | del equipo: "+barco.getEquipo());
                System.out.println("Le quita: " + disparar + " daño");
                barco.setVida(barco.getVida() - disparar);
                System.out.println("Le queda de vida: " + barco.getVida());
                break;
            }
        }
    }

    public synchronized void detectarBordesVentana() {
        MovimientoGeneral.detectarBordes(this);
    }

    public synchronized void moverTodosLosBarcos() {
        for (Barcos barco : barcos) {

            barco.setModoDeDisparo(false);

        }
    }
    public String getNombreBarco() {
        return nombreBarco;
    }

    public void setNombreBarco(String nombreBarco) {
        this.nombreBarco = nombreBarco;
    }

    public Timeline getMovimientoBarcos() {
        return movimientoBarcos;
    }

    public void setMovimientoBarcos(Timeline movimientoBarcos) {
        this.movimientoBarcos = movimientoBarcos;
    }

    public boolean isModoDeDisparo() {
        return modoDeDisparo;
    }

    public void setModoDeDisparo(boolean modoDeDisparo) {
        this.modoDeDisparo = modoDeDisparo;
    }

    public long getRecargaCaniones() {
        return recargaCaniones;
    }

    public void setRecargaCaniones(int recargaCaniones) {
        this.recargaCaniones = recargaCaniones;
    }

    public long getUltimoDisparo() {
        return ultimoDisparo;
    }

    public void setUltimoDisparo(long ultimoDisparo) {
        this.ultimoDisparo = ultimoDisparo;
    }

    public int getVida() {
        return vida;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public ArrayList<Barcos> getBarcos() {
        return barcos;
    }

    public void setBarcos(ArrayList<Barcos> barcos) {
        this.barcos = barcos;
    }

    public AnchorPane getVentana() {
        return ventana;
    }

    public void setVentana(AnchorPane ventana) {
        this.ventana = ventana;
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
        imagenBarco.setLayoutX(positionX);
        imagenBarco.setLayoutY(positionY);
    }
}