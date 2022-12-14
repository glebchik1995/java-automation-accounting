import java.util.ArrayList;
public class YearlyReport {
    public ArrayList<YearRecord> yearList = new ArrayList<>();

    public YearlyReport() {
        String content = FileReader.readFileContentsOrNull("resources/y.2021.csv");
        String[] lines = content.split(System.lineSeparator());
        for (int i = 1; i < lines.length; i ++){
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            YearRecord yearRecord = new YearRecord(month,amount,isExpense);
            yearList.add(yearRecord);
        }
    }
    public void dataYear() {

        ArrayList<Integer> profitList = new ArrayList<>();

        ArrayList<Integer> expensesList = new ArrayList<>();

        for (YearRecord yearRecord : yearList) {
            if (!yearRecord.isExpense) {
                profitList.add(yearRecord.amount);
            } else {
                expensesList.add(yearRecord.amount);
            }
        }
        System.out.println("Прибыль в 1-м месяце составила: " + profitList.get(0));
        System.out.println("Прибыль во 2-м месяце составила: " + profitList.get(1));
        System.out.println("Прибыль в 3-м месяце составила: " + profitList.get(2));
        System.out.println("Средний доход за все месяцы в году: " + (profitList.get(0) + profitList.get(1) + profitList.get(2))/profitList.size());
        System.out.println("Средний расход за все месяцы в году: " + (expensesList.get(0) + expensesList.get(1) + expensesList.get(2))/expensesList.size());
        }
    }




