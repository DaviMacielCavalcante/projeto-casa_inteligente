package com.casa_inteligente;

import com.casa_inteligente.entidades.CasaInteligente;
import com.casa_inteligente.entidades.Climatizador;
import com.casa_inteligente.entidades.Fogao;
import com.casa_inteligente.entidades.Seguranca;

public class App {
    public static void main( String[] args ) {

        CasaInteligente ci = new CasaInteligente();
  
        ci.adicionarDispositivos(new Climatizador("sala"));

        ci.ligarClimatizador("sala");

        ci.alterarTemperatura("sala", 30);

        ci.adicionarDispositivos(new Fogao());

        ci.desligarFogao();

        ci.adicionarDispositivos(new Seguranca());

        ci.ativarCamera(true);
        ci.ativarCamera(true);
        ci.desligarCamera(false);
        ci.desligarCamera(false);

        ci.ligarAlarme(true);
        ci.ligarAlarme(true);
        ci.desligarAlarme(false);
        ci.desligarAlarme(false);
    
    }
}
