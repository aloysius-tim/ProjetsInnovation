package reseau.client;

import reseau.common.Request;
import reseau.common.Response;
import reseau.server.Speaker;
import reseau.server.model.Idea;
import reseau.server.model.Student;
import reseau.server.model.Technologies;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String name;
    private Socket server;

    public Client() {
        this.connect("localhost", 6000);
    }

    public static void main(String[] args) {
        Client client = new Client();

        Student s = new Student("John", "john@doe.com"); // Nouvel étudiant
        Idea idea = new Idea("Je veux faire un nouveau Uber", Technologies.WEB, s, null); // Idée déjà existante
        Idea idea2 = new Idea("Voici une nouvelle idée", Technologies.MOBILE, s, null); // Nouvelle idée

        client.getTeam(idea);
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

    private void call(String method) {
        try {
            this.call(method, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void call(String method, Object[] args) {
        try {
            Request request = new Request(method, args);
            Speaker.speakWithTime("Sending request : " + request);
            Speaker.speak("_______________________________");
            oos.writeObject(request);
            Response response = (Response) ois.readObject();
            Speaker.speakWithTime("Received response : " + response);
            Speaker.speak("_______________________________");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getIdeas() {
        this.call("getIdeas");
    }

    private void createIdea(Idea idea) {
        this.call("createIdea", new Object[]{idea});
    }

    private void getTeam(Idea idea) {
        this.call("getTeam", new Object[]{idea});
    }

    private void subscribeTo(Idea idea, Student student) {
        this.call("subscribeTo", new Object[]{idea, student});
    }
}
