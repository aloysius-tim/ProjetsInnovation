/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.server;

import java.io.*;
import java.net.*;

/**
 *
 * @author Sofiane
 */
public class Server {
    
    private Integer port;
    private ServerSocket socket;
    private Speaker speaker;
    
    public Server(Integer port) {
        this.port = port;
        this.speaker = new Speaker();
    }
    
    public void launch() {
        this.speaker.announceStart(this.port);
        while(true) {
            try {
                Socket s = this.socket.accept();
                OutputStream oos = s.getOutputStream();
            } catch (IOException e) {
                this.speaker.speakException(e);
            } catch (Exception e) {
                this.speaker.speakException(e);
            }
        }
    }
    
    public static void main(String[] args) {
        Server server = new Server(6000);
        server.launch();
    }
}
