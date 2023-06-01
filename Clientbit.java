import java.io.*;
import java.net.*;

public class Clientbit {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter data to send: ");
        String data = inputReader.readLine();
        String stuffedData = encode(data, "01111110", "010");
        System.out.println("Stuffed data: " + stuffedData);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(stuffedData);
        socket.close();
    }

    public static String encode(String input, String flag, String escape) {
        StringBuilder encodedData = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentBit = input.charAt(i);
            count = (currentBit == '1') ? count + 1 : 0;
            if (count < 5) {
                encodedData.append(currentBit);
            } else if (count == 5) {
                encodedData.append(currentBit).append('0');
                count = 0;
            }
        }
        return encodedData.toString();
    }
}

