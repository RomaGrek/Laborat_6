package commands;

import general.GeneralCollection;
import general.HumanBeing;
import general.HumanBeingReader;

/**
 * Класс, реализующий программу update id, которая обновляет значение элемента коллекции, id которого равен заданному
 */
public class Update extends Command{
    private Integer id;
    private HumanBeing humanBeing;
    /**
     * Метод реалезует проверку на наличие обьекта с таким id в коллекции, и если такой ключ есть, то он обновляет этот элемент обьект в коллекцию
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
            Integer key = generalCollection.getKeyById(id);
            if (key == null){
                setMessage("Элемента с таким id нету, для того что бы посмотреть обьекты коллекции испольщуете \"show\" команду.");
            }else {
                generalCollection.addHumanBeing(key, humanBeing);
                setMessage("Обьект перезаписан");
            }

    }

    /** Метод, который проверяет, что ключ целое число
     * @return
     */
    @Override
    public boolean isValidCommand(){
        try {
            id = Integer.parseInt(getValue());
            HumanBeingReader humanBeingReader = new HumanBeingReader();
            humanBeing = humanBeingReader.getHumanBeing();
            return true;
        }catch (NumberFormatException e) {
            System.out.println("Ключ должен быть типа: Integer");
            return false;
        }
    }
}
