package com.casa_inteligente.entidades;

public class Geladeira extends Dispositivo{
    private int temperatura;

    public Geladeira(boolean ligado) {
        super(ligado);
        this.temperatura = 10;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
    

}