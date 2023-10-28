import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Manager manager = new Manager();

        System.out.println("\n«Автоматизация бухгалтерии»\n");

        while (true) {

            printMenu();

            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    manager.readMonthlyReport();
                    break;
                case 2:
                    manager.readYearlyReport();
                    break;
                case 3:
                    manager.checkReports();
                    break;
                case 4:
                    manager.printMonthReport();
                    break;
                case 5:
                    manager.printYearReport();
                    break;
                case 0:
                    System.out.println("Выход");
                    return;
                default:
                    System.out.println("Извините, такой команды пока нет.");
                    break;

            }
        }
    }

    public static void printMenu() {

        System.out.println("Что вы хотите сделать? ");

        System.out.println("1 - Считать все месячные отчёты");

        System.out.println("2 - Считать годовой отчёт");

        System.out.println("3 - Сверить отчёты");

        System.out.println("4 - Вывести информацию о всех месячных отчётах");

        System.out.println("5 - Вывести информацию о годовом отчёте");

        System.out.println("0 - Выйти из приложения");

    }
}

