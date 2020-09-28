package Client;

import commands.Command;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 * Класс Client для считывания команд, передачи их для выполнения на сервер и вывода результата выполнения
 */
public class Client {
    public static void main(String[] args) throws Exception {
        ClientCommandPusk clientCommandPusk = new ClientCommandPusk();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int port = 8000;
        try {
            System.out.println("Enter port");
            line = bufferedReader.readLine();
            port = Integer.parseInt(line);
        }catch (NumberFormatException e){
            System.out.println("Invalid port. Port now set to 8000");
        }
        InetAddress inetAddress;
        try {
            System.out.println("Enter hostname");
            line = bufferedReader.readLine();
            inetAddress =  InetAddress.getByName(line);
        }catch(UnknownHostException e){
            System.out.println("IP for this host not found. Client is now working on localhost");
            inetAddress = InetAddress.getLocalHost();
        }
        while (true) {
            System.out.println("Please, enter your command, to get full list of commands, use \"help\" command.");
            line = bufferedReader.readLine();
            try {
                Socket clientSocket = new Socket(inetAddress, port);
            if (!line.isEmpty()) {
                clientCommandPusk.setCommand(line);
                if (clientCommandPusk.getCommand() != null && clientCommandPusk.isValidCommand()) {
                    Command command = clientCommandPusk.getCommand();
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                        out.writeObject(command);
                        out.flush();
                        Command command1 = (Command) in.readObject();
                        System.out.println("");
                        System.out.println(command1.getMessage());
                        in.close();
                        if (command1.getMessage().contains("Завершение.")) {
                            System.exit(0);
                        }
                    } catch (IOException e) {
                        System.err.println(e);
                    }
                }
            }
            }catch (SocketException e) {
                e.printStackTrace();
            }
    }
}}
