package commands;

import general.GeneralCollection;

/**
 * Класс, реализующий программу info, которая выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, кол-во элементов и тд)
 */
public class Info extends Command {
    /**
     * Метод возвращает информацию о коллекции
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
            setMessage(generalCollection.toString());
    }

    @Override
    public boolean isValidCommand() {
        return true;
    }
}
