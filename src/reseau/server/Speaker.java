package reseau.server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Speaker {

    private Speaker() {
    }

    public static void speakError(String message) {
        System.out.println(message);
    }

    public static void announceStart(Integer port) {
        System.out.println("Server is started on port " + port.toString());
    }

    public static void speak(Object o) {
        System.out.println(o.toString());
    }

    public static void speakWithTime(Object o) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = dateFormat.format(new Date());
        Speaker.speak(time + " " + o.toString());
    }

    public static void speakException(Exception e) {
        e.printStackTrace();
    }
}
