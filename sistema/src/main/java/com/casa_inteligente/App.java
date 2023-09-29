package com.casa_inteligente;

import com.casa_inteligente.entidades.CasaInteligente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class App extends JFrame {;
    CasaInteligente ci = new CasaInteligente();

////////////////////////////////////
    public void menuInicial(){
        JFrame tela = new JFrame("Casa Inteligente");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(400, 300);
        JPanel panel = new JPanel();
        tela.add(panel);


        JButton salaJButton = new JButton("1-Sala");
        panel.add(salaJButton);
        salaJButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
               abrirSala();
            }
            
        });
        JButton cozinhaJButton = new JButton("2-Cozinha");
        panel.add(cozinhaJButton);
        cozinhaJButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCozinha();
            }
            
        });
        JButton quarJButton = new JButton("3-Quarto");
        panel.add(quarJButton);


        tela.setVisible(true);    
    }
/////////////////////////////////
    public void abrirSala(){
       JFrame salaMenu = new JFrame("Sala");
       salaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       salaMenu.setSize(500, 500);


       salaMenu.setVisible(true);
       JPanel panelSala = new JPanel();

       panelSala.setLayout(new FlowLayout());

       JLabel labelSala = new JLabel("Opcoes sala:");

       JButton iluLiJButton = new JButton("Ligar Iluminacao");
       JButton iluDesJButton = new JButton("Desligar Iluminacao");

       iluLiJButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            ci.ligarClimatizador("quarto");
            ci.salvarDipositivos();
        }
        
       });
        iluDesJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ci.desligarClimatizador("quarto");
                ci.salvarDipositivos();
            }
            
        });
        panelSala.add(labelSala);
        panelSala.add(iluLiJButton);
        panelSala.add(iluDesJButton);

        salaMenu.add(panelSala);
    }

    public void abrirCozinha(){
        JFrame cozMenu = new JFrame("Cozinha");
        cozMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cozMenu.setSize(500, 500);
        JPanel panelCoz = new JPanel();

        panelCoz.setLayout(new FlowLayout());

        JLabel labelCoz = new JLabel("Opcoes cozinha");

        JButton fogLiJButton = new JButton("Ligar Fogao");
        JButton fogDesJButton = new JButton("Desligar Fogao");
        JButton fogTempJButton = new JButton("Escolher temperatura");

        fogLiJButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ci.ligarFogao();
                ci.salvarDipositivos();
            }
            
        });
        fogDesJButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ci.desligarFogao();
                ci.salvarDipositivos();
            }
            
        });
        fogTempJButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Digite a temperatura:");
                try{
                    double temperatura = Double.parseDouble(input);
                    ci.fogTemperatura(temperatura);
                    ci.salvarDipositivos();
                } catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor, iinsira um numero valido");
                }
            }
            
        });

        panelCoz.add(labelCoz);
        panelCoz.add(fogLiJButton);
        panelCoz.add(fogDesJButton);
        panelCoz.add(fogTempJButton);
        cozMenu.add(panelCoz);

        cozMenu.setVisible(true);
    }
//////////////////////////////////////////
    public static void main( String[] args ) {

        App myApp = new App();
        myApp.menuInicial();
    }
}