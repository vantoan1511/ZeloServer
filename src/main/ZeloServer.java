package main;

import gui.UI;
import java.io.*;
import java.net.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZeloServer extends Thread {

    private static final int PORT = 8080;
    private static final List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());
    private static final List<Thread> clientThreads = Collections.synchronizedList(new ArrayList<>());
    private ServerSocket serverSocket;
    public boolean isRunning;
    UI ui;

    public ZeloServer(UI ui) {
        this.ui = ui;
        isRunning = false;
    }

    public void startServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
        isRunning = true;
        this.start();
    }

    @Override
    public void run() {
        try {
            ui.writeLog("Chat server started on port " + PORT + "\n");
            System.out.println("Chat server started on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client connected: " + clientSocket.getInetAddress().getHostAddress());
                ui.writeLog("A client connected: " + clientSocket.getInetAddress().getHostAddress() + "\n");
                ClientHandler clientHandler = new ClientHandler(clientSocket, clients);
                synchronized (clients) {
                    clients.add(clientHandler);
                }
                Thread clientThread = new Thread(clientHandler);
                synchronized (clientThreads) {
                    clientThreads.add(clientThread);
                }
                clientThread.start();
            }
        } catch (IOException ex) {
        }
    }

    public static synchronized void broadcastMessage(String message, ClientHandler sender) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(message);
                }
            }
        }
    }
    
    public static synchronized void removeClientHandler(ClientHandler client) {
        synchronized (client) {
            clients.remove(client);
        }
    }
}
