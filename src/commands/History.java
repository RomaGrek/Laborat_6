package commands;

import Client.ClientCommandPusk;
import general.GeneralCollection;

import java.util.ArrayList;

/**
 * Класс, реализующий программу history, которая выводит последние 13 команд, введенных пользователем (без аргументов)
 */
public class History extends Command {
    String s = "";
    /**
     * Метод возвращает 12 последних введенных команд
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        setMessage("");
        setMessage("Список последних веденных команд:" + '\n' + s);
        s = " ";
    }

    /** Метод, который делает строку из команд введенных пользователем
     * @return
     */
    @Override
    public boolean isValidCommand() {
        if (s.equals("")) {
            for (int i = 0; i < ClientCommandPusk.historyCommands.size(); i++) {
                s = s + ClientCommandPusk.historyCommands.get(i) + '\n';
            }
        }else {
            s = "";
            for (int i = 0; i < ClientCommandPusk.historyCommands.size(); i++) {
                s = s + ClientCommandPusk.historyCommands.get(i) + '\n';
            }
        }
        return true;
    }
}
