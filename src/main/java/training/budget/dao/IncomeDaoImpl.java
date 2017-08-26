package training.budget.dao;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import training.budget.model.Income;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class IncomeDaoImpl implements IncomeDao {

    Session session;

    public IncomeDaoImpl() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
    }

    public Income addIncome(String name, double amount) {

        Transaction transaction = null;

        transaction = session.beginTransaction();
        Income income = new Income(name, amount);

        session.save(income);
        transaction.commit();

        return income;
    }

    public void updateIncome(int incomeId, String incomeName, double incomeAmount) {

        Transaction transaction = null;

        transaction = session.beginTransaction();
        Income income = (Income) session.get(Income.class, incomeId);
        income.setName(incomeName);
        income.setAmount(incomeAmount);
        session.update(income);
        transaction.commit();

    }

    public void removeIncome(int incomeId) {
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Income income = (Income) session.get(Income.class, incomeId);
        session.delete(income);
        transaction.commit();
    }

    public Income getIncomeById(int incomeId) {
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Income income = (Income) session.get(Income.class, incomeId);
        transaction.commit();

        return income;
    }

    public List<Income> listIncomes() {
        Transaction transaction = null;
        transaction = session.beginTransaction();

        List incomes = session.createQuery("FROM Income ").list();

        return incomes;
    }

    public void closeSession() {
        session.close();
    }
}
