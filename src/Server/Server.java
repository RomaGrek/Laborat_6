package Server;

import commands.*;
import general.GeneralCollection;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
/** Класс Server реализующий получение, проверку и отправление обратно клиенту пакетиков
 */

public class Server {
    public static void main(String[] args) throws Exception {
        GeneralCollection generalCollection = new GeneralCollection();
        try {
            System.out.println("Введите порт:");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line = bufferedReader.readLine();
            int port = Integer.parseInt(line);
            System.out.println("Сервер запущен");
            while (true) {
                SocketAddress address = new InetSocketAddress(port);
                try (ServerSocketChannel channel = ServerSocketChannel.open()) {
                    channel.bind(address);
                    try (SocketChannel socket = channel.accept();
                        ObjectInputStream fromClient = new ObjectInputStream(socket.socket().getInputStream());
                        ObjectOutputStream toClient = new ObjectOutputStream(socket.socket().getOutputStream())){
                        Command command = (Command) fromClient.readObject();
                        command.doing(generalCollection);
                        toClient.writeObject(command);
                        toClient.flush();
                        generalCollection.save();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid port");
        }
    }
}
////        try {
//        System.out.println("Enter port:");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String line = bufferedReader.readLine();
//        int port = Integer.parseInt(line);
//        GeneralCollection generalCollection = new GeneralCollection();
//        System.out.println("Server is started!");
//        while (true) {
//
//            SocketAddress address = new InetSocketAddress(port);
//            try (ServerSocketChannel channel = ServerSocketChannel.open()) {
//                channel.bind(address);
//                try (SocketChannel socket = channel.accept();
//                     ObjectOutputStream toClient = new ObjectOutputStream(socket.socket().getOutputStream());
//                     ObjectInputStream fromClient = new ObjectInputStream(socket.socket().getInputStream())) {
//                    while (socket.isConnected()) {
//                        Command command = (Command) fromClient.readObject();
//                        command.doing(generalCollection);
//                        toClient.writeObject(command);
//                        toClient.flush();
//                        socket.close();
//                    }
//                }
//            } catch (ClassNotFoundException | IOException ignored) {
//            }
//        }
//    }

