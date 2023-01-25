package com.example.batallanavalav2;

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

    public static void detectarBordes(Barcos barcos1) {
        double x = barcos1.getImagenBarco().getLayoutX();
        double y = barcos1.getImagenBarco().getLayoutY();
        if (x < 0 || x > 988) {
            barcos1.setDirection(180 - barcos1.getDirection());
        }

        if (y < 0 || y > 730) {
            barcos1.setDirection(-barcos1.getDirection());
        }
    }

    public static double coordenadasDosBarcos(Barcos barcos1, Barcos barcos2) {
        double x1 = barcos1.getImagenBarco().getLayoutX();
        double y1 = barcos1.getImagenBarco().getLayoutY();
        double x2 = barcos2.getImagenBarco().getLayoutX();
        double y2 = barcos2.getImagenBarco().getLayoutY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static boolean detectarBarcoPorSonar(Barcos barcos1, Barcos barcos2) {
        double distancia = coordenadasDosBarcos(barcos1, barcos2);
        return distancia <= barcos1.getSonar();
    }
}
