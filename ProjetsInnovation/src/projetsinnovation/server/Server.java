/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package projetsinnovation.server;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import projetsinnovation.common.*;

/**
 *
 * @author Sofiane & Tim
 */
public class Server {
    private Integer port = 8000;
    private ServerSocket socket;
    private Service service;
    
    public Server() {
        try {
            this.socket = new ServerSocket(this.port);
            this.service = new Service();
        }catch(IOException io){
            Speaker.speakException(io);
            System.exit(1);
        }
    }
    
    public Server(Integer port) {
        try {
            this.port = port;
            this.service = new Service();
            this.socket = new ServerSocket(this.port);
        }catch(IOException io){
            Speaker.speakException(io);
            System.exit(1);
        }
    }
    
    public void launch() {
        Speaker.announceStart(this.port);
        while(true) {
            try {
                Socket s = this.socket.accept();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                    
                    Request request = (Request)ois.readObject();
                    
                    Speaker.speakWithTime("New request " + request);
                    
                    Response response = this.service.serve(request);
                    
                    oos.writeObject(response);
                    oos.close();
                } catch (IOException | ClassNotFoundException e) {
                    Speaker.speakException(e);
                }
            } catch (Exception e) {
                Speaker.speakException(e);
            }
        }
    }
}
