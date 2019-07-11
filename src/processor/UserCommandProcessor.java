package processor;

import entities.Bird;
import store.BirdStore;

import java.util.Scanner;

/**
 * Реализовать интерфейсы IBirdCreator, IUserCommandProcessor, IInfiniteLoopProcessor
 */
public class UserCommandProcessor implements IBirdCreator, IInfiniteLoopProcessor, IUserCommandProcessor {

    @Override
    public Bird createBird(Scanner userInputReader) {

        Scanner consoleInputReader = new Scanner(System.in);

        System.out.println("Please, enter bird id:   ");
        Integer id = consoleInputReader.nextInt();

        System.out.println("Please, enter bird name:   ");
        String name = consoleInputReader.nextLine();
        System.out.println("////////////////////");

        System.out.println("Please, enter bird living area:  ");
        String living_area = consoleInputReader.nextLine();

        System.out.println("Please, enter bird size:  ");
        Double size = consoleInputReader.nextDouble();

        Bird bird = new Bird( id, name, living_area, size);
        BirdStore.birdStore().addBird(bird);
        return bird;
    }

    @Override
    public void processInLoop() {
        Scanner consoleInputReader = new Scanner(System.in);
        while (true) {
            System.out.println("Please, enter command:\n" +
                    "     *      a - add new Bird\n" +
                    "     *      s - search bird by name\n" +
                    "     *      l - search bird by living area\n" +
                    "     *      d - delete bird\n" +
                    "     *      exit - terminate application    ");
            String value = consoleInputReader.nextLine();
            if (value.equals("exit")) {
                break;
            } else {
                processUserCommand(value, consoleInputReader);
            }
        }
    }

    /**
     * Выполняет комманлу пользователя
     * <p>
     * 1) если введена комманда a:
     * - запрашиваем у пользователя Please, enter bird name
     * - читаем введенное значение
     * - запрашиваем у пользователя Please, enter bird living area
     * - читаем введенное значение
     * - запрашиваем у пользователя Please, enter bird size
     * - читаем введенное значение
     * - вызываем соответствующий метод BirdStore.
     * <p>
     * 2) если введена комманда s:
     * - запрашиваем у пользователя Please, enter bird name to search
     * - читаем введенное значение
     * - находим объект с такми именем BirdStore, печатаем Find bird : ....
     * <p>
     * 3) если введена комманда l:
     * - запрашиваем у пользователя Please, enter bird living area to search
     * - читаем введенное значение
     * - находим объекты с такми living area в BirdStore, печатаем Find bird : ....
     * <p>
     * 4) если комманда неизвестна - выводим Unknown command.
     *
     * @param command         команда которую ввел пользователь
     * @param userInputReader объект Scanner который будет использоватеься для чтения дополнительных параметров.
     */
    @Override
    public void processUserCommand(String command, Scanner userInputReader) {

        switch (command) {
            case "a":
                createBird(userInputReader);
//                System.out.println("Please, enter bird name:   ");
//                String name = consoleInputReader.nextLine();
//                System.out.println("Please, enter bird living area:  ");
//                String living_area = consoleInputReader.nextLine();
//                System.out.println("Please, enter bird size:  ");
//                Double size = consoleInputReader.nextDouble();
//                Bird bird = new Bird(name, living_area, size);
//                BirdStore.birdStore().addBird(bird);
                break;
            case "s":
                System.out.println("Please, enter bird name to search -> ");
                String searchBirdName = userInputReader.nextLine();
                System.out.println(" Find bird : " + BirdStore.birdStore().searchByName(searchBirdName));
                break;
            case "l":
                System.out.println("Please, enter bird living area to search -> ");
                String searchBirdLivingArea = userInputReader.nextLine();
                System.out.println(" Find bird to area : " + BirdStore.birdStore().searchByLivingArea(searchBirdLivingArea));
                break;
            case "d":
                System.out.println("Please, enter bird id to delete -> ");
                int bird = userInputReader.nextInt();
                BirdStore.birdStore().deleteBird(bird);
                break;

            default:
                System.out.println("Unknown command");

        }
    }
}
