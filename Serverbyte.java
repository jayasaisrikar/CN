import java.io.*;
import java.net.*;

public class Serverbyte {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        byte[] receivedData = new byte[1024];
        int bytesRead = dis.read(receivedData);
        String unstuffedData = new String(receivedData, 0, bytesRead).replaceAll("}", "}}");
        System.out.println("Received stuffed data: " + new String(receivedData, 0, bytesRead));
        System.out.println("Unstuffed data: " + unstuffedData);
        socket.close();
        serverSocket.close();
    }
}

