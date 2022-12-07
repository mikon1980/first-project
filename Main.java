
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker steptracker = new StepTracker();
        printMenu();

        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                int command;
                do {
                    int month;
                    int day;
                    int steps;
                    System.out.println("Укажите номер месяца от 1 до 12, где январь - 1, а декабрь - 12");
                    month = scanner.nextInt();
                    System.out.println("Укажите дату месяца от 1 до 30");
                    day = scanner.nextInt();
                    System.out.println("Укажите количество шагов в этот день");
                    steps = scanner.nextInt();
                    steptracker.stepTracker(month, day, steps);
                    System.out.println("Указать данные еще за один день? (Да - 1 / Нет - 0)");
                    command = scanner.nextInt();
                } while (command == 1);
            } else if (userInput == 2) {
                System.out.println("Укажите номер месяца от 1 до 12, где январь - 1, а декабрь - 12");
                int inputMonthStatistic = scanner.nextInt();
                System.out.println("Количество пройденных шагов по дням:");
                steptracker.printStepInMonth(inputMonthStatistic);
                System.out.println();
                System.out.println();
                steptracker.calculatorTotalSteps(inputMonthStatistic);
                System.out.println("Общее количество шагов за месяц: " + steptracker.totalStepsInMonth);
                steptracker.calculatorMaxSteps(inputMonthStatistic);
                System.out.println("Максимальное количество шагов за месяц: " + steptracker.maxStepsInMonth);
                steptracker.calculatorAverageSteps(inputMonthStatistic);
                System.out.println("Среднее количество шагов за месяц: " + steptracker.averageStepsInMonth);
                steptracker.calculatorDistanceStep();
                System.out.println("Пройденная дистанция (в км) за месяц: " + steptracker.distanceStepInMonth);
                steptracker.calculatorCaloriesInSteps();
                steptracker.calculatorBestSteps(inputMonthStatistic);
                System.out.println("Лучшая серия: " + steptracker.bestStepsMonth);
            } else if (userInput == 3) {
                System.out.println("Текущее значение " + steptracker.stepInDayNominal + " шагов в день по умолчанию");// для проверки меняемого значения
                System.out.println("Укажите желаемое количество шагов в день по умолчанию:");
                int inputChangeScanner = scanner.nextInt();
                steptracker.changeNominalStep(inputChangeScanner);
                System.out.println("Установлено новое значение " + steptracker.stepInDayNominal + " шагов в день по умолчанию");
            } else if (userInput == 4) {
                break;
            } else {
                System.out.println("Извините, такой команды пока нет");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }
    private static void printMenu(){
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выход из приложения");

    }
}