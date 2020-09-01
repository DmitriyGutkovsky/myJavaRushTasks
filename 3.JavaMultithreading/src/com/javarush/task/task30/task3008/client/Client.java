package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.*;

import java.io.IOException;
import java.net.Socket;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

        //должен выводить текст message в консоль
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        //должен выводить в консоль информацию о том,
        // что участник с именем userName присоединился к чату
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединился к чату");
        }

        //должен выводить в консоль, что участник с именем userName покинул чат.
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " покинул чат");
        }

        //этот метод должен:
        //а) Устанавливать значение поля clientConnected
        // внешнего объекта Client в соответствии с переданным параметром.
        //б) Оповещать (пробуждать ожидающий) основной поток класса Client.
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        // а) В цикле получать сообщения, используя соединение connection.
        //б) Если тип полученного сообщения NAME_REQUEST (сервер запросил имя),
        // запросить ввод имени пользователя с помощью метода getUserName(),
        // создать новое сообщение с типом MessageType.USER_NAME и введенным именем,
        // отправить сообщение серверу.
        //в) Если тип полученного сообщения MessageType.NAME_ACCEPTED (сервер принял имя),
        // значит сервер принял имя клиента, нужно об этом сообщить главному потоку, он этого очень ждет.
        //Сделай это с помощью метода notifyConnectionStatusChanged(), передав в него true.
        //После этого выйди из метода.
        //г) Если пришло сообщение с каким-либо другим типом,
        // кинь исключение IOException("Unexpected MessageType").
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message receiveMessage = connection.receive();

                if (receiveMessage.getType() == MessageType.NAME_REQUEST) {
                    String userName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                } else if (receiveMessage.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        /*Этот метод будет реализовывать главный цикл обработки сообщений сервера. Внутри метода:
        а) Получи сообщение от сервера, используя соединение connection.
        б) Если это текстовое сообщение (тип MessageType.TEXT),
        обработай его с помощью метода processIncomingMessage().
        в) Если это сообщение с типом MessageType.USER_ADDED,
        обработай его с помощью метода informAboutAddingNewUser().
        г) Если это сообщение с типом MessageType.USER_REMOVED,
        обработай его с помощью метода informAboutDeletingNewUser().
        д) Если клиент получил сообщение какого-либо другого типа,
        брось исключение IOException("Unexpected MessageType").
         */
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            for (; ; ) {
                Message receiveMessage = connection.receive();
                if (receiveMessage.getType() == MessageType.TEXT) {
                    processIncomingMessage(receiveMessage.getData());
                } else if (receiveMessage.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(receiveMessage.getData());
                } else if (receiveMessage.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(receiveMessage.getData());
                } else throw new IOException("Unexpected MessageType");
            }
        }

        /*
        1) Запроси адрес и порт сервера с помощью методов getServerAddress() и getServerPort().
        2) Создай новый объект класса java.net.Socket, используя данные, полученные в предыдущем пункте.
        3) Создай объект класса Connection, используя сокет из п.17.2.
        4) Вызови метод, реализующий "рукопожатие" клиента с сервером (clientHandshake()).
        5) Вызови метод, реализующий основной цикл обработки сообщений сервера.
        6) При возникновении исключений IOException или ClassNotFoundException
        сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged() и
        false в качестве параметра.
         */
        @Override
        public void run() {
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();
            try {
                Socket socket = new Socket(serverAddress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
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
        return ConsoleHelper.readInt();
    }

    //должен запрашивать и возвращать имя пользователя.
    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя");
        return ConsoleHelper.readString();
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

    //Он должен создавать вспомогательный поток SocketThread,
    // ожидать пока тот установит соединение с сервером,
    // а после этого в цикле считывать сообщения с консоли и отправлять их серверу.
    //Условием выхода из цикла будет отключение клиента или ввод пользователем команды 'exit'.
    //Для информирования главного потока, что соединение установлено во вспомогательном потоке,
    // используй методы wait() и notify() объекта класса Client.
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Возникла ошибка");
                clientConnected = false;
                return;
            }
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено.\n" +
                    "Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        while (clientConnected) {
            String text = ConsoleHelper.readString();
            if (text.equals("exit")) {
                break;
            } else {
                if (shouldSendTextFromConsole()) {
                    sendTextMessage(text);
                }
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
