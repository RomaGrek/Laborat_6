package commands;

import Client.ClientCommandPusk;
import general.GeneralCollection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс, реализующий команду execute_script file_name, которая считывает и исполняет скрипт из указанного файла
 */
public class ExecuteScript extends Command {
    private Map<String, Command> commands = new HashMap<>();
    private ArrayList<String> runScripts = new ArrayList<>();

    public ExecuteScript(ArrayList<String> runScripts) {
        this();
        this.runScripts = runScripts;
    }

    public ExecuteScript() {
//        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("show", new Show());
        commands.put("insert", new Insert());
        commands.put("update", new Update());
        commands.put("remove_key", new RemoveKey());
        commands.put("clear", new Clear());
        commands.put("exit", new Exit());
        commands.put("remove_lower", new RemoveLower());
        commands.put("remove_lower_key", new RemoveLowerKey());
        commands.put("sum_of_impact_speed", new SumOfImpactSpeed());
        commands.put("count_by_weapon_type", new CountByWeaponType());
        commands.put("remove_any_by_mood", new RemoveAnyByMood());
        commands.put("history", new History());
    }
    /**
     * Метод реализующий проверку на вызов сразу двух execute_script, если команда отстутсвует-создается
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    public void doing(GeneralCollection generalCollection) {
        String fileName = getValue();
        try (BufferedReader bufferedReader = new BufferedReader((new FileReader(fileName)))) {
            runScripts.add("execute_script " + fileName);
            String inpurs = bufferedReader.readLine();
            while (inpurs != null) {
                if (inpurs.contains("execute_script")){
                    if(runScripts.contains(inpurs)) {
                        updateMessage(inpurs.split(" ")[1] + " уже запущена. Команда пропущена.\n");
                    }else {

                        Command command = new ExecuteScript(runScripts);
                        System.out.println(inpurs.split(" ")[1]);
                        command.setValue(inpurs.split(" ")[1]);
                        command.doing(generalCollection);
                        updateMessage(command.getMessage());
                    }
                }else {
                    doingInFile(inpurs, generalCollection);
                }
                inpurs = bufferedReader.readLine();
            }
        }catch (IOException ex){
            updateMessage("Файл "+ fileName + " not found or access denied.\n");
        }catch (Exception e) {
            updateMessage("Invalid input in execute_script "+ fileName + "\n");
            e.printStackTrace();
        }
        this.runScripts.remove("execute_script " + fileName);
    }
    /**
     * переданная строка разбивеются на две строки(по пробелу), если вторая строка пустая, управление передаётся команде execute_script, в обратном случае, в качестве аргумента подаётся вторая строка
     * @param input
     * @param generalCollection
     */
    private void doingInFile(String input, GeneralCollection generalCollection) {
        if (input.isEmpty()){
            return;
        }
        String[] values = input.split(" ");
        if (values.length == 1){
            String message;
            Command command = commands.get(values[0]);
            if (command != null){
//                ClientCommandPusk.historyCom(values[0]);
                command.setValue((String)null);
                command.doing(generalCollection);
                message = command.getMessage();
            } else {
                message = "Команды не существует, команда пропущена\n";
            }
            updateMessage(message);
        }
        if (values.length == 2){
            String message;
            Command command = commands.get(values[0]);
            if (command != null) {
//                ClientCommandPusk.historyCom(values[0]);
                command.setValue(values[1]);
                if (command.isValidCommand()) {
                    command.doing(generalCollection);
                }
                message = command.getMessage();
            }else{
                message ="Команда не существует, команда пропущена\n";
            }
            updateMessage(message);
        }
    }


    public boolean isValidCommand() {
        return true;
    }
}
