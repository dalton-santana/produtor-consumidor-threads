/**************************************************************************************
* Autor: Dalton Jose Santos Sant'Ana
* Matricula: 201510220
* Inicio: 19/07/2016
* Ultima alteracao: 31/07/2016
* Nome: Produtor/consumidor 
* Funcao: Simulacao de um ponto de onibus
/*************************************************************************************/

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

public class Janela extends JFrame {
public JButton botaoAumentarEntrada, botaoAumentarSaida,
         botaoDiminuirEntrada, botaoDiminuirSaida, botaoParar,
         botaoIniciar;
  public static JLabel labelTitulo, labelProdutor, labelConsumidor,
         imgEntrada, imgSaida, imgOnibus;
  private int x = 185;
  public static JPanel painel;
  public JLabel velocidadeSaida, velocidadeEntrada;

  public ArrayList<JLabel> cadeiras = new ArrayList<>(9);//lista das posicoes no onibus

  public Janela() {
    super("Simulacao de Entrada/Saida de passageiros em um Onibus");
    this.setSize(670, 400);//tamanho da janela
    this.setLayout(null);//layout da janela
    this.setDefaultCloseOperation(3);
    this.setResizable(false);
		this.setLocationRelativeTo(null);
    painel = new JPanel();
    painel.setLayout(null); // layout do painel principal
    painel.setBackground(Color.WHITE);
    painel.setSize(656, 400);//tamanho do painel principal
    this.add(painel);
    this.add(painel);

    labelTitulo = new JLabel("Ponto de Onibus");//label de titulo
    labelTitulo.setBounds(200, 10, 380, 60);//tamanho e localizaxao do label de titulo
    labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));//fonte, estilo e tamanho do titulo
    painel.add(labelTitulo);

    labelConsumidor = new JLabel("SAIDA");//label de consumidor
    labelConsumidor.setBounds(95, 275, 260, 40);//tamanho e posicao do label de consumidor
    labelConsumidor.setFont(new Font("Arial", Font.BOLD, 12));//fonte, estilo e consumidor
    painel.add(labelConsumidor);

    labelProdutor = new JLabel("ENTRADA");//label de produtor
    labelProdutor.setBounds(547, 275, 260, 40);//localizacao e tamanho do label de produtor
    labelProdutor.setFont(new Font("Arial", Font.BOLD, 12));//fonte, estilo e tamanho do label de produtor
    painel.add(labelProdutor);

    botaoAumentarSaida = new JButton("+");//botao de aumentar a saida
    botaoAumentarSaida.setBounds(115, 310, 45, 30);//tamanho e localizacao do botao
    botaoAumentarSaida.addActionListener(new Acoes(this));//acao do botao
    painel.add(botaoAumentarSaida);

    botaoDiminuirSaida = new JButton("-");//botao de diminuir saida
    botaoDiminuirSaida.setBounds(65, 310, 45, 30);//tamanho e localizacao do botao
    botaoDiminuirSaida.addActionListener(new Acoes(this));//aco do botao
    painel.add(botaoDiminuirSaida);

    botaoAumentarEntrada = new JButton("+");//botao de aumentar a entrada
    botaoAumentarEntrada.setBounds(570, 310, 45, 30);//tamanho e localizacao do botao
    botaoAumentarEntrada.addActionListener(new Acoes(this));//acao do botao
    painel.add(botaoAumentarEntrada);

    botaoDiminuirEntrada = new JButton("-");//botao de diminuir a entrada
    botaoDiminuirEntrada.setBounds(520, 310, 45, 30);//tamanho e localizacao do botao
    botaoDiminuirEntrada.addActionListener(new Acoes(this));//acao do botao
    painel.add(botaoDiminuirEntrada);

    botaoParar = new JButton("Parar");//botao de para a aplicacao
    botaoParar.setBounds(320, 310, 80, 30);//tamanho e localizacao do botao
    botaoParar.addActionListener(new Acoes(this));//acao do botao parar
    painel.add(botaoParar);

    botaoIniciar = new JButton("Iniciar");//botao de iniciar a aplicacao
    botaoIniciar.setBounds(240, 310, 80, 30);//tamanho e localizacao do botao
    botaoIniciar.addActionListener(new Acoes(this));//acao do botao
	  painel.add(botaoIniciar);

    imgEntrada = new JLabel(new ImageIcon(getClass().getResource("imagens" + File.separator + "fora.gif")));
    imgEntrada.setBounds(656, 135, 50, 200);//tamanho e localizacao da imagem
    painel.add(imgEntrada);

    imgSaida = new JLabel(new ImageIcon(getClass().getResource("imagens" + File.separator + "fora.gif")));
    imgSaida.setBounds(80, 135, 50, 200);//tamanho e localizacao da imagem
    imgSaida.setVisible(false);
    painel.add(imgSaida);

    velocidadeSaida = new JLabel("VELOCIDADE: 5 ");//label da velocidade
    velocidadeSaida.setBounds(70, 200, 200, 300);//tamanho e localizacao do label
    painel.add(velocidadeSaida);

    velocidadeEntrada = new JLabel("VELOCIDADE: 5");//label da velocidade
    velocidadeEntrada.setBounds(525, 200, 200, 300);//tamanho e localizacao
    painel.add(velocidadeEntrada);

    for (int i = 0; i < 9; i++) {//posicionando labels das janelas do onibus, e importando a imagem do mesmo

      cadeiras.add(i, new JLabel(new ImageIcon(getClass().getResource("imagens" + File.separator + "dentro.gif"))));
      cadeiras.get(i).setBounds(x, 131, 40, 40);
      if (i % 2 == 0) {
        x = x + 40;
      } else {
        x = x + 53;
      }
      cadeiras.get(i).setVisible(false);
    }
    cadeiras.add(0, new JLabel(new ImageIcon(getClass().getResource("imagens" + File.separator + "dentro.gif"))));
    cadeiras.get(0).setBounds(40, 131, 40, 40);
    cadeiras.get(0).setVisible(false);

    for (int i = 0; i < 9; i++) {//adicionando labels no painel
      painel.add(cadeiras.get(i));

    }
		//adicionando imagem do onibus de fundo
    imgOnibus = new JLabel(new ImageIcon(getClass().getResource("imagens" + File.separator + "imgOnibusAberto.png")));
    imgOnibus.setBounds(0, 80, 656, 203);
    painel.add(imgOnibus);

    this.setVisible(true);

  }

}
