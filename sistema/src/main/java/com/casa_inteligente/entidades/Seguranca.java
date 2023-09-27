package com.casa_inteligente.entidades;

public class Seguranca extends Dispositivo {
    private boolean camera;
    private boolean alarme;   

    public Seguranca(boolean camera, boolean alarme) {
        this.camera = camera;
        this.alarme = alarme;
    }

    public Seguranca() { }
    
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

    
}
