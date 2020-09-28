package commands;

import general.GeneralCollection;

/**
 * интерфейс для выполнения команд
 */
public interface CommandDo {
    /**
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    void doing(GeneralCollection generalCollection);
}
