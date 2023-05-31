import java.io.*;
import java.net.*;
import java.util.HashMap;

public class DNSServer {
    private HashMap<String, String> ipAddresses;

    public DNSServer() {
        ipAddresses = new HashMap<String, String>();
        ipAddresses.put("example.com", "192.168.1.1");
        ipAddresses.put("google.com", "216.58.194.174");
    }

    public String resolveDomain(String domainName) {
        String ipAddress = ipAddresses.get(domainName);
        if (ipAddress == null) {
            return "Domain not found";
        }
        return ipAddress;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }

        DNSServer dnsServer = new DNSServer();

        Socket clientSocket = null;
        try {
            System.out.println("Waiting for client...");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getInetAddress());
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            outputLine = dnsServer.resolveDomain(inputLine);
            out.println(outputLine);
            System.out.println("Request for domain " + inputLine + " handled, IP address is " + outputLine);
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

