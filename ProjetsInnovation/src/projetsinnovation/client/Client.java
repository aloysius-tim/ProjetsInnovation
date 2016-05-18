/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package projetsinnovation.client;

import projetsinnovation.common.IProjetInnovation;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import projetsinnovation.server.model.*;

/**
 * @author Sofiane & Tim
 */

public class Client {
    public static void main(String[] argv) {
        try {
            Registry registry = LocateRegistry.getRegistry(10000);
            IProjetInnovation stub = (IProjetInnovation) registry.lookup("Innovation");

            System.out.println(stub.createIdea(new Idea("Desc1", Technologies.WEB, new Student("tim", "keynes"), new ArrayList<Student>())).toString());
            System.out.println(stub.createIdea(new Idea("Desc2", Technologies.WEB, new Student("tim", "keynes"), new ArrayList<Student>())).toString());
            System.out.println(stub.getIdeas().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
