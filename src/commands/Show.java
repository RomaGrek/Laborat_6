package commands;

import general.GeneralCollection;

/**
 * Класс, реализующий программу show, которая выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class Show extends Command {

    /**
     * Обращение возвращает все элементы коллекции
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        if (!generalCollection.getGenCollection().isEmpty()) {
            setMessage("");
            for (Integer key : generalCollection.getGenCollection().keySet()) {
                updateMessage("Key: " + key + " Value: " + generalCollection.getGenCollection().get(key).toString() + '\n');
            }
        } else {
            setMessage("Коллекция пустая!");
        }
    }

    @Override
    public boolean isValidCommand() {
        return true;
    }

}
