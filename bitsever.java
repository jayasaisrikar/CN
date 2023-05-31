import java.io.*;
import java.net.*;
public class bitsever {
public static void main(String[] args) throws Exception {
ServerSocket serverSocket = new ServerSocket(1236);
System.out.println("Server is running...");
while (true) {
Socket connectionSocket = serverSocket.accept();
DataInputStream inFromClient = new
DataInputStream(connectionSocket.getInputStream());
String stuffedStream = inFromClient.readUTF();
String destuffedStream = bitDestuffing(stuffedStream);
System.out.println("Received bit stream with stuffing:01111110" + stuffedStream+"01111110");
System.out.println("Destuffed bit stream: " + destuffedStream);
connectionSocket.close();
}
}
private static String bitDestuffing(String stuffedStream) {
String destuffedStream = "";
int count = 0;
for (int i = 0; i < stuffedStream.length(); i++) {
if (stuffedStream.charAt(i) == '1') {
count++;
destuffedStream += '1';
} else {

destuffedStream += '0';
}
if (count == 5) {
i++;
count = 0;
}
}
return destuffedStream;
}
}
