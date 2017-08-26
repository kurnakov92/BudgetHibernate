package training.budget.dao;

import training.budget.model.Income;

import java.util.List;

public interface IncomeDao {

    public Income addIncome(String name, double amount);

    public void updateIncome(int id, String name, double amount);

    public void removeIncome(int id);

    public Income getIncomeById(int id);

    public List<Income> listIncomes();

}
