public class StepTracker {
    int[][] stepsData = new int[12][30]; //массив шагов
    int stepInDayNominal = 10000; // кол-во шагов по умолчанию
    int totalStepsInMonth; // общее количество шагов в месяц
    int distanceStepInMonth; // Пройденная дистанция (в км);
    int caloriesInSteps; // Количество сожжённых калорий;
    int averageStepsInMonth; // среднее количество шагов в месяц
    int realDayInSteps; // реальное кол-во дней с показателями шагов в месяце
    int maxStepsInMonth; // максимальное кол-во шагов в месяц
    int bestStepsMonth; // лучшая серия идущих подряд дней с показателями выше целевого


    public void stepTracker(int month, int day, int steps) { // заполнение массива шагов
        if (month > 0 && month < 13 && day > 0 && day < 31 && steps >0) {
            stepsData[month - 1][day - 1] = steps;
            //Arrays.stream(stepsData).map(Arrays::toString).forEach(System.out::println);// для проверки (удалить)
        } else {
            System.out.println("Введенные данные не корректны, ошибка в дате или Вы ввели отрицательное число");
        }
    }

    public void changeNominalStep(int inputChangeScanner) { // установка нового значения кол-ва шагов по умолчанию
        if (inputChangeScanner >= 0) {
            stepInDayNominal = inputChangeScanner;
        } else {
            System.out.println("Введенные данные не корректны, возможно Вы ввели отрицательное число");
        }
    }

    public void calculatorMaxSteps(int inputMonthStatistic) { // определение максимального кол-ва шагов в месяце
        int x = stepsData.length;
        for (int i = 0; i < x; i++) {
            if (i == (inputMonthStatistic - 1)) {
                for (int j = 0; j < x; j++) {
                    if (stepsData[i][j] > maxStepsInMonth) {
                        maxStepsInMonth = stepsData[i][j];
                    }
                }
            }
        }
    }

    public void calculatorTotalSteps(int inputMonthStatistic) { // расчет общего кол-ва шагов за месяц
        totalStepsInMonth = 0;
        int x = stepsData.length;
        for (int i = 0; i < x; i++) {
            if (i == (inputMonthStatistic - 1)) {
                for (int j = 0; j < x; j++) {
                    totalStepsInMonth = totalStepsInMonth + stepsData[i][j];
                }
            }
        }
    }

    public void calculatorAverageSteps(int inputMonthStatistic) { // определяем кол-во фактических дней с шагами в месяце
        int x = stepsData.length;
        realDayInSteps = 0;
        for (int i = 0; i < x; i++) {
            if (i == (inputMonthStatistic - 1)) {
                for (int j = 0; j < x; j++) {
                    if (stepsData[i][j] != 0) {
                        realDayInSteps = realDayInSteps + 1;
                        averageStepsInMonth = totalStepsInMonth / realDayInSteps;
                    }
                }
            }
        }
    }

    public void calculatorDistanceStep() {
        //distanceStepInMonth = 0;
        distanceStepInMonth = (totalStepsInMonth * 75) / 100000;
    }

    public void calculatorCaloriesInSteps() {
        int x = totalStepsInMonth * 50;
        if (x < 1000 && x > 0) {
            caloriesInSteps = x;
            System.out.println("Количество сожжённых калорий: " + x);
        } else if (x >= 1000) {
            caloriesInSteps = x / 1000;
            System.out.println("Количество сожжённых килокалорий: " + x);
        }
    }

    public void printStepInMonth(int inputMonthStatistic) {
        String printOut;
        int x = stepsData.length;
        realDayInSteps = 0;
        for (int i = 0; i < x; i++) {
            if (i == (inputMonthStatistic - 1)) {
                for (int j = 0; j < x; j++) {
                    if (stepsData[i][j] != 0) {
                        printOut = " " + (j + 1) + " день: " + stepsData[i][j] + ",";
                        System.out.print(printOut);
                    }
                }
            }
        }
    }

    public void calculatorBestSteps(int inputMonthStatistic) { // определение максимального кол-ва шагов в месяце
        int x = stepsData.length;
        int a = 0, b = 0;
        for (int i = 0; i < x; i++) {
            if (i == (inputMonthStatistic - 1)) {
                for (int j = 0; j < x; j++) {
                    if (stepsData[i][j] >= stepInDayNominal) {
                        a = a + 1;
                        bestStepsMonth = a;
                    } else if (stepsData[i][j] < stepInDayNominal) {
                        if (a > b) {
                            a = b;
                        } else {
                            a = 0;
                        }
                    }
                }
            }
        }
    }
}
