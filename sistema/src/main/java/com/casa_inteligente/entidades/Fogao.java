package com.casa_inteligente.entidades;

public class Fogao extends Dispositivo {
    private String tipo = "Fogao";
    private double temperatura;    

    public Fogao(boolean ligado) {
        super(ligado);
        this.temperatura = 0.0;
    }

    @Override
    public String toString() {
        return "Fogão [ligado= " + isLigado() + ", " + "temperatura= " + temperatura + "]";
    }        
}
