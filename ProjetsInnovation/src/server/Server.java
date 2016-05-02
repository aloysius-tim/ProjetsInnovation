package server;

import common.Request;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    private Map<String, Object> services = new HashMap<>();
    private ServerSocket ss;

    public Server register(String name, Object service) {
        services.put(name, service);
        return this;
    }

    public void publish(int port) {
        try {
            ss = new ServerSocket(port);
            while(true) {
                final Socket s = ss.accept();
                new Thread() {
                    public void run() {
                        try {
                            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                            Request ic = (Request) ois.readObject();
                            Object targetObject = services.get(ic.getName());
                            Object result = targetObject.getClass().getMethod(ic.getMethod(), args2Class(ic.getArgs())).invoke(targetObject, ic.getArgs());
                            oos.writeObject(result);
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new RuntimeException(e.getMessage(), e);
                        }
                    }
                }.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private Class[] args2Class (Object[] objs) {
        if (objs!=null){
            List<Class> classes = new ArrayList<Class>();
            for (Object o : objs) {
                classes.add(o.getClass());
            }
            return classes.toArray(new Class[]{});
        }else return new Class[0];
    }
}
