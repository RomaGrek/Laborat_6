package general;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * Класс HumanBeing
 */

public class HumanBeing implements Serializable {
    /** Поле id, не может быть null, значение больше 0, генерируется автоматически*/
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически (гс)
    /**Поле name, не может быть null, не пустое*/
    private String name; //Поле не может быть null, Строка не может быть пустой (гс)
    /**Поле Coordinates, не может быть null*/
    private Coordinates coordinates; //Поле не может быть null (гс)
    /**Поле creationDate, не может быть null, генерируется автоматически*/
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически (гс)
    /**Поле realHero*/
    private Boolean realHero;
    /**Поле hasToothpick, не может быть null*/
    private boolean hasToothpick;  //Поле не может быть null
    /**Поле impactSpeed, не может быть null, значение больше чем -354*/
    private int impactSpeed; //Значение поля должно быть больше -354
    /**Поле weaponType, может быть null*/
    private WeaponType weaponType; //Поле может быть null (гс)
    /**Поле mood, может быть null*/
    private Mood mood; //Поле может быть null (гс)
    /**Поле car, не может быть null*/
    private Car car; //Поле не может быть null (гс)
    /**
     * Конструктор HumanBeing
     * @param name имя
     * @param coordinates координаты
     * @param realHero героичность
     * @param hasToothpick наличие зубной палочки
     * @param impactSpeed скорость
     * @param weaponType тип оружия
     * @param mood настроение
     * @param car машина
     */
    public HumanBeing(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, int impactSpeed, WeaponType weaponType, Mood mood, Car car) {
        this.id = randomId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }
    /**
     * Геттер id
     * @return id
     */
    public Integer getId() {
        return id;
    }
    /**
     * Геттер name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Геттер x
     * @return x
     */
    public Integer getX() {
        return coordinates.getX();
    }
    /**
     * Геттер y
     * @return y
     */
    public Long getY() {
        return coordinates.getY();
    }

    /**
     * Генерирует значения id (0-10000)
     * @return сгенерировнный id
     */
    public Integer randomId() {
        Random random = new Random();
        Integer num = random.nextInt(10000);
        return num;
    }
    /**
     * Геттер creationDate
     * @return creationDate
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    /**
     * Cеттер id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Сеттер name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Сеттер для x
     * @param x x
     */
    public void setX(Integer x) {
        coordinates.setX(x);
    }
    /**
     * Сеттер для y
     * @param y x
     */
    public void setY(Long y) {
        coordinates.setY(y);
    }
    /**
     * Сеттер creationDate
     * @param creationDate creationDate
     */
    public void setDate(LocalDateTime creationDate) {
        this.creationDate= creationDate;
    }
    /**
     * Геттер weaponType
     * @return weaponType
     */
    public WeaponType getWeaponType() {
        return weaponType;
    }
    /**
     * Геттер mood
     * @return mood
     */
    public Mood getMood() {
        return mood;
    }
    /**
     * Сеттер weaponType
     * @param weaponType weaponType
     */
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
    /**
     * Cеттер mood
     * @param mood mood
     */
    public void setMood(Mood mood) {
        this.mood = mood;
    }
    /**
     * Геттер hasToothpick
     * @return hasToothpick
     */
    public boolean getHasToothpick() {
        return hasToothpick;
    }
    /**
     * Сеттер hasToothpick
     * @param hasToothpick hasToothpick
     */
    public void setHasToothpick(boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }
    /**
     * Геттер realHero
     * @return realHero
     */
    public Boolean getRealHero() {
        return realHero;
    }
    /** Сеттер realHero
     * @param realHero realHero
     */
    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }
    /**
     * Сеттер impactSpeed
     * @param impactSpeed impactSpeed
     */
    public void setImpactSpeed(int impactSpeed) {
        this.impactSpeed = impactSpeed;
    }
    /**
     * Геттер impactSpeed
     * @return impactSpeed
     */
    public int getImpactSpeed() {
        return impactSpeed;
    }
    /**
     * Геттер car
     * @return car
     */
    public Car getCar() {
        return car;
    }
    /**
     * Сеттер car
     * @param car car
     */
    public void setCar(Car car) {
        this.car = car;
    }
    /**
     * Переопределение метода toString
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return " HumanBeing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", realHero=" + realHero +
                ", hasToothpick=" + hasToothpick +
                ", impactSpeed=" + impactSpeed +
                ", weaponType=" + weaponType +
                ", mood=" + mood +
                ", car=" + car +
                '}';
    }
}
