package com.casa_inteligente.entidades;

public class Fogao extends Dispositivo {
    private String tipo = "Fogao";
    private double temperatura;    

    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public Fogao(boolean ligado) {
        super(ligado);
        this.temperatura = 0.0;
    }

    @Override
    public String toString() {
        return "Fogão [ligado= " + isLigado() + ", " + "temperatura= " + temperatura + "]";
    }    

    public String getComodo() {
        return comodo;
    }

    public void setComodo(String novoComodo) {
        this.comodo = novoComodo;    
}
}