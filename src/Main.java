import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Manager manager = new Manager();

        while (true) {

            printMenu();

            int userInput = scanner.nextInt();

            if (userInput == 1) {
            manager.readMonthlyReport();
            } else if (userInput == 2) {
            manager.readYearlyReport();
            } else if (userInput == 3) {
            manager.checkReports();
            } else if (userInput == 4) {
            manager.printMonthReport();
            } else if (userInput == 5) {
            manager.printYearReport();
            } else if (userInput == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
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

