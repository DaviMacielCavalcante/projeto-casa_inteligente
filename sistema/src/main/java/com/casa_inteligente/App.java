package com.casa_inteligente;

import com.casa_inteligente.entidades.CasaInteligente;
import com.casa_inteligente.entidades.Fogao;

public class App {
    public static void main( String[] args ) {

        CasaInteligente ci = new CasaInteligente();

        ci.adicionarDispositivos(new Fogao());

        ci.desligarFogao();
    }
}
