import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 3000);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        String message = (String) in.readObject();
        System.out.println("Received from server: " + message);

        socket.close();
    }
}
