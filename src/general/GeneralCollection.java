package general;

import Client.ClientCommandPusk;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Класс для дерева с объектами HumanBeing и его управлением
 */
public class GeneralCollection implements Serializable {
    LocalDateTime localDateTime;
    /**Поле genCollection, ключи - Integer, значения - HumanBeing*/
    private TreeMap<Integer, HumanBeing> genCollection = new TreeMap<>();

    /**
     * Чтение данных из файла HumanBeing.json генерация id происходит автоматически в диапазоне от 0 до 10000
     * @throws IOException ошибка пользовательского ввода
     */
    public GeneralCollection() throws IOException {
        this.localDateTime = LocalDateTime.now();
        Gson gson = new Gson();
        try (Reader reader = new FileReader("HumanBeing.json")) {
            Type foundMap = new TypeToken<TreeMap<Integer, HumanBeing>>(){}.getType();
            this.genCollection = gson.fromJson(reader, foundMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    /**
     * Удаляет все элементы из коллекции
     */
    public void clear() {
        if (genCollection.size() == 0) {
            System.out.println("Коллекция уже пуста");
        } else {
            genCollection.clear();
        }
    }


    /**
     * Переопределение метода toString
     * @return Строковое представление класса
     */
    @Override
    public String toString() {
        return "Тип: HumanBeing\n"
                + "Дата инициализации: " + localDateTime + '\n'
                + "Количество элементов: " + genCollection.size() + '\n';
    }

    /**
     * Удаляет элемент коллекции, ключ которого равен введенному
     * @param key ключ
     */
    public void removeKey(Integer key) {
        this.genCollection.remove(key);
    }

    public void setHumanBeingTreeMap(TreeMap<Integer, HumanBeing> genCollection) {
        this.genCollection = genCollection;
    }

    /**
     * Геттер genCollection
     * @return возвращает коллекцию
     */
    public TreeMap<Integer, HumanBeing> getGenCollection() {
        return genCollection;
    }
    public void addHumanBeing(Integer key, HumanBeing humanBeing1) { // метода для создания нового обьекта и помещение его в коллекцию
        getGenCollection().remove(key);
        getGenCollection().put(key, humanBeing1);
    }


    public Integer getKeyById(Integer id){
        for (int key : genCollection.keySet()){
            if (Objects.equals(genCollection.get(key).getId(), id)){
                return key;
            }
        }
        return null;
    }

    /**
     * Сохраняет коллекцию в файл afterHumanBeing.json
     */
    public void save() {
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("afterHumanBeing.json"))) {
            Gson gson = new Gson();
            String json = gson.toJson(genCollection);
            stream.write(json.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


