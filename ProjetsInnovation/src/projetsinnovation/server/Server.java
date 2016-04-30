/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.server;

import java.io.*;
import java.net.*;
import projetsinnovation.common.*;

/**
 *
 * @author Sofiane
 */
public class Server {
    
    private Integer port;
    private ServerSocket socket;
    private Speaker speaker;
    private Service service;
    
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
                this.service.setRequest(null);
                Response response = this.service.getResponse();
                // Serialize response & send to client
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
