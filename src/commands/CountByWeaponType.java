package commands;

import general.GeneralCollection;
import general.WeaponType;

/**
 * Класс, реализующий программу count_by_weapon_type weaponType, которая выводит количество элементов, значение поля weaponType которых равно заданному
 */
public class CountByWeaponType extends Command{
    private WeaponType weaponType;
    /**
     * Метод реализоывает проверку коллекции на пустоту и вывод количества элементов карты,у которых поле weaponTyoe равно заданному (null тоже)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        if (generalCollection.getGenCollection().isEmpty()) {
            updateMessage("Коллекция пуста!");
        }else if (weaponType != null){
            long kolvo = 0;
            kolvo = generalCollection.getGenCollection().entrySet().stream()
                    .filter(entry -> entry.getValue().getWeaponType().equals(weaponType)).count();
            setMessage("Количество элементов, значение поля weaponType которых равно заданному = " + kolvo);
        }else {
            long kolvo = 0;
            kolvo = generalCollection.getGenCollection().entrySet().stream()
                    .filter(entry -> entry.getValue().getWeaponType() == null).count();
            setMessage("Количество элементов, значение поля weaponType которых равно заданному = " + kolvo);
        }
    }
    /** Метод, который проверяет валидность введенного поля weaponType
     * @return
     */
    @Override
    public boolean isValidCommand() {
        String namem = getValue();
        boolean to = false;
        metka:
        if(namem.equals("pistol")) {
            weaponType = WeaponType.PISTOL;
            to = true;
            break metka;
        } else if(namem.equals("machine_gan")){
            weaponType = WeaponType.MACHINE_GAN;
            to = true;
            break metka;
        } else if(namem.equals("bat")){
            weaponType = WeaponType.BAT;
            to = true;
            break metka;
        } else if(namem.equals("hammer")){
            weaponType = WeaponType.HAMMER;
            to = true;
            break metka;
        }else if(namem.equals("knife")){
            weaponType = WeaponType.KNIFE;
            to = true;
            break metka;
        }else if(namem.equals("null")) {
            weaponType = null;
            to = true;
            break metka;
        }else {
            System.out.println("Вы ввели некорректный тип поля mood, введите тип поля mood из списка:\n" + "rage\n" + "frenzy\n" + "sorrow\n");
        }
        return to;
    }
}
