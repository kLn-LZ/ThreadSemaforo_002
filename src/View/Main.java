package View;

import Controller.ThreadCozinha;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        int permissao = 1;

        Semaphore semaforo = new Semaphore(permissao);

        for(int Prato = 1; Prato <= 5; Prato++) {
            int idPrato = (int) ((Math.random() * 11) + 1);
            Thread tCozinha = new ThreadCozinha(idPrato, semaforo);

            tCozinha.start();
        }

    }
}
