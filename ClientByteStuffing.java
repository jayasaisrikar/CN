import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class ClientByteStuffing {
public static void main(String[] args) {
try (Socket socket = new Socket("localhost", 5000)) {
Scanner input = new Scanner(System.in);
BufferedReader in = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
System.out.print("Enter the data to be sent: ");
String data = input.nextLine();
System.out.print("Enter the flag sequence: ");
String flag = input.nextLine();
System.out.print("Enter the escape character: ");
String escape = input.nextLine();
System.out.print("Enter the escape sequence: ");
String escapeSequence = input.nextLine();
out.println(data);
out.println(flag);
out.println(escape);
out.println(escapeSequence);
String stuffedData = in.readLine();
System.out.println("Stuffed data: " + stuffedData);
} catch (IOException e) {
System.out.println("Error: " + e.getMessage());
}
}
}