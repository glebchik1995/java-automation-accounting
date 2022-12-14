import java.util.ArrayList;
import java.util.HashMap;
public class MonthlyReport {

    public ArrayList<MonthRecord> monthList = new ArrayList<>();

    public MonthlyReport(int month) {

        String content = FileReader.readFileContentsOrNull("resources/m.20210" + month + ".csv");
        String[] lines = content.split(System.lineSeparator());
        for (int j = 1; j < lines.length; j++) {
            String line = lines[j];
            String[] parts = line.split(",");
            String itemName = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int sumOfOne = Integer.parseInt(parts[3]);
            MonthRecord monthRecord = new MonthRecord(itemName, isExpense, quantity, sumOfOne);
            monthList.add(monthRecord);
        }
    }
    public void dataMonth() {

        HashMap<Integer, String> report = new HashMap<>();

        int maxProfit = 0;

        HashMap<Integer, String> expense = new HashMap<>();

        int maxExpense = 0;

        for (MonthRecord monthRecord : monthList) {

            if (!monthRecord.isExpense) {
                report.put((monthRecord.quantity * monthRecord.sumOfOne), monthRecord.itemName);

                for (int max : report.keySet()) {
                    if (max > maxProfit) {
                        maxProfit = max;
                    }
                }
            }
        } System.out.println("Самый прибыльный товар: " + report.get(maxProfit));
          System.out.println("Прибыль составила: " + maxProfit);

        for (MonthRecord monthRecord : monthList) {

            if (monthRecord.isExpense) {
                expense.put((monthRecord.quantity * monthRecord.sumOfOne), monthRecord.itemName);

                for (int max : expense.keySet()) {
                    if (max > maxExpense) {
                        maxExpense = max;
                    }
                }
            }
        } System.out.println("Самый затратный товар: " + expense.get(maxExpense));
          System.out.println("Затрата составила: " + maxExpense);
        }
    }


