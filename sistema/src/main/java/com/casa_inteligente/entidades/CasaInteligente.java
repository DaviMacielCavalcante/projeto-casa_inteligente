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

////CLIMATIZADOR
    public void alterarTemperatura(String comodo, int temperatura){
       if(temperatura>15 && temperatura<30){
         for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Climatizador){
                Climatizador c = (Climatizador) dispositivo;
                if(comodo.equals(c.getComodo()) && c.isLigado()) {
                    c.setTemperatura(temperatura);
                    System.out.println("Temperatura alterada para: "+temperatura+" celsius.");
                }  else{
                    System.out.println("Climatizador desligado, impossivel alterar a temperatura");
                    }
                }
            }
        } else {
            System.out.println("Temperatura invalida");
        }
    }
    public void ligarClimatizador(String comodo){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Climatizador){
                Climatizador c = (Climatizador) dispositivo;
                if(comodo.equals(c.getComodo()) && !c.isLigado()){
                    c.ligar();
                    System.out.println("Climatizador ligado");
                }
            }
        }
    }

    public void desligarClimatizador(String comodo){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Climatizador){
                Climatizador c = (Climatizador) dispositivo;
                if(comodo.equals(c.getComodo()) && !c.isLigado()){
                    c.ligar();
                    System.out.println("Climatizador desligado");
                }
            }
        }
    }
}
/////FIM CLIMATIZADOR