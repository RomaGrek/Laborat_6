package commands;

import general.GeneralCollection;

/**
 * Класс, реализующий программу sum_of_impact_speed, которая выводит сумму значений поля impactSpeed для всех элементов коллекции
 */
public class SumOfImpactSpeed extends Command {
    /**
     * Метод возваращает сумму значений поля impactSpeed для всех элементов коллекции
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(GeneralCollection generalCollection) {
        if (generalCollection.getGenCollection().isEmpty()) {
            updateMessage("Коллекция пуста!");
        } else {
            int sum;
            sum = generalCollection.getGenCollection().entrySet().stream().mapToInt(entry -> entry.getValue().getImpactSpeed()).sum();
            setMessage("Cумма значений поля impactSpeed для всех элементов коллекции = " + sum);
        }

        }

    @Override
    public boolean isValidCommand() {
        return true;
    }
}
