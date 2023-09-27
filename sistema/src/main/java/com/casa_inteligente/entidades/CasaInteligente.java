package com.casa_inteligente.entidades;

import java.util.ArrayList;

public class CasaInteligente {
    

    public ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    public void adicionarDispositivos(Dispositivo obj) {
        dispositivos.add(obj);
    }

    public void desligarFogao() {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Fogao) {
                dispositivo.desligar();
            }
        }
    }

    public void desligarIluminacao(String comodo) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Iluminacao) {
                Iluminacao i = (Iluminacao) dispositivo;
                if (comodo.equals(i.comodo)) {
                    i.desligar();
                }
            }
        }
    }
}
