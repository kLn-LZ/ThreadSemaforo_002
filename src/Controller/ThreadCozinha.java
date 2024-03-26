package Controller;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class ThreadCozinha extends Thread {

    Scanner scan = new Scanner(System.in);
    private int idPrato;
    private Semaphore semaforo;

    public ThreadCozinha(int idPrato, Semaphore semaforo) {
        this.idPrato = idPrato;
        this.semaforo = semaforo;
    }

    public void run () {

        cozimento();

    }
    private void cozimento () {
        int tempoTotal = 0;
        int tempoCozinhado = 0;

        if(idPrato % 2 != 0) {
            String nomeDoPrato = "Sopa de Cebola";
            tempoTotal = (int) ((Math.random() * 801) + 500);

            System.out.println("Prato Sopa de Cebola começou a ser cozinhado");

            while(tempoCozinhado < tempoTotal) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                tempoCozinhado = tempoCozinhado + 100;
                System.out.println("Percentual de cozimento: " + ((float) tempoCozinhado/tempoTotal) * 100 + "%");
            }
            try {
                semaforo.acquire();
                entregar(nomeDoPrato);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                semaforo.release();
            }
        }

        if(idPrato % 2 == 0) {
            String nomeDoPrato = "Lasanha a Bolonhesa";
            tempoTotal = (int) ((Math.random() * 1201) + 600);

            System.out.println("Prato Lasanha a Bolonhesa começou a ser cozinhado");
            while(tempoCozinhado < tempoTotal) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tempoCozinhado = tempoCozinhado + 100;
                System.out.println("Percentual de cozimento: " + ((float) tempoCozinhado/tempoTotal) * 100 + "%");
            }
            try {
                semaforo.acquire();
                entregar(nomeDoPrato);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                semaforo.release();
            }
        }



    }


    private void entregar(String nomePrato) {
        String entregar = "";
        System.out.println("Prato " + nomePrato + " pronto, digite 'entregar' para entregar");

            entregar = scan.next();



        try {
            sleep(500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Prato " + nomePrato + " Entregue");
    }
}
