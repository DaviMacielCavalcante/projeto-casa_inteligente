package com.casa_inteligente.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.casa_inteligente.entidades.CasaInteligente;

public class Tela extends JFrame {
    private CasaInteligente casaInteligente = new CasaInteligente();

    public void menuInicial() {
        JFrame telaPrincipal = new JFrame("Casa Inteligente");
        telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaPrincipal.setSize(400, 300);
        JPanel painelPrincipal = new JPanel();
        telaPrincipal.add(painelPrincipal);

        JButton salaBotao = criarBotao("1 - Sala");
        JButton cozinhaBotao = criarBotao("2 - Cozinha");
        JButton quartoBotao = criarBotao("3 - Quarto");
        JButton segurancaBotao = criarBotao("4 - Segurança");

        painelPrincipal.setLayout(new GridLayout(4, 1, 5, 5));
        painelPrincipal.add(salaBotao);
        painelPrincipal.add(cozinhaBotao);
        painelPrincipal.add(quartoBotao);
        painelPrincipal.add(segurancaBotao);

        salaBotao.addActionListener(e -> abrirSala());
        cozinhaBotao.addActionListener(e -> abrirCozinha());
        quartoBotao.addActionListener(e -> abrirQuarto());
        segurancaBotao.addActionListener(e -> abrirSeguranca());

        telaPrincipal.setVisible(true);
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
        JFrame salaMenu = criarJanela("Sala");
        JPanel painelSala = new JPanel();
        painelSala.setLayout(new FlowLayout());
        JLabel labelSala = new JLabel("Opções sala:");

        JButton ligarIluminacaoButton = criarBotaoAcao("Ligar Iluminação", "sala", "ligarIluminacao");
        JButton desligarIluminacaoButton = criarBotaoAcao("Desligar Iluminação", "sala", "desligarIluminacao");

        painelSala.add(labelSala);
        painelSala.add(ligarIluminacaoButton);
        painelSala.add(desligarIluminacaoButton);

        salaMenu.add(painelSala);
    }

    public void abrirCozinha() {
        JFrame cozinhaMenu = criarJanela("Cozinha");
        JPanel painelCozinha = new JPanel();
        painelCozinha.setLayout(new FlowLayout());
        JLabel labelCozinha = new JLabel("Opções cozinha");

        JButton ligarFogaoButton = criarBotaoAcao("Ligar Fogão", "", "ligarFogao");
        JButton desligarFogaoButton = criarBotaoAcao("Desligar Fogão", "", "desligarFogao");
        JButton escolherTempFogaoButton = criarBotaoAcao("Escolher Temperatura", "", "escolherTempFogao");
        JButton ligarGeladeiraButton = criarBotaoAcao("Ligar Geladeira", "", "ligarGeladeira");
        JButton desligarGeladeiraButton = criarBotaoAcao("Desligar Geladeira", "", "desligarGeladeira");
        JButton tempGeladeiraButton = criarBotaoAcao("Temperatura Geladeira", "", "tempGeladeira");
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

        cozinhaMenu.add(painelCozinha);
    }

    public void abrirQuarto() {

        JFrame quartoMenu = criarJanela("Quarto");
        JPanel painelQuarto = new JPanel();

        JButton ligarClimatizadorButton = criarBotaoAcao("Ligar Climatizador", "quarto", "ligarClimatizador");
        JButton desligarClimatizadorButton = criarBotaoAcao("Desligar Climatizador", "quarto", "desligarClimatizador");
        JButton configTempClimatizadorButton = criarBotaoAcao("Configurar Temperatura", "quarto", "configTempClimatizador");
        JButton ligarIluminacaoQuartoButton = criarBotaoAcao("Ligar Iluminação", "quarto", "ligarIluminacao");
        JButton desligarIluminacaoQuartoButton = criarBotaoAcao("Desligar Iluminação", "quarto", "desligarIluminacao");
        JButton ligarTvButton = criarBotaoAcao("Ligar TV", "quarto", "ligarTv");
        JButton desligarTvButton = criarBotaoAcao("Desligar TV", "quarto", "desligarTv");
        JButton configVolumeTvButton = criarBotaoAcao("Configurar Volume", "quarto", "configVolumeTv");
        JButton mudarCanalTvButton = criarBotaoAcao("Mudar Canal", "quarto", "mudarCanalTv");

        painelQuarto.add(ligarClimatizadorButton);
        painelQuarto.add(desligarClimatizadorButton);
        painelQuarto.add(configTempClimatizadorButton);
        painelQuarto.add(ligarIluminacaoQuartoButton);
        painelQuarto.add(desligarIluminacaoQuartoButton);
        painelQuarto.add(ligarTvButton);
        painelQuarto.add(desligarTvButton);
        painelQuarto.add(configVolumeTvButton);
        painelQuarto.add(mudarCanalTvButton);

        quartoMenu.add(painelQuarto);
    }

    public void abrirSeguranca() {
        JFrame segurancaMenu = criarJanela("Segurança");
        JPanel painelSeguranca = new JPanel();

        JButton ligarAlarmeButton = criarBotaoAcao("Ligar Alarme", "", "ligarAlarme");
        JButton desligarAlarmeButton = criarBotaoAcao("Desligar Alarme", "", "desligarAlarme");
        JButton ligarCamerasButton = criarBotaoAcao("Ligar Câmeras", "", "ligarCameras");
        JButton desligarCamerasButton = criarBotaoAcao("Desligar Câmeras", "", "desligarCameras");

        painelSeguranca.add(ligarAlarmeButton);
        painelSeguranca.add(desligarAlarmeButton);
        painelSeguranca.add(ligarCamerasButton);
        painelSeguranca.add(desligarCamerasButton);

        segurancaMenu.add(painelSeguranca);
    }

    private JFrame criarJanela(String titulo) {
        JFrame janela = new JFrame(titulo);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(500, 500);
        janela.setVisible(true);
        return janela;
    }

    private JButton criarBotaoAcao(String texto, String dispositivo, String acao) {
        JButton botao = criarBotao(texto);
        botao.addActionListener(e -> realizarAcao(dispositivo, acao));
        return botao;
    }

    private void realizarAcao(String dispositivo, String acao) {
        switch (acao) {
            case "ligarIluminacao":
                casaInteligente.ligarIluminacao(dispositivo);
                break;
            case "desligarIluminacao":
                casaInteligente.desligarIluminacao(dispositivo);
                break;
        }
        casaInteligente.salvarDispositivos();
    }
}