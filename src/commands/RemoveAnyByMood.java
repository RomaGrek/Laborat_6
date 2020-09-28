package commands;

import general.GeneralCollection;
import general.HumanBeing;
import general.Mood;

import java.util.TreeMap;

/**
 * Класс, реализующий программу remove_any_by_mood mood, которая удаляет из коллекции элемент(ы), значение поля mood которого эквивалентно заданному
 */
public class RemoveAnyByMood extends Command {
    private Mood mood;
    /**
     * Метод реализоывает проверку коллекции на пустоту и удаление элементов карты,у которых поле mood равно заданному (null тоже)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        if (generalCollection.getGenCollection().isEmpty()) {
            updateMessage("Коллекция пуста!");
        }else if (mood != null){
            TreeMap<Integer, HumanBeing> newSortMap = new TreeMap<>();
            generalCollection.getGenCollection().entrySet().stream()
                    .filter(entry -> !entry.getValue().getMood().equals(mood))
                    .forEach(entry -> newSortMap.put(entry.getKey(), entry.getValue()));
            generalCollection.setHumanBeingTreeMap(newSortMap);
            setMessage("Элементы с настроением " + mood + " удалены из коллекции");
        }else {
            TreeMap<Integer, HumanBeing> newSortMap = new TreeMap<>();
            generalCollection.getGenCollection().entrySet().stream()
                    .filter(entry -> entry.getValue().getMood() != null)
                    .forEach(entry -> newSortMap.put(entry.getKey(), entry.getValue()));
            generalCollection.setHumanBeingTreeMap(newSortMap);
            setMessage("Элементы с настроением " + mood + " удалены из коллекции");
        }
    }
    /** Метод, который проверяет валидность введенного поля mood
     * @return
     */
    @Override
    public boolean isValidCommand() {
        String name = getValue();
        boolean ti = false;
        metka:
        if(name.equals("sorrow")) {
            mood = Mood.SORROW;
            ti = true;
            break metka;
        } else if(name.equals("rage")){
            mood = Mood.RAGE;
            ti = true;
            break metka;
        } else if(name.equals("frenzy")){
            mood = Mood.FRENZY;
            ti = true;
            break metka;
        } else if(name.equals("null")) {
            mood = null;
            ti = true;
            break metka;
        }else {
            System.out.println("Вы ввели некорректный тип поля mood, введите тип поля mood из списка:\n" + "rage\n" + "frenzy\n" + "sorrow\n");
        }
        return ti;
    }
}

//    @Override
//    public boolean isValidCommand() {
//        String name = getValue();
//        boolean ti = false;
//        metka:
//        if (name.equals("sorrow")) {
//            for (Integer key : getGenCollection().keySet()) {
//                if (getGenCollection().get(key).getMood().equals(Mood.SORROW)) {
//                    mood = Mood.SORROW;
//                    ti = true;
//                    break metka;
//                }
//            }
//        } else if (getValue().equals("rage") && (getGenCollection().size() == sizeDoRem)) {
//            for (Integer key : getGenCollection().keySet()) {
//                if (getGenCollection().get(key).getMood().equals(Mood.RAGE)) {
//                    mood = Mood.RAGE;
//                    ti = true;
//                    break metka;
//                }
//            }
//        } else if (getValue().equals("frenzy") && (getGenCollection().size() == sizeDoRem)) {
//            for (Integer key : getGenCollection().keySet()) {
//                if (getGenCollection().get(key).getMood().equals(Mood.FRENZY)) {
//                    mood = Mood.FRENZY;
//                    ti = true;
//                    break metka;
//                }
//            }
//        } else if (getValue().equals("null") && (getGenCollection().size() == sizeDoRem)) {
//            for (Integer key : getGenCollection().keySet()) {
//                if (getGenCollection().get(key).getMood() == null) {
//                    mood = null;
//                    ti = true;
//                    break metka;
//                }
//            }
//        }
//        else {
//            System.out.println("Вы ввели некорректный тип поля mood, введите тип поля mood из списка:\n" + "rage\n" + "frenzy\n" + "sorrow\n");
//
//        }
//        return ti;
//    }
//
//    private Map<Integer, HumanBeing> getGenCollection() {
//        return generalCollection1.getGenCollection();
//    }
//
//}
