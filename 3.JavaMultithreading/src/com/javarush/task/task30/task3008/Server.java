package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message receiveMessage = connection.receive();
            if (receiveMessage.getType() == MessageType.USER_NAME &&
                    !receiveMessage.getData().isEmpty() &&
                    !connectionMap.containsKey(receiveMessage.getData())) {
                connectionMap.put(receiveMessage.getData(), connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
            } else return serverHandshake(connection);
            return receiveMessage.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for(Map.Entry<String, Connection> pair : connectionMap.entrySet()){
                String name = pair.getKey();
                if (!name.equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message receiveMessage = connection.receive();
                if (receiveMessage.getType() == MessageType.TEXT) {
                    Server.sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + receiveMessage.getData()));
                } else {
                    ConsoleHelper.writeMessage("Ошибка");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                pair.getValue().send(message);
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Сообщение не было отправлено");
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
