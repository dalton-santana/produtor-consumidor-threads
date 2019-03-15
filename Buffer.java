/**************************************************************************************
* Autor: Dalton Jose Santos Sant'Ana
* Matricula: 201510220
* Inicio: 19/07/2016
* Ultima alteracao: 31/07/2016
* Nome: Produtor/consumidor 
* Funcao: Simulacao de um ponto de onibus
/*************************************************************************************/

import java.util.*;

public class Buffer {
  private final int valorMax = 9;
  private ArrayList<Integer> buffer;
  private Janela janela;

  public Buffer(Janela janela) {
    buffer = new ArrayList<>(valorMax);
    this.janela = janela;
  }

  public boolean add(int valor) {
    buffer.add(valor);//adicionar passageiro
    mostrarPassageiro();

    return true;
  }//fim add

  public boolean remove() {
    buffer.remove(0);//remover 
    retirarPassgeiro();//remove passageiro

    return true;
  }//fim remove


  public int getSize() {
    return buffer.size();
  } 

  public void mostrarPassageiro() {
    for (int i = 8; i >= 0; i--) { // percorre o array das cadeiras da janela do fim ao comeco
      if (!janela.cadeiras.get(i).isVisible()) { // testando se a JLabel nao esta visivel

        janela.cadeiras.get(i).setVisible(true);//torna o JLabel de Entrada visivel
        break;
      }//fim if
    }//fim for
  }//fim mostraProduto

 
  public void retirarPassgeiro() {
    for (int i = 8; i >= 0; i--) { // percorre o array das cadeiras da janela do fim ao comeco
      if (janela.cadeiras.get(i).isVisible()) { // testando se a JLabel esta visivel
        janela.cadeiras.get(i).setVisible(false);//torna o JLabel de Entrada invisivel
        break;
      }//fim if
    }//fim for
  }//fim meto
}//fim Buffer
