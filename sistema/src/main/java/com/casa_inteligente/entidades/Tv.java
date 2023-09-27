package com.casa_inteligente.entidades;

public class Tv extends Dispositivo{
    
    private String comodo;
    private int canal, volume;    

    public Tv(boolean ligado) {
        super(ligado);
    }

    public Tv(boolean ligado, String comodo) {
        super(ligado);
        this.comodo = comodo;
    }    

    public String getComodo() {
        return comodo;
    }

    public void setComodo(String comodo) {
        this.comodo = comodo;
    }

    public int getCanal() {
        return canal;
    }


    public int getVolume() {
        return volume;
    }

    public void mudarCanal(int canal) {
        this.canal = canal;
    }

    public void mudarVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Tv [ligado= " + isLigado() + ", comodo= " + comodo + ", canal= " + canal + ", volume= " + volume + "]";
    }    
}
