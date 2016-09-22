package ro.eduardharis.persistance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.mock.web.MockMultipartFile;

import ro.eduardharis.domain.DateService;
import ro.eduardharis.domain.Expense;

public class ExpensesDao {

	public static void sendExpenseToDao(Expense addedExpenseItem) {
		BufferedWriter writer = getBufferedWriter();
		try {
			writer.append(addedExpenseItem.toString() + "\n");
			writer.close();
		} catch (IOException e) {
			System.out.println("probleme cu scrierea in fisier");
			e.printStackTrace();
		}
	}

	private static BufferedWriter getBufferedWriter() {
		File file = new File("ExpensesDatabase.proprieties");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			return writer;
		} catch (IOException e) {
			System.out.println("probleme cu deschiderea fisierului");
			e.printStackTrace();
			return null;
		}

	}

	public static ArrayList<Expense> getExpensesFromDatabase(){
		System.out.println("Started big DAO process");
		
		
//		File mfile = new File("ExpensesDatabase.proprieties");
//		FileInputStream input = null;
//		try {
//			input = new FileInputStream(mfile);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			MockMultipartFile multipartFile = new MockMultipartFile("file", mfile.getName(), "text/plain",
//					IOUtils.toByteArray(input));
//			System.out.println((multipartFile.getSize()));
//			
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		ArrayList<Expense> expenseList = new ArrayList<>();
		Properties prop = new Properties();
		try {
			FileInputStream stream = new FileInputStream(new File("ExpensesDatabase.proprieties"));
			prop.load(stream);
			int i = 0;
			while (true) {
				i++;
				if (prop.getProperty("Expense[" + i + "].name") == null) {
					break;
				}
				Expense localExpense = new Expense(null, null, 0, 0, null);

				String name = prop.getProperty("Expense[" + i + "].name");
				localExpense.setName(name);

				Calendar date = DateService.stringToDateDatabase(prop.getProperty("Expense[" + i + "].date"));
				localExpense.setDate(date);

				Double singleCost = Double.parseDouble(prop.getProperty("Expense[" + i + "].singleCost"));
				localExpense.setSingleCost(singleCost);

				Integer pcs = Integer.parseInt(prop.getProperty("Expense[" + i + "].pcs"));
				localExpense.setPcs(pcs);

				String description = prop.getProperty("Expense[" + i + "].description");
				localExpense.setDescription(description);

				localExpense.setId(i);

				expenseList.add(localExpense);

			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
			System.out.println("file not found");
		}

		return expenseList;
	}

	public static int getCount() {
		Properties prop = new Properties();
		int refactor = 0;
		try {
			FileInputStream stream = new FileInputStream(new File("ExpensesDatabase.proprieties"));
			prop.load(stream);

			while (true) {
				refactor++;
				if (prop.getProperty("Expense[" + refactor + "].name") == null) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("file not found");
		}

		refactor--;
		return refactor;
	}
}
