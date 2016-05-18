/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package projetsinnovation.sofiane;

import java.io.*;
import java.net.Socket;


/**
 * @author Sofiane & Tim
 */
public class Client {
    private DataInputStream dis;
    private DataOutputStream dos;
    private String name;
    private Socket server;
    
    public Client() {
        this.connect("10.212.103.98", 8080);
    }
    
    private void connect(String host, Integer port) {
        try {
            this.server = new Socket(host, port);
            dis = new DataInputStream(this.server.getInputStream());
            dos = new DataOutputStream(this.server.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String call(String request) {
        try {
            this.dos.writeUTF(request);
            return this.dis.readUTF();
        } catch(Exception e) {
            return "ERROR";
        }
    }
    
    private String createIdea(String name, String description, String technology, Integer ownerId, String ownerName, String ownerMail) throws IOException {
        String request = "{\n" +
                "    \"action\": \"ADD\",\n" +
                "    \"data\": {\n" +
                "        \"id\": null,\n" +
                "        \"name\": \""+name+"\",\n" +
                "        \"description\": \""+description+"\",\n" +
                "        \"technology\": \""+technology+"\",\n" +
                "        \"owner\": {\n" +
                "          \"id\": "+ownerId+",\n" +
                "          \"username\": \""+ownerName+"\",\n" +
                "          \"mail\": \""+ownerMail+"\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        
        return this.call(request);
    }
    
    private String getIdeas() {
        String request = "{\n" +
                "    \"action\": \"LIST\",\n" +
                "    \"data\": {}\n" +
                "}";
        
        return this.call(request);
    }
    
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        
        try {
            String response = client.createIdea("Mon idée", "Sa description", "Scala", 1, "Sofiane", "talebs@icloud.com");
            System.out.println(response);
            System.out.println(client.getIdeas());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
