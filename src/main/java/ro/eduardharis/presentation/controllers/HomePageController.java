package ro.eduardharis.presentation.controllers;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.eduardharis.domain.DateService;
import ro.eduardharis.domain.Expense;
import ro.eduardharis.domain.ExpenseService;

@Controller
public class HomePageController {
	@RequestMapping("/")
	public ModelAndView homePage() {
		System.out.println("entered homepage controller");
		return new ModelAndView("homepage");
	}

	@RequestMapping("/currentExpenses")
	public ModelAndView currentExpenses() {
		System.out.println("started currentExpenses Controller");
		ArrayList<Expense> expenseList = ExpenseService.getExpenseList();
		return new ModelAndView("currentExpenses", "expenseList", expenseList);
	}

	@RequestMapping("/addExpenses")
	public ModelAndView addExpenses() {
		return new ModelAndView("addExpenses");
	}

	@RequestMapping("/addedExpense")
	public ModelAndView addedExpense(
			@RequestParam("name") String name,  
			@RequestParam("date") String dateString,
			@RequestParam("singleCost") double singleCost,
			@RequestParam("pcs") int pcs,
			@RequestParam("description") String description			
			) throws ParseException{
		Expense addedExpenseItem = new Expense(name, DateService.stringToDateHtml(dateString), singleCost, pcs, description);
		ExpenseService.addExpense(addedExpenseItem);
		return new ModelAndView("addedExpense", "addedExpenseItem",addedExpenseItem);
	}
}
