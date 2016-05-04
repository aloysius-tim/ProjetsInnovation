/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package projetsinnovation.client;

import projetsinnovation.common.Request;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import projetsinnovation.common.Response;
import projetsinnovation.common.model.*;
import projetsinnovation.server.Speaker;

/**
 * @author Sofiane
 */

/**
 * @author Alain Defrance
 */
public class Client {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String name;
    private Socket server;
    
    public Client() {
        this.connect("localhost", 6000);
    }
    
    private void connect(String host, Integer port) {
        try {
            this.server = new Socket(host, port);
            ois = new ObjectInputStream(this.server.getInputStream());
            oos = new ObjectOutputStream(this.server.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void call(String method) {
        try {
            Request request = new Request(method);
            Speaker.speakWithTime("Sending request : " + request);
            Speaker.speak("_______________________________");
            oos.writeObject(request);
            Response response = (Response)ois.readObject();
            Speaker.speakWithTime("Received response : " + response);
            Speaker.speak("_______________________________");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void call(String method, Object[] args) {
        try {
            Request request = new Request(method, args);
            Speaker.speakWithTime("Sending request : " + request);
            Speaker.speak("_______________________________");
            oos.writeObject(request);
            Response response = (Response)ois.readObject();
            Speaker.speakWithTime("Received response : " + response);
            Speaker.speak("_______________________________");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Client client = new Client();
        client.call("getIdeas");
    }
}
