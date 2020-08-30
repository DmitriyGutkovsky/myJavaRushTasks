package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Сервер запущен");
            for (; ; ) {
                new Handler(serverSocket.accept()).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
