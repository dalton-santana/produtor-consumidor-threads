/**************************************************************************************
* Autor: Dalton Jose Santos Sant'Ana
* Matricula: 201510220
* Inicio: 19/07/2016
* Ultima alteracao: 31/07/2016
* Nome: Produtor/consumidor 
* Funcao: Simulacao de um ponto de onibus
/*************************************************************************************/
import java.awt.Point;

public class Consumidor extends Thread {
  public Consumidor() {
  }

  public void run() {
    while (Acoes.permissaoDeExeThread) {

      try {
        //regiao critica
        Principal.semafaroCheio.acquire();//down
        Principal.mutex.acquire();// adquire permissao para poder executar-down
        consumir();
        Principal.mutex.release();//libera permissao de execucao-up
        Principal.semafaroVazio.release();//up

        //velocidade de saida
        sleep(Principal.velocidadeSaida * 2000);

      } catch (InterruptedException  e) {

      } //fim try-catch

    }//fim while
  }//fim run

  private void consumir() {//metodo de de o passageiro entrar
    Principal.buffer.remove();//remove passageiro do array
		//processo de animacao
    Janela.imgSaida.setVisible(true);
    Point posicao = Janela.imgSaida.getLocation();
    for (int i = 0; i < 50; i++) {
      try {

        if (posicao.x >= Janela.painel.getWidth() - 700) {
          posicao.x -= 4;

        }

        Janela.imgSaida.setLocation(posicao);
        Thread.sleep(100);
      } catch (Exception e) {}

    }

    Janela.imgSaida.setBounds(80, 135, 50, 200);
    Janela.imgSaida.setVisible(false);

  }//fim consumir

}//fim Consumidor
