package com.casa_inteligente;

import com.casa_inteligente.entidades.CasaInteligente;

public class App {
    public static void main( String[] args ) {

        CasaInteligente ci = new CasaInteligente();  

        ci.ligarTv("quarto");
        //ci.mudarCanalTv("quarto", 10);
        //ci.mudarVolumeTv("quarto", 30);

         
        System.out.println(ci);  

        ci.salvarDipositivos();
    }
}
