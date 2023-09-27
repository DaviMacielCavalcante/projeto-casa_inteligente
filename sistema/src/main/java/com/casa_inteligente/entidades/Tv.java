package com.casa_inteligente.entidades;

public class Tv extends Dispositivo{
    
    private String comodo;
    private int canal, volume;

    public void mudarCanal(int canal) {
        this.canal = canal;
    }

    public void mudarVolume(int volume) {
        this.volume = volume;
    }


}
