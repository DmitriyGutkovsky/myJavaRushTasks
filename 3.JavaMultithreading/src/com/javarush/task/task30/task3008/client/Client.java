package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

    }

    //должен запросить ввод адреса сервера у пользователя и вернуть введенное значение.
    //Адрес может быть строкой, содержащей ip, если клиент и сервер запущен на разных машинах
    // или 'localhost', если клиент и сервер работают на одной машине.
    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера");
        return ConsoleHelper.readString();
    }

    //запрашивать ввод порта сервера и возвращать его
    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера");
        int port = ConsoleHelper.readInt();
        return port;
    }

    //должен запрашивать и возвращать имя пользователя.
    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя");
        String userName = ConsoleHelper.readString();
        return userName;
    }

    //в данной реализации клиента всегда должен возвращать true
    // (мы всегда отправляем текст введенный в консоль).
    //Этот метод может быть переопределен, если мы будем писать какой-нибудь другой клиент,
    // унаследованный от нашего, который не должен отправлять введенный в консоль текст.
    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    //должен создавать и возвращать новый объект класса SocketThread
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    //создает новое текстовое сообщение, используя переданный текст
    // и отправляет его серверу через соединение connection
    //Если во время отправки произошло исключение IOException,
    // то необходимо вывести информацию об этом пользователю и присвоить false полю clientConnected
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Не удалось отправить сообщение");
            clientConnected = false;
        }

    }
}
