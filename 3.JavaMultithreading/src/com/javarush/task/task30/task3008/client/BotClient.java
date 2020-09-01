package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client {

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        /*
        Отправить ответ в зависимости от текста принятого сообщения.
        Если текст сообщения:
        "дата" - отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
        "день" - в формате "d";
        "месяц" - "MMMM";
        "год" - "YYYY";
        "время" - "H:mm:ss";
        "час" - "H";
        "минуты" - "m";
        "секунды" - "s".
         */
        @Override
        protected void processIncomingMessage(String message) {
            GregorianCalendar calendar = new GregorianCalendar();
            Date date = new Date();
            ConsoleHelper.writeMessage(message);
            if (message == null || !message.contains(": ")) return;
            String[] splitMessage = message.split(": ");
            String senderName = splitMessage[0];
            String sentMessage = splitMessage[1];


            if (sentMessage.equals("дата")) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                sendTextMessage("Информация для " + splitMessage[0] + ": " +
                        simpleDateFormat.format(calendar.getTime()));
            } else if (sentMessage.equals("день")) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
                sendTextMessage("Информация для " + splitMessage[0] + ": " +
                        simpleDateFormat.format(calendar.getTime()));
            } else if (sentMessage.equals("месяц")){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
                sendTextMessage("Информация для " + splitMessage[0] + ": " +
                        simpleDateFormat.format(calendar.getTime()));
            } else if (sentMessage.equals("год")){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
                sendTextMessage("Информация для " + splitMessage[0] + ": " +
                        simpleDateFormat.format(calendar.getTime()));
            } else if (sentMessage.equals("время")){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                sendTextMessage("Информация для " + splitMessage[0] + ": " +
                        simpleDateFormat.format(calendar.getTime()));
            } else if (sentMessage.equals("час")){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H");
                sendTextMessage("Информация для " + splitMessage[0] + ": " +
                        simpleDateFormat.format(calendar.getTime()));
            } else if (sentMessage.equals("минуты")){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("m");
                sendTextMessage("Информация для " + splitMessage[0] + ": " +
                        simpleDateFormat.format(calendar.getTime()));
            } else if (sentMessage.equals("секунды")){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("s");
                sendTextMessage("Информация для " + splitMessage[0] + ": " +
                        simpleDateFormat.format(calendar.getTime()));
            }


        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
