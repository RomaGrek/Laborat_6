package general;

import java.io.Serializable;

/**
 * класс Car
 */
public class Car implements Serializable {
    /** Поле для названия машины, не может быть null*/
    private String name; //Поле не может быть null
    public String getName() {
        return name;
    }
    /**
     * Сеттер для поля name
     * @param name имя машины
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Переопределение метода toString
     * @return Строковое представление класса
     */
    @Override
    public String toString() {
        return getName();
    }
}
