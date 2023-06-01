import java.io.*;
import java.net.*;

public class Clientbyte {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter data to send: ");
        String data = inputReader.readLine();
        String stuffedData = data.replaceAll("}", "}}");
        System.out.println("Stuffed data: " + stuffedData);
        dos.write(stuffedData.getBytes());
        socket.close();
    }
}

