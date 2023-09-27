package com.casa_inteligente.entidades;

public class Geladeira extends Dispositivo{
    private double temperatura;

    public Geladeira() {
        this.temperatura = 10;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    

}