/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package projetsinnovation.server;

import java.io.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import projetsinnovation.common.*;

/**
 *
 * @author Sofiane & Tim
 */
public class Server {
     public static void main(String[] argv) {
        try {
            IProjetInnovation skeleton = (IProjetInnovation) UnicastRemoteObject.exportObject(new ProjetInnovation(), 10000);
            Registry registry = LocateRegistry.createRegistry(10000);
            registry.rebind("Innovation", skeleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
}

