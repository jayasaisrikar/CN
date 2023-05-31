import java.io.*;
import java.net.*;
import java.util.*;
public class bit {
public static void main(String[] args) throws Exception {
Scanner sc=new Scanner(System.in);
System.out.println("enter a bit stream");
String bitStream =sc.nextLine();
String stuffedStream = bitStuffing(bitStream);
Socket clientSocket = new Socket("localhost", 1236);
DataOutputStream outToServer = new
DataOutputStream(clientSocket.getOutputStream());
outToServer.writeUTF(stuffedStream);
clientSocket.close();
}
private static String bitStuffing(String bitStream) {
String stuffedStream = "";
int count = 0;
for (int i = 0; i < bitStream.length(); i++) {
if (bitStream.charAt(i) == '1') {
count++;
stuffedStream += '1';
} else {
stuffedStream += '0';
}
if (count == 5) {
count = 0;
stuffedStream += '0';
}
}
return stuffedStream;
}
}
