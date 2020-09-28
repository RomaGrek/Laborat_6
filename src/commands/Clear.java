package commands;

import general.GeneralCollection;

/**
 * Класс, реализующий программу clear, очищающую коллекцию
 */
public class Clear extends Command {

    /**
     * Обращение к методу {@link GeneralCollection#clear()}
     * @param generalCollection класс с коллекцией над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        generalCollection.clear();
        setMessage("Коллекция очищена");
    }
    @Override
    public boolean isValidCommand() {
        return true;
    }
}
