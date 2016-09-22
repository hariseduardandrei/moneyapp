package ro.eduardharis.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ro.eduardharis.persistance.ExpensesDao;

public class Expense {
	private static int count = ExpensesDao.getCount();
	private String name;
	private Calendar date;
	private double singleCost;
	private int pcs;
	private String description;
	private int id;

	// Constructor using all fields
	public Expense(String name, Calendar date, double singleCost, int pcs, String description) {
		super();
		int localCount = ExpensesDao.getCount();
		this.id=localCount + 1;
		this.name = name;
		this.date = date;
		this.singleCost = singleCost;
		this.pcs = pcs;
		this.description = description;
	}

	//transforms calendar field to nice string
	public String getStringDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setTimeZone(this.date.getTimeZone());
		return dateFormat.format(this.date.getTime());
	}
	
	// toString using all fields
	@Override
	public String toString() {
		return "Expense["+id+"].name=" + this.getName() +"\n" +
			   "Expense["+id+"].date=" + this.getStringDate() + "\n" +
			   "Expense["+id+"].singleCost=" + this.getSingleCost() + "\n" +
			   "Expense["+id+"].pcs=" + this.getPcs() + "\n" +
			   "Expense["+id+"].description=" + this.getDescription() + "\n";
	}

	

	// getters and setters
	public String getName() {
		return name;
	}
	public void setName(String title) {
		this.name = title;
	}
	public Calendar getDate() {
		return date;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Expense.count = count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDate(Calendar calendar) {
		this.date = calendar;
	}
	public double getSingleCost() {
		return singleCost;
	}
	public void setSingleCost(double singleCost) {
		this.singleCost = singleCost;
	}
	public int getPcs() {
		return pcs;
	}
	public void setPcs(int pcs) {
		this.pcs = pcs;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}