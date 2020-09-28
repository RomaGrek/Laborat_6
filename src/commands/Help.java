package commands;

import general.GeneralCollection;

/**
 * Класс, реализующий программу help, которая выводит справку по доступным командам
 */
public class Help extends Command {
    /**
     * Метод возвращает списко команд
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        setMessage("help : вывести справку по доступным командам \n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.) \n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n" +
                "insert Integer {element} : добавить новый элемент с заданным ключём \n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному \n" +
                "remove_key Integer : удалить элемент из коллекции по его ключу \n" +
                "clear : очистить коллекцию \n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. \n" +
                "remove_lower id {element} : удалить из коллекции все элементы, меньшие, чем заданный \n" +
                "remove_lower_key Integer : удалить из коллекции все элементы, ключ которых меньше, чем заданный \n" +
                "history : вывести последние 13 команд (без их аргументов) \n" +
                "remove_any_by_mood mood : удалить из коллекции элемент(ы), значение поля mood которого эквивалентно заданному \n" +
                "sum_of_impact_speed : вывести сумму значений поля impactSpeed для всех элементов коллекции \n" +
                "count_by_weapon_type weaponType : вывести количество элементов, значение поля weaponType которых равно заданному \n" +
                "exit : завершить программу (без сохранения в файл) \n");
    }
    @Override
    public String toString() {
        return "command help";
    }

    @Override
    public boolean isValidCommand() {
        return true;
    }
}
