/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package projetsinnovation.client;

import projetsinnovation.common.Request;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import projetsinnovation.common.Response;
import projetsinnovation.common.model.*;
import projetsinnovation.server.Speaker;

public class Client {
    private BufferedReader ois;
    private PrintWriter oos;
    private String name;
    private Socket server;
    
    public Client() {
        this.connect("10.212.96.221", 2002);
    }
    
    private void connect(String host, Integer port) {
        try {
            this.server = new Socket(host, port);
            ois = new BufferedReader( new InputStreamReader( server.getInputStream() ) );
            oos = new PrintWriter(server.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void call(String request){
        try {
            int value=0;
            String str = "";

            // reads to the end of the stream
            while((value = ois.read()) != -1) {
                char c = (char)value;
                str+=c;

                System.out.print(c);

                //System.out.println("+++++"+str+"++++++");
                if (str.endsWith("</askName>\n")){
                    //System.out.println("IN");
                    oos.println("Tim");
                }
            }

            Speaker.speak("_______________________________");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();

        String ajouterIdee="add/n" +
                "idee originale/n" +
                "mobile/n";
        String getListIdea="getListIdea/n";
        String getStudentsInterested="getStudentInterestIdea/n" +
                "0/n";

        client.call("TEST");
    }
}
