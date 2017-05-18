package reseau.server;

import reseau.common.Request;
import reseau.common.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Integer port = 8000;
    private ServerSocket socket;
    private Service service;

    public Server() {
        try {
            this.socket = new ServerSocket(this.port);
            this.service = new Service();
        } catch (IOException io) {
            Speaker.speakException(io);
            System.exit(1);
        }
    }

    public Server(Integer port) {
        try {
            this.port = port;
            this.service = new Service();
            this.socket = new ServerSocket(this.port);
        } catch (IOException io) {
            Speaker.speakException(io);
            System.exit(1);
        }
    }

    public void launch() {
        Speaker.announceStart(this.port);
        while (true) {
            try {
                Socket s = this.socket.accept();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

                    Request request = (Request) ois.readObject();

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
