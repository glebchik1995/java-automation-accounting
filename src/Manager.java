import java.util.ArrayList;

public class Manager {
    public ArrayList<YearlyReport> yearLists = new ArrayList<>();
    public ArrayList<MonthlyReport> monthLists = new ArrayList<>();

    void readMonthlyReport() {

        for (int i = 1; i <= 3; i++) {
            monthLists.add(new MonthlyReport(i));
        }
        if (!monthLists.isEmpty()) {
            System.out.println("Файл успешно считан\n");
        } else {
            System.out.println("Не удалось считать\n");
        }
    }

    public void readYearlyReport() {

        yearLists.add(new YearlyReport());

        if (!yearLists.isEmpty()) {
            System.out.println("Файл успешно считан\n");
        } else {
            System.out.println("Не удалось считать\n");
        }
    }

    public void printYearReport() {
        if (!yearLists.isEmpty()) {
            YearlyReport year = yearLists.get(0);
            System.out.println("Годовой отчет за 2021 год предоставлен: ");
            year.dataYear();
        } else {
            System.out.println("Сперва считайте годовой отчет\n");
        }
    }

    public void printMonthReport() {

        if (!monthLists.isEmpty()) {
            for (int i = 0; i < monthLists.size(); i++) {
                System.out.println("Месячный отчет за " + Constant.MONTHS[i] + " :");
                MonthlyReport monthJanuary = monthLists.get(i);
                monthJanuary.dataMonth();
            }

        } else {
            System.out.println("Сперва считайте месячный отчет \n");
        }
    }

    void checkReports() {

        if (yearLists.isEmpty() || monthLists.isEmpty()) {

            System.out.println("Сперва считайте отчеты \n");

        } else {

            ArrayList<Integer> profitMonth = new ArrayList<>();

            ArrayList<Integer> expensesMonth = new ArrayList<>();

            ArrayList<Integer> profitYear = new ArrayList<>();

            ArrayList<Integer> expensesYear = new ArrayList<>();

            for (MonthlyReport monthlyReport : monthLists) {

                for (MonthRecord monthRecord : monthlyReport.monthList) {

                    if (!monthRecord.isExpense()) {

                        profitMonth.add(monthRecord.getQuantity() * monthRecord.getSumOfOne());

                    } else {

                        expensesMonth.add(monthRecord.getQuantity() * monthRecord.getSumOfOne());
                    }
                }
            }
            for (YearlyReport yearlyReport : yearLists) {

                for (YearRecord yearRecord : yearlyReport.yearList) {

                    if (!yearRecord.isExpense()) {

                        profitYear.add(yearRecord.getAmount());

                    } else {

                        expensesYear.add(yearRecord.getAmount());
                    }
                }
            }

            int profitInJanuary = profitMonth.get(0) + profitMonth.get(1) + profitMonth.get(2);
            int profitInFebruary = profitMonth.get(3) + profitMonth.get(4) + profitMonth.get(5);
            int profitInMarch = profitMonth.get(6) + profitMonth.get(7) + profitMonth.get(8);
            int expensesInJanuary = expensesMonth.get(0) + expensesMonth.get(1) + expensesMonth.get(2);
            int expensesInFebruary = expensesMonth.get(3) + expensesMonth.get(4);
            int expensesInMarch = expensesMonth.get(5) + expensesMonth.get(6) + expensesMonth.get(7);

            if (profitInJanuary != profitYear.get(0)) {
                System.out.println("Прибыль в отчете за Январь не совпадает");
            }
            if (profitInFebruary != profitYear.get(1)) {
                System.out.println("Прибыль в отчете за Февраль не совпадает");
            }
            if (profitInMarch != profitYear.get(2)) {
                System.out.println("Прибыль в отчете за Март не совпадает");
            }
            if (expensesInJanuary != expensesYear.get(0)) {
                System.out.println("Трата в отчете за Январь не совпадает");
            }
            if (expensesInFebruary != expensesYear.get(1)) {
                System.out.println("Трата в отчете за Февраль не совпадает");
            }
            if (expensesInMarch != expensesYear.get(2)) {
                System.out.println("Трата в отчете за Март не совпадает");
            } else {
                System.out.println("Траты и прибыль в месячном отчете полностью совпадают с годовым отчетом");
            }

        }
    }

}






