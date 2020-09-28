package commands;

import general.GeneralCollection;

/**
 * Класс, реализующий программу remove_key key, которая удаляет элемент коллекции по его ключу
 */
public class RemoveKey extends Command {
    private Integer key;
    /**
     * Метод реализоывает проверку на наличие объекта в коллекции с таким ключем, если он есть то он удаляет этот эелемент
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        if (generalCollection.getGenCollection().get(key) == null) {
            setMessage("Элемента с таким ключем в коллекции не существует. Используйте команду \"show\" что бы просмотреть коллекцию");
        }else {
            setMessage("Элемент" + generalCollection.getGenCollection().get(key).toString() + "удалён");
            generalCollection.removeKey(key);
        }
    }
    /** Метод, который проверяет, что id целое число
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
