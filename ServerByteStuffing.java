import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerByteStuffing {
public static void main(String[] args) {
try (ServerSocket serverSocket = new ServerSocket(5000)) {
System.out.println("Server running on port " + serverSocket.getLocalPort());
while (true) {
Socket socket = serverSocket.accept();
BufferedReader in = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
String data = in.readLine();
String flag = in.readLine();
String escape = in.readLine();
String escapeSequence = in.readLine();
String stuffedData = characterStuffing(data, flag, escape, escapeSequence);
out.println(stuffedData);
}
} catch (IOException e) {
System.out.println("Error: " + e.getMessage());
}
}
private static String characterStuffing(String data, String flag, String escape, String escapeSequence) {
String stuffedData = "";

for (int i = 0; i < data.length(); i++) {
if (data.substring(i, i + flag.length()).equals(flag)) {
stuffedData += escape + flag;
} else if (data.substring(i, i + escape.length()).equals(escape)) {
stuffedData += escape + escapeSequence;
} else {
stuffedData += data.charAt(i);
}
}
return flag + stuffedData + flag;
}
}