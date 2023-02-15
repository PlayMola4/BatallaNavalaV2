package com.example.batallanavalav2;

import java.util.Random;

public class MovimientoGeneral {
    public static void mover(Barcos barcos) {
        double x = barcos.getImagenBarco().getLayoutX();
        double y = barcos.getImagenBarco().getLayoutY();
        double velocidad = barcos.getVelocidad();
        double direccion = Math.toRadians(barcos.getDirection());
        x += velocidad * Math.cos(direccion);
        y += velocidad * Math.sin(direccion);
        barcos.getImagenBarco().setLayoutX(x);
        barcos.getImagenBarco().setLayoutY(y);
        barcos.getImagenBarco().setRotate(barcos.getDirection());
    }

    public static void detectarBordes(Barcos barco) {
        double x = barco.getImagenBarco().getLayoutX();
        double y = barco.getImagenBarco().getLayoutY();

        if (barco.getNombreBarco().equals("destructor")) {
            Random random = new Random();
            int randomNumber = random.nextInt(10) + 1;
            if (randomNumber <= 5) {
                if (x < 0 || x > AnchuraVentana.ANCHO_VENTANA_Destructor) {
                    barco.setDirection(180 + barco.getDirection());
                }
                if (y < 0 || y > AnchuraVentana.ALTO_VENTANA_Destructor) {
                    barco.setDirection(180 + barco.getDirection());
                }
            } else {
                if (x < 0 || x > AnchuraVentana.ANCHO_VENTANA_Destructor) {
                    barco.setDirection(-180 + barco.getDirection());
                }
                if (y < 0 || y > AnchuraVentana.ALTO_VENTANA_Destructor) {
                    barco.setDirection(-barco.getDirection());
                }
            }
        } else {
            if (barco.getNombreBarco().equals("submarino")) {
                Random random = new Random();
                int randomNumber = random.nextInt(10) + 1;
                if (randomNumber >= 5) {
                    if (x < 0 || x > AnchuraVentana.ANCHO_VENTANA_Submarino) {
                        barco.setDirection(180 + barco.getDirection());
                    }
                    if (y < 0 || y > AnchuraVentana.ALTO_VENTANA_Submarino) {
                        barco.setDirection(180 + barco.getDirection());
                    }
                } else {
                    if (x < 0 || x > AnchuraVentana.ANCHO_VENTANA_Submarino) {
                        barco.setDirection(180 - barco.getDirection());
                    }
                    if (y < 0 || y > AnchuraVentana.ALTO_VENTANA_Submarino) {
                        barco.setDirection(-barco.getDirection());
                    }
                }
            } else {
                if (barco.getNombreBarco().equals("lancha")) {
                    Random random = new Random();
                    int randomNumber = random.nextInt(10) + 1;
                    if (randomNumber <= 5) {
                        if (x < 0 || x > AnchuraVentana.ALTO_VENTANA_Lancha) {
                            barco.setDirection(180 + barco.getDirection());
                        }
                        if (y < 0 || y > AnchuraVentana.ALTO_VENTANA_Lancha) {
                            barco.setDirection(180 + barco.getDirection());
                        }
                    } else {
                        if (x < 0 || x > AnchuraVentana.ALTO_VENTANA_Lancha) {
                            barco.setDirection(180 - barco.getDirection());
                        }
                        if (y < 0 || y > AnchuraVentana.ALTO_VENTANA_Lancha) {
                            barco.setDirection(-barco.getDirection());
                        }
                    }
                } else {
                    Random random = new Random();
                    int randomNumber = random.nextInt(10) + 1;
                    if (randomNumber <= 5) {
                        if (x < 0 || x > AnchuraVentana.ALTO_VENTANA_Acorazado) {
                            barco.setDirection(180 + barco.getDirection());
                        }
                        if (y < 0 || y > AnchuraVentana.ALTO_VENTANA_Acorazado) {
                            barco.setDirection(180 + barco.getDirection());
                        }
                    } else {
                        if (x < 0 || x > AnchuraVentana.ALTO_VENTANA_Acorazado) {
                            barco.setDirection(180 - barco.getDirection());
                        }
                        if (y < 0 || y > AnchuraVentana.ALTO_VENTANA_Acorazado) {
                            barco.setDirection(-barco.getDirection());
                        }
                    }
                }
            }
        }
    }

    public static double coordenadasDosBarcos(Barcos barcos1, Barcos barcos2) {
        double x1 = barcos1.getImagenBarco().getLayoutX();
        double y1 = barcos1.getImagenBarco().getLayoutY();
        double x2 = barcos2.getImagenBarco().getLayoutX();
        double y2 = barcos2.getImagenBarco().getLayoutY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static boolean detectarBarcos(Barcos barcos1, Barcos barcos2) {
        double distancia = coordenadasDosBarcos(barcos1, barcos2);
        return distancia <= barcos1.getSonar();
    }

    public static void rotar(Barcos barcos, double grados) {
        barcos.getImagenBarco().setRotate(barcos.getImagenBarco() .getRotate() + grados);
    }
}
