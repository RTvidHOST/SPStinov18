package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Сервер ждет клиента...");

        try (Socket clientSocket = serverSocket.accept();
             InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {

            System.out.println("Новое соединение: " + clientSocket.getInetAddress().toString()); //Тут указан IP-адрес соединения
            int request;
            while ((request = inputStream.read()) != -1) {
                System.out.println("прислал клиент: " + request); //Какой клиент отправил данные
                outputStream.write(++request);
                System.out.println("отправлено клиенту: " + request); //Какому клиенту идёт отправка данных
                outputStream.flush();
            }
            System.out.println("клиент отключился");
        }
    }
}