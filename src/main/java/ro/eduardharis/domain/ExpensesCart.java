package ro.eduardharis.domain;

import java.util.ArrayList;

import ro.eduardharis.persistance.ExpensesDao;

public class ExpensesCart {
	private static ArrayList<Expense> expenseList = new ArrayList<Expense>();

	public void addExpenseToCart(Expense exp) {
		expenseList.add(exp);
	}

	public static ArrayList<Expense> getExpensesCart() {
		System.out.println("Started ExpensesCart");
		return getExpenseListFromDao();
	}

	public static ArrayList<Expense> getExpenseListFromDao() {
		System.out.println("Started getExpenseListFromDao");
		expenseList = ExpensesDao.getExpensesFromDatabase();
		return expenseList;
	}

	// getters and setters

}
