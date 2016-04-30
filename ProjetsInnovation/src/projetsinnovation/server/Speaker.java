/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.server;

/**
 *
 * @author Sofiane
 */
public class Speaker {
    
    private Speaker() {}
    
    public static void speakError(String message) {
        System.out.println(message);
    }
    
    public static void announceStart(Integer port) {
        System.out.println("Server is started on port " + port.toString());
    }
    
    public static void speak(Object o) {
        System.out.println(o.toString());
    }
    
    public static void speakException(Exception e) {
        e.printStackTrace();
    }
}
