package commands;//package commands;

import Client.ClientCommandPusk;
import general.GeneralCollection;
import general.HumanBeing;

import java.util.TreeMap;

/**
 * Класс, реализующий программу remove_lower_key key, которая удаляет из коллекции все элементы, ключ которых меньше, чем заданный пользователем
 */
public class RemoveLowerKey extends Command {
    private Integer key;
    /**
     * Метод удаление элементов, ключ которых меньше чем заданный
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        TreeMap<Integer, HumanBeing> newSortMap = new TreeMap<>();
        generalCollection.getGenCollection().keySet().stream().filter(entry -> entry >= key).forEach(entry -> newSortMap.put(entry, generalCollection.getGenCollection().get(key)));
        generalCollection.setHumanBeingTreeMap(newSortMap);
        setMessage("Элементы, ключ которых меньше чем " + key + " удалены.");
    }
    /** Метод, который проверяет, что ключ целое число
     * @return
     */
    @Override
    public boolean isValidCommand() {
        try {
            key = Integer.parseInt(getValue());
            return true;
        }catch (NumberFormatException e) {
            System.out.println("Ключ должен быть типа: Integer!");
            return false;
        }
    }
}
