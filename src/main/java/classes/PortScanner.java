package classes;

import interfaces.Task;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class PortScanner implements Task {
    private static final int PORT_MAX_VALUE = 65535;

    private String ip;
    private int startPort;
    private int endPort;
    private boolean isRunning;
    private Thread thread;

    public PortScanner(String ip, int startPort, int endPort) {
        if (startPort > endPort) {
            var temp = startPort;
            startPort = endPort;
            endPort = temp;
        }
        if (startPort < 1 || startPort > PORT_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Invalid port value for %s", startPort));
        }
        if (endPort < 1 || endPort > PORT_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Invalid port value for %s", endPort));
        }

        this.ip = ip;
        this.startPort = startPort;
        this.endPort = endPort;
        this.isRunning = false;
    }

    @Override
    public void start() {
        isRunning = true;
        thread = new Thread(() -> {
            List<Integer> openPorts = new ArrayList<>();

            for (int port = startPort; port <= endPort && isRunning; port++) {
                if (isPortOpen(ip, port)) {
                    openPorts.add(port);
                    System.out.printf("Port %s is open%n", port);
                }
            }
        });

        thread.start();
    }

    @Override
    public void stop() {
        isRunning = false;
        if (thread != null && thread.isAlive()) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("PortScanning is stopped.");
    }

    private boolean isPortOpen(String host, int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new java.net.InetSocketAddress(host, port), 100);
            return true;
        } catch (UnknownHostException e) {
            System.err.printf("Unknown host: %s%n", host);
            stop();
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}