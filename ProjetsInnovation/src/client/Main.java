package client;

import common.IProjetInnovation;
import server.model.Student;

/**
 * Created by Aloysius_tim on 30/04/2016.
 */
public class Main {
    public static void main(String[] argv) {
        Client r = new Client().connect("localhost", 10000);

        IProjetInnovation maman = r.get("projetInnovation", IProjetInnovation.class);

        System.out.println("TEST1");
        System.out.println(maman.createIdea("TEST", "WEB", new Student("TEST", "TEST")));

        System.out.println("TEST2");


        //Client r1 = new Client().connect("localhost", 10000);

        //IProjetInnovation cs1 = r.get("projetInnovation", IProjetInnovation.class);

        System.out.println(maman.getIdeas());
        System.out.println("TEST3");
    }
}
