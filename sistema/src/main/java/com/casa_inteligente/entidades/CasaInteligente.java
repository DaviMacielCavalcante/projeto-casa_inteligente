package com.casa_inteligente.entidades;

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

    public void salvarDipositivos() {
        Conversor cv = new Conversor();

        cv.salvarDipositivos(dispositivos);
    }

    public void desligarFogao() {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo instanceof Fogao) {
                dispositivo.desligar();
            }
        }
    }
    
    public void ligarFogao() {
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

    public void fogTemperatura(double temperatura){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Fogao){
                Fogao f = (Fogao) dispositivo;
                f.setTemperatura(temperatura);
            }
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

    public void ativarCamera(boolean camera){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Seguranca){
                Seguranca cam = (Seguranca) dispositivo;
                if(camera != cam.isLigado()){
                    cam.ligar();
                    System.out.println("Camera ligada");
                } else {
                    System.out.println("Camera ja ligada");
                }
            }
        }
    }

    public void desligarCamera(boolean camera){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Seguranca){
                Seguranca cam = (Seguranca) dispositivo;
                if(camera = cam.isLigado()){
                    cam.desligar();
                    System.out.println("Desligando sistema...");
                } else {
                    System.out.println("Camera ja desligada");
                }
            }
        }
    }
    public void ligarAlarme(boolean alarme){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Seguranca){
                Seguranca al = (Seguranca) dispositivo;
                if(alarme != al.isLigado()){
                    al.ligar();
                    System.out.println("alarme ligado");
                } else {
                    System.out.println("alarme ja estava ligado");
                }
            }
        }
    }

    public void desligarAlarme(boolean alarme){
        for(Dispositivo dispositivo : dispositivos){
            if(dispositivo instanceof Seguranca){
                Seguranca al = (Seguranca) dispositivo;
                if(alarme = al.isLigado()){
                    al.desligar();
                    System.out.println("Alarme desligado");
                } else {
                    System.out.println("Alarme ja estava desligado");
                }
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