/**************************************************************************************
* Autor: Dalton Jose Santos Sant'Ana
* Matricula: 201510220
* Inicio: 19/07/2016
* Ultima alteracao: 31/07/2016
* Nome: Produtor/consumidor 
* Funcao: Simulacao de um ponto de onibus
/*************************************************************************************/
import java.awt.Point;

public class Produtor extends Thread {
  public Produtor() { }//fim construtor


  public void run() {

    while (Acoes.permissaoDeExeThread) {
      try {
        Principal.semafaroVazio.acquire();//down
        Principal.mutex.acquire(); // adquire permissao para poder executar-down
        produzir(); // produzir elemento
        Principal.mutex.release();//libera permissao de execucao-up
        Principal.semafaroCheio.release();//up
        sleep(Principal.velocidadeEntrada * 2000);

      } catch (InterruptedException e) { } //fim try - catch

    }//fim while
  }//fim run

 
  public void produzir() {
	  //processo de animacao
    Janela.imgEntrada.setVisible(true);
    Point posicao = Janela.imgEntrada.getLocation();
    for (int i = 0; i < 25; i++) {
      try {

        if (posicao.x >= Janela.painel.getWidth() - 100) {
          posicao.x -= 4;
        }

        Janela.imgEntrada.setLocation(posicao);
        Thread.sleep(100);
      } catch (Exception e) {
        System.out.println("ErroPainel");
      }

    }
    
    Janela.imgEntrada.setBounds(656, 135, 50, 200);
    Janela.imgEntrada.setVisible(false);
    Principal.buffer.add(1);//adiciona passageiro do array
  }//fim produzir

}//fim Produtor