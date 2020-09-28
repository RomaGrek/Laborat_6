package general;

import java.util.Scanner;
/**Класс HumanBeingReader - конструктор для обьектов коллекции (чтения)
 */
public class HumanBeingReader {

        private HumanBeing humanBeing = new HumanBeing(scanName(), scanCoordinates(), scanRealHero(), scanHasToothpick(), scanImpactSpeed(), scanWeaponType(), scanMood(), scanCar());

    public HumanBeing getHumanBeing() {
        return this.humanBeing;
    }


    /**
     * Считывает поле name
     * @return name
     */
    public String scanName() {
        System.out.println("Введите имя:");
        Scanner in = new Scanner(System.in);
        String go = in.nextLine();
        while (go.isEmpty()) {
            System.out.println("Имя не может быть пустым! Пожалуйста, введите имя:");
            go = in.nextLine();
        }
        return go;
    }
    /**
     * Считывает строку, введенную пользователем
     * @return строка, введенная пользователем
     */
    public String scanLine() {
        Scanner im = new Scanner(System.in);
        String ups = im.nextLine();
        while (ups.isEmpty()) {
            System.out.println("Вы ввели пустую строку. Пожалуйста, повторите ввод.");
            ups = im.nextLine();
        }
        return ups;
    }

    /**
     * Считывает координаты
     * @return координаты
     */
    public Coordinates scanCoordinates() {
        Integer inputX = null;
        Long inputY = null;
        while (inputX == null) {
            System.out.println("Введите х координату: ");
            try {
                inputX = Integer.parseInt(scanLine());
            } catch (NumberFormatException e) {
                System.out.println("Координата х должна быть целым числом.");
            }
        }
        System.out.println("Введите у координату: ");
        while (inputY == null) {
            try {
                inputY = Long.parseLong(scanLine());
            } catch (NumberFormatException e) {
                System.out.println("Координата у должна быть целым числом.");
            }
        }
        Coordinates coordinates = new Coordinates(inputX, inputY);
        return coordinates;
    }

    /**
     * Считывает поле realHero
     * @return true/false
     */
    public Boolean scanRealHero() {
        System.out.println("Это реальный герой? (true/false)");
        String inputRealHero = scanLine().toLowerCase();
        while (!(inputRealHero.equals("false") || inputRealHero.equals("true"))) {
            System.out.println("Невалидное значение, введите (true/false).\nЭто реальный герой?");
            inputRealHero = scanLine().toLowerCase();
        }
        return Boolean.parseBoolean(inputRealHero);
    }

    /**
     * Считывает поле hasToothpick
     * @return true/false
     */
    public boolean scanHasToothpick() {
        System.out.println("У него есть зубочистка? (true/false)");
        String inputHasToothpick = scanLine().toLowerCase();
        while (!(inputHasToothpick.equals("false") || inputHasToothpick.equals("true"))) {
            System.out.println("Некорректное значение. Введите true или false.\nУ него есть зубочистка?");
            inputHasToothpick = scanLine().toLowerCase();
        }
        return Boolean.parseBoolean(inputHasToothpick);
    }

    /**
     * Считывает поле inmpactSpeed
     * @return int (значение скорости)
     */
    private int scanImpactSpeed() {
        System.out.println("Введите значение скорости (`Минимальное значение: -354): ");
        int ImpactSpeed = 0;
        boolean as = true;
        while (as) {
            try {
                ImpactSpeed = Integer.parseInt(scanLine());
                if (ImpactSpeed < -354) {
                    System.out.println("Значение скорости должно быть не ниже -354.\nВведите значение скорости: ");
                } else {
                    as = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Скорость должны быть целым числом.\nВведите значение скорости: ");
            }
        }
        return ImpactSpeed;
    }

    /**
     * Считывает тип оружия
     * @return weaponType
     */
    public WeaponType scanWeaponType(){
        WeaponType weaponType = null;
        boolean dw = true;
        while (dw) {
            System.out.println("Введите тип оружия персонажа из списка:\n" + "knife\n" + "hammer\n" + "bat\n" + "machine_gun\n" + "pistol\nЕсли оружения нет, просто нажмите Enter\n");
            Scanner im = new Scanner(System.in);
            String pol = im.nextLine();
            switch (pol) {
                case "knife":
                    weaponType = WeaponType.KNIFE;
                    dw = false;
                    break;
                case "machine_gan":
                    weaponType = WeaponType.MACHINE_GAN;
                    dw = false;
                    break;
                case "pistol":
                    weaponType = WeaponType.PISTOL;
                    dw = false;
                    break;
                case "hammer":
                    weaponType = WeaponType.HAMMER;
                    dw = false;
                    break;
                case "bat":
                    weaponType = WeaponType.BAT;
                    dw = false;
                    break;
                case "":
                    weaponType = null;
                    dw = false;
                    break;
                default:
                    System.out.println("Вы ввели некорректный тип оружия");
                    break;
            }
        }
        return weaponType;
    }

    /**
     * Считывает тип настроения
     * @return mood
     */
    public Mood scanMood(){
        boolean qrt = true;
        Mood mood = null;
        while (qrt) {
            System.out.println("Введите тип настроения из списка:\n" + "rage\n" + "frenzy\n" + "sorrow\nЕсли настроения нет, просто нажмите Enter");
            Scanner im = new Scanner(System.in);
            String poy = im.nextLine();
            switch (poy) {
                case "sorrow":
                    mood = Mood.SORROW;
                    qrt = false;
                    break;
                case "rage":
                    mood = Mood.RAGE;
                    qrt = false;
                    break;
                case "frenzy":
                    mood = Mood.FRENZY;
                    qrt = false;
                    break;
                case "":
                    mood = null;
                    qrt = false;
                    break;
                default:
                    System.out.println("Вы ввели некорректный тип настроения");
                    break;
            }
        }
        return mood;
    }

    /**
     * Считывает машину
     * @return car
     */
    public Car scanCar() {
        Car car = new Car();
        System.out.println("Введите название машины:");
        String fer = scanLine();
        while (fer.isEmpty()) {
            System.out.println("Имя машины не может быть пустым, введите пожалуйста имя:");
            fer = scanLine();
        }
        car.setName(fer);
        return car;
    }
}
