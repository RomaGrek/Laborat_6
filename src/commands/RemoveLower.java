package commands;

import general.GeneralCollection;
import general.HumanBeing;

import java.util.TreeMap;

/**
 * Класс, реализующий программу remove_lower id, которая удаляет из коллекции все элементы, значение id которого меньше чем заданный пользователем
 */
public class RemoveLower extends Command {
    private Integer id;
    /**
     * Метод реализоывает удаление элементов коллекции, id которых меньше чем заданный
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        TreeMap<Integer, HumanBeing> newSortMap = new TreeMap<>();
        generalCollection.getGenCollection().entrySet().stream().filter(entry -> entry.getValue().getId() >= id)
                .forEach(entry -> newSortMap.put(entry.getKey(), entry.getValue()));
        generalCollection.setHumanBeingTreeMap(newSortMap);
        setMessage("Элементы, id которых меньше чем " + id + " удалены.");
    }
    /** Метод, который проверяет, что ключ целое число
     * @return
     */
    @Override
    public boolean isValidCommand() {
        try {
            id = Integer.parseInt(getValue());
            return true;
        }catch (NumberFormatException e) {
            System.out.println("Ключ должен быть типа: Integer!");
            return false;
        }
    }
}
