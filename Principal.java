/**************************************************************************************
* Autor: Dalton Jose Santos Sant'Ana
* Matricula: 201510220
* Inicio: 19/07/2016
* Ultima alteracao: 31/07/2016
* Nome: Produtor/consumidor 
* Funcao: Simulacao de um ponto de onibus
/*************************************************************************************/
import java.util.concurrent.Semaphore;

public class Principal {
  public static Buffer buffer;
  public static int velocidadeEntrada = 5, velocidadeSaida = 5;
  
  public static Semaphore mutex = new Semaphore(1);  // semafaro com 1 permisao
  public static Semaphore semafaroVazio = new Semaphore(9); //semafaro para o buffer cheio
  public static Semaphore semafaroCheio = new Semaphore(0); //samafaro para o buffer vazio

  public static void main(String[] args) {
    Janela janela = new Janela();//inicializando
    buffer = new Buffer(janela);

  }
}
