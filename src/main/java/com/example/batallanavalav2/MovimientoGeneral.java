package com.example.batallanavalav2;

import java.util.Random;

public class MovimientoGeneral {
    public static void mover(Barcos barcos) {
        double x = barcos.getImagen().getLayoutX();
        double y = barcos.getImagen().getLayoutY();
        double velocidad = barcos.getVelocidad();
        double direccion = Math.toRadians(barcos.getDireccion());
        x += velocidad * Math.cos(direccion);
        y += velocidad * Math.sin(direccion);
        barcos.getImagen().setLayoutX(x);
        barcos.getImagen().setLayoutY(y);
        barcos.getImagen().setRotate(barcos.getDireccion());
    }

    public static void detectarBordes(Barcos barco) {
        double EjeX = barco.getImagen().getLayoutX();
        double EjeY = barco.getImagen().getLayoutY();

        if (barco.getNombre().equals("destructor")) {
            Random random = new Random();
            int randomNumber = random.nextInt(10) + 1;
            if (randomNumber <= 5) {
                if (EjeX < 0 || EjeX > 970) {
                    barco.setDireccion(180 + barco.getDireccion());
                }
                if (EjeY < 0 || EjeY > 670) {
                    barco.setDireccion(180 + barco.getDireccion());
                }
            } else {
                if (EjeX < 0 || EjeX > 970) {
                    barco.setDireccion(180 - barco.getDireccion());
                }
                if (EjeY < 0 || EjeY > 670) {
                    barco.setDireccion(-barco.getDireccion());
                }
            }
        } else {
            if (barco.getNombre().equals("submarino")) {
                Random random = new Random();
                int randomNumber = random.nextInt(10) + 1;
                if (randomNumber <= 5) {
                    if (EjeX < 0 || EjeX > 970) {
                        barco.setDireccion(180 + barco.getDireccion());
                    }
                    if (EjeY < 0 || EjeY > 670) {
                        barco.setDireccion(180 + barco.getDireccion());
                    }
                } else {
                    if (EjeX < 0 || EjeX > 970) {
                        barco.setDireccion(180 - barco.getDireccion());
                    }
                    if (EjeY < 0 || EjeY > 670) {
                        barco.setDireccion(-barco.getDireccion());
                    }
                }
            } else {
                if (barco.getNombre().equals("lancha")) {
                    Random random = new Random();
                    int randomNumber = random.nextInt(10) + 1;
                    if (randomNumber <= 5) {
                        if (EjeX < 0 || EjeX > 970) {
                            barco.setDireccion(180 + barco.getDireccion());
                        }
                        if (EjeY < 0 || EjeY > 670) {
                            barco.setDireccion(180 + barco.getDireccion());
                        }
                    } else {
                        if (EjeX < 0 || EjeX > 970) {
                            barco.setDireccion(180 - barco.getDireccion());
                        }
                        if (EjeY < 0 || EjeY > 670) {
                            barco.setDireccion(-barco.getDireccion());
                        }
                    }
                } else {
                    Random random = new Random();
                    int randomNumber = random.nextInt(10) + 1;
                    if (randomNumber <= 5) {
                        if (EjeX < 0 || EjeX > 970) {
                            barco.setDireccion(180 + barco.getDireccion());
                        }
                        if (EjeY < 0 || EjeY > 670) {
                            barco.setDireccion(180 + barco.getDireccion());
                        }
                    } else {
                        if (EjeX < 0 || EjeX > 970) {
                            barco.setDireccion(180 - barco.getDireccion());
                        }
                        if (EjeY < 0 || EjeY > 670) {
                            barco.setDireccion(-barco.getDireccion());
                        }
                    }
                }
            }
        }
    }

    public static double coordenadasDosBarcos(Barcos barcos1, Barcos barcos2) {
        double x1 = barcos1.getImagen().getLayoutX();
        double y1 = barcos1.getImagen().getLayoutY();
        double x2 = barcos2.getImagen().getLayoutX();
        double y2 = barcos2.getImagen().getLayoutY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static boolean detectarBarcos(Barcos barcos1, Barcos barcos2) {
        double distancia = coordenadasDosBarcos(barcos1, barcos2);
        return distancia <= barcos1.getSonar();
    }

    public static void rotar(Barcos barcos, double grados) {
        barcos.getImagen().setRotate(barcos.getImagen() .getRotate() + grados);
    }
}
