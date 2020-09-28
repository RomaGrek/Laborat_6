package general;

import java.io.Serializable;

/**
 * Класс Coordinates
 */

public class Coordinates implements Serializable {
    /**Поле для координаты x*/
    private Integer x;
    /**Поле для координаты y*/
    private Long y;
    /**
     * Конструктор с координатами x и y
     * @param x X
     * @param y Y
     */
    public Coordinates(Integer x, Long y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Геттер x
     * @return поле x
     */
    public Integer getX() {
        return x;
    }
    /**
     * Геттер  y
     * @return поле y
     */
    public Long getY() {
        return y;
    }
    /**
     * Сеттер для x
     * @param x x
     */
    public void setX(Integer x) {
        this.x = x;
    }
    /**
     * Сеттер для y
     * @param y y
     */
    public void setY(Long y) {
        this.y = y;
    }
    /**
     * Переопределение метода toString
     * @return Строковое представление класса
     */
    @Override
    public String toString() {
        return "x = " + getX() + "; y = " + getY();
    }
}
