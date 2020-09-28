package commands;

import general.GeneralCollection;
import general.HumanBeing;
import general.HumanBeingReader;

/**
 * Класс, реализующий программу insert key, которая добавляет новый элемент с заданным ключом
 */
public class Insert extends Command {
    private Integer key;
    private HumanBeing humanBeing;
    /**
     * Метод реалезует проверку на наличие обьекта с таким ключем в коллекции, и если такого ключа нету, то добавляет новый обьект в коллекцию
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        if(generalCollection.getGenCollection().get(key) == null){
            generalCollection.addHumanBeing(key, humanBeing);
            setMessage("Объект " + humanBeing.toString() + " добавлен в коллекцию\n");
        }else {
            setMessage("Элемент с таким ключем уже есть есть в коллекции. Для начала нужно его удалить с помощью команды \"remove_key\"\n");
        }
    }
    /** Метод, который проверяет, что id целое число
     * @return
     */
    @Override
    public boolean isValidCommand(){
        try {
            key = Integer.parseInt(getValue());
            HumanBeingReader humanBeingReader = new HumanBeingReader();
            humanBeing = humanBeingReader.getHumanBeing();
            return true;
        }catch (NumberFormatException e) {
            System.out.println("Ключ должен быть типа: Integer");
            return false;
        }
    }
}
