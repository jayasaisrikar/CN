import java.io.*;
import java.net.*;

public class Serverbit {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String receivedData = reader.readLine();
        String unstuffedData = decode(receivedData, "01111110", "010");
        System.out.println("Received stuffed data: " + receivedData);
        System.out.println("Unstuffed data: " + unstuffedData);
        socket.close();
        serverSocket.close();
    }

    public static String decode(String input, String flag, String escape) {
        StringBuilder decodedData = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentBit = input.charAt(i);
            count = (currentBit == '1') ? count + 1 : 0;
            if (count < 5) {
                decodedData.append(currentBit);
            } else if (count == 5 && i < input.length() - 1 && input.charAt(i + 1) == '0') {
                count = 0;
                decodedData.append(currentBit);
                i++;
            }
        }
        return decodedData.toString();
    }
}

