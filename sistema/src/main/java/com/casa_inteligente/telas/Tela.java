package com.casa_inteligente.telas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.swing.*;
import javax.xml.crypto.Data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.casa_inteligente.entidades.CasaInteligente;
import com.casa_inteligente.datas.JodaTime;

public class Tela extends JFrame {
    private CasaInteligente casaInteligente = new CasaInteligente();
    private JodaTime data = new JodaTime();

    public Tela() {
        menuInicial();
    }

    public void menuInicial() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        JPanel painelPrincipal = new JPanel();
        add(painelPrincipal);

        JButton salaBotao = criarBotao("1 - Sala");
        JButton cozinhaBotao = criarBotao("2 - Cozinha");
        JButton quartoBotao = criarBotao("3 - Quarto");
        JButton segurancaBotao = criarBotao("4 - Segurança");
        JButton mostrarDataBotao = criarBotao("5 - Exibir Data ");

        painelPrincipal.setLayout(new GridLayout(5, 1, 5, 5));
        painelPrincipal.add(salaBotao);
        painelPrincipal.add(cozinhaBotao);
        painelPrincipal.add(quartoBotao);
        painelPrincipal.add(segurancaBotao);
        painelPrincipal.add(mostrarDataBotao);

        salaBotao.addActionListener(e -> abrirSala());
        cozinhaBotao.addActionListener(e -> abrirCozinha());
        quartoBotao.addActionListener(e -> abrirQuarto());
        segurancaBotao.addActionListener(e -> abrirSeguranca());
        mostrarDataBotao.addActionListener(e -> mostrarData());
        

        setVisible(true);
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setPreferredSize(new Dimension(150, 40));
        botao.setBackground(new Color(52, 152, 219));
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setMargin(new Insets(10, 10, 10, 10));
        return botao;
    }

    public void abrirSala() {
        JPanel painelSala = new JPanel();
        painelSala.setLayout(new FlowLayout());
        JLabel labelSala = new JLabel("Opções sala:");

        JButton ligarIluminacaoButton = criarBotaoAcao("Ligar Iluminação", "sala", "ligarIluminacao");
        JButton desligarIluminacaoButton = criarBotaoAcao("Desligar Iluminação", "sala", "desligarIluminacao");

        painelSala.add(labelSala);
        painelSala.add(ligarIluminacaoButton);
        painelSala.add(desligarIluminacaoButton);

        getContentPane().removeAll();
        getContentPane().add(painelSala);
        revalidate();
        repaint();
    }

    public void abrirCozinha() {
        JPanel painelCozinha = new JPanel();
        painelCozinha.setLayout(new FlowLayout());
        JLabel labelCozinha = new JLabel("Opções cozinha");

        JButton ligarFogaoButton = criarBotaoAcao("Ligar Fogão", "cozinha", "ligarFogao");
        JButton desligarFogaoButton = criarBotaoAcao("Desligar Fogão", "cozinha", "desligarFogao");
        JButton escolherTempFogaoButton = criarBotaoAcao("Escolher Temperatura Fogão", "cozinha", "configTempFogao");
        JButton ligarGeladeiraButton = criarBotaoAcao("Ligar Geladeira", "cozinha", "ligarGeladeira");
        JButton desligarGeladeiraButton = criarBotaoAcao("Desligar Geladeira", "cozinha", "desligarGeladeira");
        JButton tempGeladeiraButton = criarBotaoAcao("Temperatura Geladeira", "cozinha", "tempGeladeira");
        JButton ligarIluminacaoCozinhaButton = criarBotaoAcao("Ligar Iluminação", "cozinha", "ligarIluminacao");
        JButton desligarIluminacaoCozinhaButton = criarBotaoAcao("Desligar Iluminação", "cozinha", "desligarIluminacao");

        painelCozinha.add(labelCozinha);
        painelCozinha.add(ligarFogaoButton);
        painelCozinha.add(desligarFogaoButton);
        painelCozinha.add(escolherTempFogaoButton);
        painelCozinha.add(ligarGeladeiraButton);
        painelCozinha.add(desligarGeladeiraButton);
        painelCozinha.add(tempGeladeiraButton);
        painelCozinha.add(ligarIluminacaoCozinhaButton);
        painelCozinha.add(desligarIluminacaoCozinhaButton);

        getContentPane().removeAll();
        getContentPane().add(painelCozinha);
        revalidate();
        repaint();
    }

    public void abrirQuarto() {
        JPanel painelQuarto = new JPanel();

        JButton ligarClimatizadorButton = criarBotaoAcao("Ligar Climatizador", "quarto", "ligarClimatizador");
        JButton desligarClimatizadorButton = criarBotaoAcao("Desligar Climatizador", "quarto", "desligarClimatizador");
        JButton configTempClimatizadorButton = criarBotaoAcao("Configurar Temperatura Climatizador", "quarto", "configTempClimatizador");
        JButton ligarIluminacaoQuartoButton = criarBotaoAcao("Ligar Iluminação", "quarto", "ligarIluminacao");
        JButton desligarIluminacaoQuartoButton = criarBotaoAcao("Desligar Iluminação", "quarto", "desligarIluminacao");
        JButton ligarTvButton = criarBotaoAcao("Ligar TV", "quarto", "ligarTv");
        JButton desligarTvButton = criarBotaoAcao("Desligar TV", "quarto", "desligarTv");
        JButton configVolumeTvButton = criarBotaoAcao("Configurar Volume TV", "quarto", "configVolumeTv");
        JButton mudarCanalTvButton = criarBotaoAcao("Mudar Canal TV", "quarto", "mudarCanalTv");

        painelQuarto.add(ligarClimatizadorButton);
        painelQuarto.add(desligarClimatizadorButton);
        painelQuarto.add(configTempClimatizadorButton);
        painelQuarto.add(ligarIluminacaoQuartoButton);
        painelQuarto.add(desligarIluminacaoQuartoButton);
        painelQuarto.add(ligarTvButton);
        painelQuarto.add(desligarTvButton);
        painelQuarto.add(configVolumeTvButton);
        painelQuarto.add(mudarCanalTvButton);

        getContentPane().removeAll();
        getContentPane().add(painelQuarto);
        revalidate();
        repaint();
    }

    public void abrirSeguranca() {
        JPanel painelSeguranca = new JPanel();

        JButton ligarAlarmeButton = criarBotaoAcao("Ligar Alarme", "seguranca", "ligarAlarme");
        JButton desligarAlarmeButton = criarBotaoAcao("Desligar Alarme", "seguranca", "desligarAlarme");
        JButton ligarCamerasButton = criarBotaoAcao("Ligar Câmeras", "seguranca", "ligarCameras");
        JButton desligarCamerasButton = criarBotaoAcao("Desligar Câmeras", "seguranca", "desligarCameras");

        painelSeguranca.add(ligarAlarmeButton);
        painelSeguranca.add(desligarAlarmeButton);
        painelSeguranca.add(ligarCamerasButton);
        painelSeguranca.add(desligarCamerasButton);

        getContentPane().removeAll();
        getContentPane().add(painelSeguranca);
        revalidate();
        repaint();
    }

    private JButton criarBotaoAcao(String texto, String dispositivo, String acao) {
        JButton botao = criarBotao(texto);
        botao.addActionListener(e -> realizarAcao(dispositivo, acao));
        return botao;
    }
    private void mostrarData(){
        JOptionPane.showMessageDialog(this,"Belém: \n" + data.mostrarData() + "\n" + data.mostrarHora() );
    }


    private void realizarAcao(String dispositivo, String acao) {
        boolean ativar = true;
        switch (acao) {
            case "ligarIluminacao":
                casaInteligente.ligarIluminacao(dispositivo);
                JOptionPane.showMessageDialog(this, "Iluminação ligada na " + dispositivo);
                break;
            case "desligarIluminacao":
                casaInteligente.desligarIluminacao(dispositivo);
                JOptionPane.showMessageDialog(this, "Iluminação desligada na " + dispositivo);
                break;
            case "ligarFogao":
                casaInteligente.ligarFogao(dispositivo);
                JOptionPane.showMessageDialog(this, "Fogão ligado na " + dispositivo);
                break;
            case "desligarFogao":
                casaInteligente.desligarFogao(dispositivo);
                JOptionPane.showMessageDialog(this, "Fogão desligado na " + dispositivo);
                break;
            case "configTempFogao":
                casaInteligente.configurarTemperaturaFogao(dispositivo, 180);
                JOptionPane.showMessageDialog(this, "Temperatura do fogão configurada na " + dispositivo + ": 180°C");
                break;
            case "ligarGeladeira":
                casaInteligente.ligarGeladeira();
                JOptionPane.showMessageDialog(this, "Geladeira ligada");
                break;
            case "desligarGeladeira":
                casaInteligente.desligarGeladeira();
                JOptionPane.showMessageDialog(this, "Geladeira desligada");
                break;
            case "tempGeladeira":
                casaInteligente.geladeiraTemperatura(5);
                JOptionPane.showMessageDialog(this, "Temperatura da geladeira configurada: 5°C");
                break;
            case "ligarTv":
                casaInteligente.ligarTv(dispositivo);
                JOptionPane.showMessageDialog(this, "TV ligada na " + dispositivo);
                break;
            case "desligarTv":
                casaInteligente.desligarTv(dispositivo);
                JOptionPane.showMessageDialog(this, "TV desligada na " + dispositivo);
                break;
            case "configVolumeTv":
                casaInteligente.mudarVolumeTv(dispositivo, 20);
                JOptionPane.showMessageDialog(this, "Volume da TV configurado na " + dispositivo + ": 20");
                break;
            case "mudarCanalTv":
                casaInteligente.mudarCanalTv(dispositivo, 5);
                JOptionPane.showMessageDialog(this, "Canal da TV mudado na " + dispositivo + ": 5");
                break;
                case "ligarAlarme":
                casaInteligente.ligarAlarme();
                JOptionPane.showMessageDialog(this, "Alarme ligado na " + dispositivo);
                break;
            case "desligarAlarme":
                casaInteligente.desligarAlarme();
                JOptionPane.showMessageDialog(this, "Alarme desligado na " + dispositivo);
                break;
            
            case "ativarCamera":
                casaInteligente.ativarCamera();
                JOptionPane.showMessageDialog(this, "Camera ligada na: " + dispositivo);
                break;
            case "desligarCamera":
                casaInteligente.desligarCamera();
                JOptionPane.showMessageDialog(this, "Camera desligada na: " + dispositivo);
                break;
        }
        casaInteligente.salvarDispositivos();
    }
}
