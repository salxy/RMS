import java.util.ArrayList;
import java.util.Scanner;

public class Employee implements Position {

	public String employeeName;
	private static String employeeID = "Employ2021";
	private static String employeePassword = "1234567";

	public String[] menu = { "1. Grilled Chicken", "2. Meatball Spaghetti", "3. Pizza Slice", "4. Chicken Burger",
			"5. Hamburger", "6. Cheesecake", "7. Ice Cream", "8. Chocolate Cake", "9. Chocolate Crepes",
			"10. Carbonated Beverages", "11. Coffee", "12. Tea" };

	public String[] description = { "A grilled chicken dish served with vegetables and fries.",
			"A pasta dish with red sauce and meatballs.", "A slice of pepperonni, bbq chicken, or vegetarian pizza.",
			"A chicken burger served with fries and coleslaw.", "A beef burger served with fries and coleslaw.",
			"A piece of strawberry or blueberry cheesecake.", "Three scoops of ice cream with different flavors.",
			"A piece of chocolate cake. ", "Chocolate crepes served with icecream.", };

	public String[] addOns = { "cheese", "ketchup", "mayonnaise", "mustard", "honey mustard", "bbq sauce", "pickles",
			"caramelized onions", "jalapenos", "hot sauce" };

	public double[] sellingPrice = { 8.99, 10.00, 7.00, 5.00, 5.50, 4.00, 2.00, 2.50, 2.50, 1.50, 2.00, 1.00 };
	private String dishOfTheDay; // a dish randomly chosen
	protected ArrayList<Integer> order = new ArrayList<Integer>(); // contains orders in number
	private double totalPrice;
	protected double tax;
	private double totalPriceTaxed;
	protected double addOnsPrice = 0;
	protected ArrayList<String> orderedFood = new ArrayList<String>(); // contains orders in name
	protected ArrayList<String> orderedAddOns = new ArrayList<String>(); // contains add ons in name
	protected final double waterPrice = 1.50;
	protected String orderType; // dine in or takeaway

	public double getTotalPrice() {
		return totalPrice;
	}

	public double getTotalPriceTaxed() {
		return totalPriceTaxed;
	}

	public ArrayList<Integer> getOrder() {
		return order;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	// checks if employee's id and password are correct
	public boolean checkPosition(String id, String password) {

		boolean flag;
		if (id.equals(employeeID) && password.equals(employeePassword)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}


	// randomly choose a dish from menu
	public int chooseDish() {
		Scanner con = new Scanner(System.in);
		int num;
		int num2 = 0;
		System.out.println("Don't know what to order? (Y for yes || N for no)");
		char z = con.next().charAt(0);
		if (z == 'Y') {
			int x = (int) (Math.random() * 5);
			dishOfTheDay = menu[x];
			System.out.println(dishOfTheDay);
			num = (int) dishOfTheDay.charAt(0);
			num2 = Character.getNumericValue(num);
			order.add(num2);
		} else if (z == 'N') {

		} else {
			System.out.println("Invalid answer.");
		}
		 
		return num2;
	}

	// displays menu with description and prices
	public void displayMenu() {
		System.out.println();
		System.out.println("SOLO's Menu");
		System.out.println("=================");
		for (int i = 0; i < 12; i++) {
			System.out.println(menu[i] + ":\n" + "Price: $" + sellingPrice[i]);

			if (i >= 0 && i < 9) {
				System.out.println("Description: " + description[i]);
			}
			System.out.println("---------------------------------------------------------------");
		}
		System.out.println("Available Add-Ons: ($2 each)");
		System.out.print(addOns[0]);
		for (int i = 1; i < addOns.length; i++) {
			System.out.print(", " + addOns[i]);
		}
		System.out.println();
	}

	// takes order from customer by number
	public ArrayList<Integer> takeOrder() {
		Scanner con = new Scanner(System.in);
		boolean flag = true;

		order.removeAll(order);

		System.out.print("Enter your order: ");
		System.err.println("(0 to quit)");

		while (flag == true) {
			int dishOrdered = con.nextInt();
			if (dishOrdered == 0) {
				flag = false;
			} else {
				if (dishOrdered <= 12) {
					order.add(dishOrdered);
					flag = true;
				} else {
					System.err.println("Invalid order!");
				}
			}
		}
		return order;
	}

	// takes add ons from customer by name of add on
	public int takeAddOns() {
		Scanner con = new Scanner(System.in);

		orderedAddOns.removeAll(orderedAddOns);

		System.out.println("Do you want addOns?: (Y for yes || N for no)");
		char x1 = con.next().charAt(0);
		if (x1 == 'Y') {
			boolean flag2 = true;
			System.out.print("Insert addOns:");
			System.err.println("(0 to quit)");
			while (flag2 == true) {
				String o = con.nextLine();
				String o1 = o.toLowerCase();
				if (o1.equals("0")) {
					flag2 = false;
				} else {
					for (int i = 0; i < addOns.length; i++) {
						if (o1.equals(addOns[i])) {
							orderedAddOns.add(o1);
							addOnsPrice += 2;
						}
					}
				}
			}
		} else if (x1 == 'N') {

		} else {
			System.out.println("Invalid answer.");
		}
		System.out.println("1.Dine in \n2.Takeaway?");
		int x = con.nextInt();
		if (x == 1) {
			setOrderType("Dine in");
		} else {
			setOrderType("Takeaway");

		}
		return orderedAddOns.size();

	}

	// calculates total price from taken order
	public void calculateTotalPrice() {

		double sum = 0;
		for (int i = 0; i < order.size(); i++) {
			int x = order.get(i);
			sum += sellingPrice[x - 1];
		}
		addOnsPrice = orderedAddOns.size() * 2;
		totalPrice = sum + addOnsPrice;
		tax = sum * 0.15;
		totalPriceTaxed = totalPrice + tax;

	}

}
