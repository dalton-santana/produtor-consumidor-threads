/**************************************************************************************
* Autor: Dalton Jose Santos Sant'Ana
* Matricula: 201510220
* Inicio: 19/07/2016
* Ultima alteracao: 31/07/2016
* Nome: Produtor/consumidor 
* Funcao: Simulacao de um ponto de onibus
/*************************************************************************************/

import java.awt.event.*;

public class Acoes implements ActionListener {


  private Janela janela;
  private Produtor produtor;
  private Consumidor consumidor;
  public static boolean permissaoDeExeThread = false; // variavel que permite as threads

  public Acoes(Janela janela) { // construtor da classe
    this.janela = janela;//recebe a janela
    produtor = new Produtor();
    consumidor = new Consumidor();
  }//fim construtor da classe


  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == janela.botaoAumentarSaida) { // se o botao pressionado foi o de aumentar a saida
      // se a velocidade eh  maior que 0 entao decrementa
      if (Principal.velocidadeSaida >= 1) {
        Principal.velocidadeSaida--;  //fim if
      }

      janela.velocidadeSaida.setText("VELOCIDADE: " + (10 - Principal.velocidadeSaida)); //imprimindo o valor da velocidade atual

    } //fim if
    else if (e.getSource() == janela.botaoAumentarEntrada) { // se o botao pressionado foi o de aumentar a entrada
      //se a velocidade eh maior que 0 entao incrementa
      if (Principal.velocidadeEntrada >= 1) {
        Principal.velocidadeEntrada--; // fim if
      }

      janela.velocidadeEntrada.setText("VELOCIDADE: " + (10 - Principal.velocidadeEntrada)); //imprimindo o valor da velocidade atual

    } //fim else if
    else if (e.getSource() == janela.botaoDiminuirSaida) { // se o botao pressionado foi diminuir saida
      //se a velocidade eh menor que 10 incrementar
      if (Principal.velocidadeSaida < 9) {
        Principal.velocidadeSaida++; // fim if
      }

      janela.velocidadeSaida.setText("VELOCIDADE: " + (10 - Principal.velocidadeSaida)); //imprimindo o valor da velocidade atual

    } //fim else if
    else if (e.getSource() == janela.botaoDiminuirEntrada) {// se o botao pressionado foi o de diminuir a entrada
      //se a velocidade eh menor que 10 entao incrementar 
      if (Principal.velocidadeEntrada < 9) {
        Principal.velocidadeEntrada++;
      }

      janela.velocidadeEntrada.setText("VELOCIDADE: " + (10 - Principal.velocidadeEntrada));//imprimindo o valor da velocidade atual

    }//fim else if
    else if (e.getSource() == janela.botaoIniciar) {//se  o botao pressionado foi o de iniciar
      permissaoDeExeThread = true;
      produtor.start();
      consumidor.start();
    } //fim else if
    else if (e.getSource() == janela.botaoParar) { // se o botao pressionado foi o de parar
      permissaoDeExeThread = false;
      janela.dispose();//para a execucao
      new Janela();
    }//fim else if
  }//fim run



}//fim class
