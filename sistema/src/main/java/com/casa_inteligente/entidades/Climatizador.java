package com.casa_inteligente.entidades;

public class Climatizador extends Dispositivo{
    private String comodo;
    private int temperatura = 20;

    public Climatizador(boolean ligado) {
        super(ligado);
    }

    public Climatizador(boolean ligado, String comodo) {
        super(ligado);
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
    
    @Override
    public String toString() {
        return "Climatizador [ligado= " + isLigado() + ", comodo= " + comodo + ", temperatura= " + temperatura + "]";
    }
}