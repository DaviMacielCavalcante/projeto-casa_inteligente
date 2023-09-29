package com.casa_inteligente.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.casa_inteligente.entidades.CasaInteligente;

public class Tela extends JFrame{
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
        quarJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                abrirQuarto();              
            }            
        });

        JButton segJButton = new JButton("Seguranca");
        panel.add(segJButton);
        segJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
            }            
        });        

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
    public void abrirQuarto(){
        JFrame qrtMenu = new JFrame("Quarto");
        qrtMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qrtMenu.setSize(500, 500);

        JPanel panelQrt = new JPanel();

        JButton cliLigJButton = new JButton("Ligar Climatizador");
        cliLigJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ci.ligarClimatizador("quarto");
                ci.salvarDipositivos();
            }
            
        });

        JButton cliDesJButton = new JButton("Desligar Climatizador");
        cliDesJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ci.desligarClimatizador("quarto");
                ci.salvarDipositivos();
            }
            
        });

        JButton cliTemJButton = new JButton("Configurar Temperatura");
        cliTemJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Escolha a temperatura do climatizador");
                try{
                    int temperatura = Integer.parseInt(input);
                    ci.alterarTemperatura("quarto", temperatura);
                    ci.salvarDipositivos();
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Selecione uma temperatura valida");
                }
            }
            
        });

        JButton iluLigButton = new JButton("Ligar iluminacao");
        iluLigButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //FALTA OS METODOS
            }
            
        });

        JButton iluDesJButton = new JButton("Desligar iluminacao");
        iluDesJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //FALTA O METODO
            }
            
        });

        JButton tvLigJButton = new JButton("Ligar TV");
        tvLigJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ci.ligarTv("quarto");
                ci.salvarDipositivos();
            }
            
        });

        JButton tvDesJButton = new JButton("Desligar TV");
        tvDesJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ci.desligarTv("quarto");
                ci.salvarDipositivos();
            }
            
        });

        JButton tvVolJButton = new JButton("Configurar Volume:");
        tvVolJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Coloque o volume desejado");
                try{
                    int volume = Integer.parseInt(input);
                    ci.mudarVolumeTv("quarto", volume);
                    ci.salvarDipositivos();
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Coloque um volume valido");
                }
            }
            
        });

        JButton tvCanalJButton = new JButton("Mudar Canal:");
        tvCanalJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Coloque o canal desejado");
                try {
                    int canal = Integer.parseInt(input);
                    ci.mudarCanalTv("quarto", canal);
                    ci.salvarDipositivos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Coloque um canal valido");
                }
            }
            
        });

        

        panelQrt.add(cliLigJButton);
        panelQrt.add(cliDesJButton);
        panelQrt.add(cliTemJButton);
        panelQrt.add(iluLigButton);
        panelQrt.add(iluDesJButton);
        panelQrt.add(tvLigJButton );
        panelQrt.add(tvDesJButton);
        panelQrt.add(tvVolJButton);
        panelQrt.add(tvCanalJButton);
        qrtMenu.add(panelQrt);
        qrtMenu.setVisible(true);
    }

}
