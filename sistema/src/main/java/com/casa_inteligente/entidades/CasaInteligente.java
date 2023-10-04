package com.casa_inteligente.entidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.casa_inteligente.conversorJson.Conversor;

public class CasaInteligente {        

    public ArrayList<Dispositivo> dispositivos = carregarDispositivos();

    public void adicionarDispositivos(Dispositivo obj) {
        dispositivos.add(obj);
    }    

    public void salvarDispositivos() {
        Conversor cv = new Conversor();

        cv.salvarDipositivos(dispositivos);
    }

    public void desligarFogao(String comodo) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Fogao) {
                Fogao f = (Fogao) dispositivo;
                f.desligar();
                f.setTemperatura(0);
            }
        }
    }
    
    public void ligarFogao(String comodo) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Fogao) {
                dispositivo.ligar();
            }
        }
    }


    public void desligarIluminacao(String comodo) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Iluminacao) {
                Iluminacao i = (Iluminacao) dispositivo;
                if (comodo.equals(i.getComodo())) {
                    i.desligar();
                }
            }
        }
    }


    public void desligarTv(String comodo) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Tv) {
                Tv i = (Tv) dispositivo;
                if (comodo.equals(i.getComodo()) && i.isLigado()) {
                    i.desligar();
                }
            }
        }
    }

    public void ligarTv(String comodo) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Tv) {
                Tv i = (Tv) dispositivo;
                if (comodo.equals(i.getComodo()) && !i.isLigado()) {
                    i.ligar();
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
/////FIM CLIMATIZADOR

    public void fogTemperatura(String comodo, int temperatura){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Fogao){
                Fogao f = (Fogao) dispositivo;
                f.setTemperatura(temperatura);
            }
        }
    }

    public void ligarClimatizador(String comodo) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Climatizador) {
                Climatizador c = (Climatizador) dispositivo;
                if (comodo.equals(c.getComodo()) && !c.isLigado()) {
                    c.ligar();
                    System.out.println("Climatizador ligado");
                }
            }
        }
    }



    public void mudarCanalTv(String comodo, int canal) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Tv) {
                Tv i = (Tv) dispositivo;
                if (comodo.equals(i.getComodo()) && i.isLigado()) {
                    i.mudarCanal(canal);
                }
            }
        }
    }

    public void desligarClimatizador(String comodo){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Climatizador){
                Climatizador c = (Climatizador) dispositivo;
                if(comodo.equals(c.getComodo()) && c.isLigado()){
                    c.desligar();
                    System.out.println("Climatizador desligado");

                }
            }
        }
    }


    public void mudarVolumeTv(String comodo, int volume) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Tv) {
                Tv i = (Tv) dispositivo;
                if (comodo.equals(i.getComodo()) && i.isLigado()) {
                    i.mudarVolume(volume);
                }
            }
        }
    }
    ///////////////////

    public void ativarCamera() {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Seguranca) {
                Seguranca cam = (Seguranca) dispositivo;
                if(cam.isLigado()){                  
                    cam.setCamera(true);
                }
            }
        }
    }
    public void desligarCamera() {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Seguranca) {
                Seguranca cam = (Seguranca) dispositivo;
                if(cam.isLigado()){
                    cam.setCamera(false);
                }
            }
        }
    }
    public void ligarSeguranca(){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Seguranca){
                Seguranca al = (Seguranca) dispositivo;
                if(!al.isLigado()){
                    al.ligar();
                    System.out.println("Segurança ligada");
                } else {
                    System.out.println("Segurança já estava ligada");
                }
            }
        }
    }
    public void desligarSeguranca(){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Seguranca){
                Seguranca al = (Seguranca) dispositivo;
                if(al.isLigado()){
                    al.desligar();
                    System.out.println("Segurança desligada");
                } else {
                    System.out.println("Segurança já estava desligada");
                }
             }
      }
    }
    public void ligarAlarme(){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Seguranca){
                Seguranca al = (Seguranca) dispositivo;
                if(al.isLigado()){
                    al.setAlarme(true);
                    System.out.println("alarme ligado");
                } else {
                    System.out.println("alarme ja estava ligado");
                }
            }
        }
    }

    public void desligarAlarme(){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Seguranca){
                Seguranca al = (Seguranca) dispositivo;
                if(al.isLigado()){
                    al.setAlarme(false);
                    System.out.println("Alarme desligado");
                } else {
                    System.out.println("Alarme ja estava desligado");
                }
            }
        }
    }
    public void ligarIluminacao(String comodo){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Iluminacao){
                Iluminacao il = (Iluminacao) dispositivo;
                if(comodo.equals(il.getComodo()) && !il.isLigado()){
                    il.ligar();
                    System.out.println("Iluminacao ligada");
                }
            }
        }
    }
    public void ligarGeladeira(){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Geladeira){
                Geladeira gel = (Geladeira) dispositivo;
                gel.ligar();
                System.out.println("Geladeira ligada");
            }
        }
    }
    public void desligarGeladeira(){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Geladeira){
                Geladeira gel = (Geladeira) dispositivo;
                gel.desligar();
                System.out.println("Geladeira desligada");
            }
        }
    } public void geladeiraTemperatura(int temperatura){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Geladeira){
                Geladeira gel = (Geladeira) dispositivo;
                if(temperatura>(-20) && temperatura<30){
                    gel.setTemperatura(temperatura);
                    System.out.println("temperatura valida");
                } else{
                    System.out.println("Temperatura invalida");
                }
            }
        }
    }
    public void configurarTemperaturaFogao(String comodo, int temperatura) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Fogao) {
                Fogao f = (Fogao) dispositivo;
                f.setTemperatura(temperatura);                
            }
        }
    }   

    private ArrayList<Dispositivo> carregarDispositivos() {  
        Conversor cv = new Conversor();
        String path = "sistema\\src\\main\\java\\com\\casa_inteligente\\jsons\\dispositivos.json";   
        BufferedReader fi; 
        ArrayList<Dispositivo> dispositivos = new ArrayList<>();  
        try {            
            fi = new BufferedReader(new InputStreamReader(new FileInputStream(path))); 
            dispositivos = cv.carregarDispositivos(fi);           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dispositivos;
    }

    @Override
    public String toString() {
        return "CasaInteligente [dispositivos=" + dispositivos + "]";
    }    
}