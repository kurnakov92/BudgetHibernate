package training.budget.consoleRunners;

import training.budget.dao.IncomeDaoImpl;
import training.budget.model.Income;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class IncomeRunner {

    public static void main(String[] args) {
        String userInput = ""; // Line read from standard in
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);

        IncomeDaoImpl incomeDaoImpl = new IncomeDaoImpl();

        try {
            while (!"0".equals(userInput)) {
                System.out.println("1. Добавить доход");
                System.out.println("2. Найти доход");
                System.out.println("3. Редактировать доход");
                System.out.println("4. Удалить доход");
                System.out.println("5. Вывести все записи");
                System.out.println("0. Выход");

                userInput = in.readLine();

                if ("1".equals(userInput)) {
                    try {
                        String incomeName = "";
                        double incomeAmount = 0;
                        System.out.print(" Введите название дохода: ");
                        incomeName = in.readLine();
                        System.out.print(" Введите сумму дохода: ");
                        incomeAmount = Double.parseDouble(in.readLine());

                        Income income = incomeDaoImpl.addIncome(incomeName, incomeAmount);
                        System.out.println("Доход создан. Название: "
                                + income.getName() + " сумма: " + income.getAmount());
                    } catch (Exception e) {
                        System.out.println("FAIL");
                    }
                } else if ("2".equals(userInput)) {
                    try {
                        int incomeId = 0;
                        System.out.print(" Введите ID дохода: ");
                        incomeId = Integer.parseInt(in.readLine());
                        Income income = incomeDaoImpl.getIncomeById(incomeId);
                        System.out.println("Статья дохода получена из базы данных. Название: "
                                + income.getName() + " сумма: " + income.getAmount());
                    } catch (Exception e) {
//                        System.out.println("Доход с ID =  " + incomeId + " не существует.");
                        System.out.println("FAIL");
                    }
                } else if ("3".equals(userInput)) {
                    try {
                        int incomeId = 0;
                        String incomeName = "";
                        double incomeAmount = 0;
                        System.out.print(" Введите ID дохода: ");
                        incomeId = Integer.parseInt(in.readLine());
                        Income income = incomeDaoImpl.getIncomeById(incomeId);
                        System.out.print(" Введите название дохода: ");
                        incomeName = in.readLine();
                        System.out.print(" Введите сумму дохода: ");
                        incomeAmount = Double.parseDouble(in.readLine());
                        incomeDaoImpl.updateIncome(income.getId(), incomeName, incomeAmount);
                    } catch (Exception e){
//                        System.out.println("Доход с ID =  " + incomeId + " не существует.");
                        System.out.println("FAIL");
                    }
                } else if ("4".equals(userInput)) {
                    try {
                        int incomeId = 0;
                        System.out.print(" Введите ID дохода: ");
                        incomeId = Integer.parseInt(in.readLine());
                     //   Income income = incomeDaoImpl.getIncomeById(incomeId);
                        incomeDaoImpl.removeIncome(incomeId);
                        System.out.println("Статья дохода с ID =  " + incomeId + " удаленa из базы данных.");
                    } catch (Exception e) {
                        System.out.println("FAIL");
//                        System.out.println("Доход с ID = " + incomeId + " не существует.");
                    }
                } else if ("5".equals(userInput)){
                    try {
                        System.out.println("==========ДОХОДЫ=========");
                        List<Income> incomes = incomeDaoImpl.listIncomes();
                        for (Income income : incomes) {
                            System.out.println(income);
                            System.out.println("\n================\n");
                        }
                    } catch (Exception e){
                        System.out.println("FAIL");
                    }
                }
            }
            incomeDaoImpl.closeSession();
        } catch (Exception ex) {
            System.out.println("FAIL");
        }

    }

}
