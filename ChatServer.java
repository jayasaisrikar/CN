import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class ChatServer {
 public static void main(String[] args) throws IOException {
 ServerSocket serverSocket = new ServerSocket(8080);
 System.out.println("Server started, waiting for connection...");
 Socket clientSocket = serverSocket.accept();
 System.out.println("Client connected");
 BufferedReader in = new BufferedReader(new 
InputStreamReader(clientSocket.getInputStream()));
 String inputLine;
 while ((inputLine = in.readLine()) != null) {
 System.out.println("Received message from client: " + inputLine);
 }
 in.close();
 clientSocket.close();
 serverSocket.close();
 }
}
