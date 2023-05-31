import java.io.*;
import java.net.*;

public class TestDNS {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java TestDNS <hostname>");
            System.exit(1);
        }

        String hostname = args[0];
        int portNumber = 4444;

        Socket dnsSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            dnsSocket = new Socket(hostname, portNumber);
            out = new PrintWriter(dnsSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(dnsSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + hostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + hostname);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        System.out.println("Enter a domain name (e.g. example.com):");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            String ipAddress = in.readLine();
            System.out.println("IP address is: " + ipAddress);
            System.out.println("Enter a domain name (e.g. example.com):");
        }

        out.close();
        in.close();
        stdIn.close();
        dnsSocket.close();
    }
}
