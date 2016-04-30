/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation;

import projetsinnovation.server.Server;
import projetsinnovation.server.Speaker;

/**
 *
 * @author Sofiane
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Server server = new Server(6000);
            server.launch();
        } catch (Exception e) {
            Speaker.speakException(e);
        }
        
    }
    
}
