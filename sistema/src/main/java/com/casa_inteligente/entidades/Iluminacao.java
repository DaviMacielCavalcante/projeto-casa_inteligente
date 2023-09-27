package com.casa_inteligente.entidades;

public class Iluminacao extends Dispositivo {

    private String comodo;

    public Iluminacao(boolean ligado, String comodo){
        super(ligado);
        this.comodo = comodo;
    }

    public String getComodo() {
        return comodo;
    }

    public void setComodo(String comodo) {
        this.comodo = comodo;
    }

}