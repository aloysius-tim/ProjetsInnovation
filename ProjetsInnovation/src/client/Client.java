package client;

import sun.plugin.dom.exception.InvalidStateException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Client {
    private Socket server;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public Client connect(String host, int port) {
        if (server != null) {
            throw new InvalidStateException("Socket is already connected");
        }

        try {
            server = new Socket(host, port);
            ois = new ObjectInputStream(server.getInputStream());
            oos = new ObjectOutputStream(server.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }

        return this;
    }

    public <T> T get(String name, Class<T> clazz) {
        return (T) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{clazz},
                new RMIHandler(name, ois, oos)
        );
    }
}
