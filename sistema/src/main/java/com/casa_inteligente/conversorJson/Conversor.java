package com.casa_inteligente.conversorJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.casa_inteligente.entidades.Dispositivo;
import com.casa_inteligente.entidades.Fogao;
import com.google.gson.stream.JsonReader;

public class Conversor {    

    public Conversor() {        
    }

     public ArrayList<Dispositivo> carregarDispositivos(BufferedReader in) throws IOException {
        
           JsonReader reader = new JsonReader(new BufferedReader(in));     
           
           try {
            return lerJsonArray(reader);
           } finally {
            reader.close();
           }        
    }

    private ArrayList<Dispositivo> lerJsonArray(JsonReader reader) throws IOException {
        ArrayList<Dispositivo> dispositivos = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            dispositivos.add(lerObjeto(reader));
        }
        reader.endArray();
        return dispositivos;
    }

    private Dispositivo lerObjeto(JsonReader reader) throws IOException {   

        boolean ligado = false;
        String tipo = null;
        String comodo = null;
        double temperatura = 0;
        int canal = 0;
        int volume = 0;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("tipo")) {
                tipo = reader.nextString();                
            } else if (name.equals("ligado")) {
                ligado = reader.nextBoolean();
            } else if (name.equals("temperatura")) {
                temperatura = reader.nextDouble();
            } else {
                reader.skipValue();
            }                        
        }
        reader.endObject();
        if (tipo.equals("Fogao")) {
                Fogao f = new Fogao(ligado);
                return f;
            }   
        return null;
    }

}
