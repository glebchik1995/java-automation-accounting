import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YearlyReport {
    public ArrayList<YearRecord> yearList = new ArrayList<>();

    public YearlyReport() {
        String content = FileReader.readFileContentsOrNull("resources/y.2021.csv");
        if (content != null) {
            String[] lines = content.split(System.lineSeparator());
            for (int i = 1; i < lines.length; i++) {
                String line = lines[i];
                String[] parts = line.split(",");
                int month = Integer.parseInt(parts[0]);
                int amount = Integer.parseInt(parts[1]);
                boolean isExpense = Boolean.parseBoolean(parts[2]);
                YearRecord yearRecord = new YearRecord(month, amount, isExpense);
                yearList.add(yearRecord);
            }
        } else
            System.out.println("Отчет пуст\n");
    }

    public void dataYear() {

        Map<Integer, Integer> profitMap = new HashMap<>();

        Map<Integer, Integer> expensesMap = new HashMap<>();

        int profit = 0;

        int expenses = 0;

        for (YearRecord yearRecord : yearList) {
            if (!yearRecord.isExpense()) {
                profitMap.put(yearRecord.getMonth(), yearRecord.getAmount());
            } else {
                expensesMap.put(yearRecord.getMonth(), yearRecord.getAmount());
            }
        }

        for (Map.Entry<Integer, Integer> entry : profitMap.entrySet()) {
            System.out.println("Прибыль за " + Constant.MONTHS[entry.getKey() - 1]
                    + " составила: " + entry.getValue());
            profit += entry.getValue();
        }

        System.out.println("Средний доход за год составил: " + profit / Constant.MONTHS.length);

        for (int expense : expensesMap.values()) {
            expenses += expense;
        }

        System.out.println("Средний расход за год составил: " + expenses / Constant.MONTHS.length + "\n");

    }

}




