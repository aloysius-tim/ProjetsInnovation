package server;

import server.model.ProjetInnovation;

/**
 * Created by Aloysius_tim on 30/04/2016.
 */
public class Main {
    public static void main(String[] argv) {
        ProjetInnovation projetInnovation=new ProjetInnovation();

        new Server()
                .register("projetInnovation", projetInnovation)
                .publish(10000);
    }
}
