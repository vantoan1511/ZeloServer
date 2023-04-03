package main;

import java.io.*;
import java.net.*;
import java.util.List;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private List<ClientHandler> clients;
    private BufferedReader input;
    private PrintWriter output;

    public ClientHandler(Socket clientSocket, List<ClientHandler> clients) {
        this.clientSocket = clientSocket;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            output = new PrintWriter(clientSocket.getOutputStream(), true);

            while (true) {
                String message = input.readLine();
                if (message == null) {
                    break;
                }
                System.out.println("From " + clientSocket.getInetAddress().getHostAddress() + ": " + message);
                ZeloServer.broadcastMessage(message, this);
            }
        } catch (IOException e) {
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {

            }
            ZeloServer.removeClientHandler(this);
        }

    }

    public synchronized void sendMessage(String message){
        output.println(clients.indexOf(this)+": "+message);
    }
}
