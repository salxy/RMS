import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Manager implements Position {

	private String managerName;
	private static String managerID = "Manager2021";
	private static String managerPassword = "Mang0307";

	protected ArrayList<String> totalOrders = new ArrayList<String>();

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	// checks if manager's id and password are correct
	public boolean checkPosition(String id, String password) {

		boolean flag;
		if (id.equals(managerID) && password.equals(managerPassword)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public void ordersOfTheDay(ArrayList<String> orders) {
		totalOrders = orders;
	}

	public void viewEmployees(ArrayList<String> emp) {
		LocalDate date = LocalDate.now();
		DateTimeFormatter fixed = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

		String todaysDate = date.format(fixed);
		
		System.out.println("Employees working on " + todaysDate + ": ");
		
		for(int i = 0; i< emp.size(); i++) {
			System.out.println("Employee " + (i+1) + ": " + emp.get(i));
		}
	}

}
