package Client;

import commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс ClientCommandData для управления командами
 */
public class ClientCommandPusk {
    /** Карта команд. Ключ - строковое название команды. Значение - классы, реализующие интерфейс CommandDo*/
    private static Map<String, Command> commands = new HashMap<>();
    /** Массив для хранения истории ввода команд пользователем*/
    public static ArrayList<String> historyCommands = new ArrayList<>();
    /** Поле comand */
    private Command command;
    /**
     * Метод создания истории команд введнных пользователем
     * @param commandDo объект команды
     */
    public static void historyCom(String commandDo) {
        if(historyCommands.size() > 12) {
            historyCommands.remove(0);
        }
        historyCommands.add(commandDo);
    }
    /** Конструктор {@link ClientCommandPusk#commands}командами и их строковыми названиями*/
    public ClientCommandPusk() {
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("show", new Show());
        commands.put("insert", new Insert());
        commands.put("update", new Update());
        commands.put("remove_key", new RemoveKey());
        commands.put("clear", new Clear());
        commands.put("execute_script", new ExecuteScript());
        commands.put("exit", new Exit());
        commands.put("remove_lower", new RemoveLower());
        commands.put("remove_lower_key", new RemoveLowerKey());
        commands.put("sum_of_impact_speed", new SumOfImpactSpeed());
        commands.put("count_by_weapon_type", new CountByWeaponType());
        commands.put("remove_any_by_mood", new RemoveAnyByMood());
        commands.put("history", new History());
    }



    public Command getCommand() {
        return this.command;
    }
    /**
     * переданная строка разбивеются на две строки(по пробелу), если вторая строка пустая, управление передаётся команде с введённым названием и аргументом null, в обратном случае, в качестве аргумента подаётся вторая строка
     * @param input строчка, введённая пользователем*/

    public void setCommand(String input){
        if (input.isEmpty()){
            return;
        }
        this.command = null;
        String[] values = input.split(" ");
        if (values.length == 1){
            Command command = commands.get(values[0]);
            if (command != null){
                historyCom(values[0]);
                command.setValue(null);
                this.command = command;
            } else {
                System.out.println("Команды не существует");
            }

        }
        if (values.length == 2){
            Command command = (Command) commands.get(values[0]);
            if (command != null) {
                historyCom(values[0]);
                command.setValue(values[1]);
                this.command = command;
            } else{
                System.out.println("Команда не существует");
            }
        }
    }
    public boolean isValidCommand(){
        return this.command.isValidCommand();
    }
}
