package com.casa_inteligente.entidades;

public class Climatizador extends Dispositivo{
    private String comodo;
    private int temperatura = 20;

    public Climatizador() {
    }

    public Climatizador(String comodo) {
        this.comodo = comodo;
    }

    public String getComodo() {
        return comodo;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    
    
}