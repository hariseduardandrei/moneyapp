package ro.eduardharis.domain;

import java.util.ArrayList;

import ro.eduardharis.persistance.ExpensesDao;


public class ExpenseService {

	public static void addExpense(Expense addedExpenseItem) {
		ExpensesDao.sendExpenseToDao(addedExpenseItem);
		
	}

	public static ArrayList<Expense> getExpenseList() {
		System.out.println("started ExpenseService");
		return ExpensesCart.getExpensesCart();
	}

}
