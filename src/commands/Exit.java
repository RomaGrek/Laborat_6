package commands;//package commands;

import Client.ClientCommandPusk;
import general.GeneralCollection;
/**
 * Класс, реализующий программу exit, которая завершает программу (без сохранения в файл)
 */
public class Exit extends Command{
    /** Метод, который завершает клиентский модуль
     * @return
     */
    @Override
    public boolean isValidCommand() {
        return true;
    }
    /**
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        setMessage("Завершение.\n");
    }
}
