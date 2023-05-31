import java.io.*;
import java.net.*;
import java.util.*;
public class Bit {
public static void main(String[] args) throws Exception {
Scanner sc=new Scanner(System.in);
Socket socket = new Socket("localhost", 1236);
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
System.out.println("enter a bit stream");
String bitStream =sc.nextLine();
out.println(bitStuffing(bitStream));
socket.close();
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
