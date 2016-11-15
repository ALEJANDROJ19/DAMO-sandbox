package arekusanda.lyrical.puntsmvc_1;

import android.graphics.Color;

public class Punt {
    private double coordX;
    private double coordY;
    private int color;
    private double mida;


    /**
     *
     * @param coordX Coordenada eix X
     * @param coordY Coordenada eix Y
     * @param color Color
     * @param mida Diametre
     */
    public Punt(double coordX, double coordY, int color, double mida) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.color = color;
        this.mida = mida;
    }

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public int getColor() {
        return color;
    }

    public double getMida() {
        return mida;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setMida(double mida) {
        this.mida = mida;
    }

    @Override
    public String toString() {
        return "Punt{" +
                "coordX=" + coordX +
                ", coordY=" + coordY +
                ", color=" + color +
                ", mida=" + mida +
                '}';
    }
}
