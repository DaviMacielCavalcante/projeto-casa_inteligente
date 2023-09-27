package com.casa_inteligente.entidades;

public class Seguranca extends Dispositivo {

    private String tipo = "Seguranca";
    private boolean camera;
    private boolean alarme;   

    public Seguranca(boolean ligado, boolean camera, boolean alarme) {
        super(ligado);
        this.camera = camera;
        this.alarme = alarme;
    }

    public Seguranca(boolean ligado) { 
        super(ligado);
    }
    
    public boolean isCamera() {
        return camera;
    }
    public void setCamera(boolean camera) {
        this.camera = camera;
    }
    public boolean isAlarme() {
        return alarme;
    }
    public void setAlarme(boolean alarme) {
        this.alarme = alarme;
    }

    @Override
    public String toString() {
        return "Segurança [ligado= " + isLigado() + "]";
    }
}
