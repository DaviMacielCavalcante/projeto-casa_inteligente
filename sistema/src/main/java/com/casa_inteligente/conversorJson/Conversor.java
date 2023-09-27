package com.casa_inteligente.conversorJson;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.casa_inteligente.entidades.Climatizador;
import com.casa_inteligente.entidades.Dispositivo;
import com.casa_inteligente.entidades.Fogao;
import com.casa_inteligente.entidades.Geladeira;
import com.casa_inteligente.entidades.Iluminacao;
import com.casa_inteligente.entidades.Seguranca;
import com.casa_inteligente.entidades.Tv;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
            } else if (name.equals("comodo")) {
                comodo = reader.nextString();
            } else if (name.equals("canal")) {
                canal = reader.nextInt();
            } else if (name.equals("volume")) {
                volume = reader.nextInt();
            } else {
                reader.skipValue();
            }                        
        }
        reader.endObject();        

        switch (tipo) {
            case "Tv":
                Tv tv = new Tv(ligado, comodo);
                return tv;

            case "Fogao":
                Fogao f = new Fogao(ligado);
                return f;

            case "Geladeira": 
                Geladeira g = new Geladeira(ligado);
                return g;

            case "Climatizador":
                Climatizador cli = new Climatizador(ligado, comodo);
                return cli;

            case "Iluminacao":
                Iluminacao il = new Iluminacao(ligado, comodo);
                return il;

            case "Seguranca":
                Seguranca se = new Seguranca(ligado);
                return se;
            default:
                break;
        }
        return null;
    }

    public void salvarDipositivos(ArrayList<Dispositivo> dispositivos) {
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String path = "sistema\\src\\main\\java\\com\\casa_inteligente\\jsons";

        String nomeArquivo = path + "\\" + "dispositivos.json";
        try {
            FileWriter escrita = new FileWriter(nomeArquivo);
            escrita.write(gson.toJson(dispositivos));
            escrita.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
