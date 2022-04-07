import java.util.Date;

public class Receipt extends Employee {

	// displays receipt for dine in

	public void displayOrderD(boolean check, int tablenum, String empName) {

		if (check == true) {
			System.out.println("\t~~Welcome to SOLO~~");
			System.out.println("\t  Beirut, Lebanon");
			System.out.println("-----------------------------------");
			System.out.println("\t    " + orderType + " #" + tablenum);
			Date d = new Date();
			System.out.println("     " + d.toLocaleString());
			System.out.println("        Served by: " + empName);
			System.out.println("-----------------------------------");
			System.out.println("Water(1.6L): $" + waterPrice);
			for (int i = 0; i < order.size(); i++) {
				int x = order.get(i);
				orderedFood.add(menu[x - 1] + "\t$" + sellingPrice[x - 1]);
			}

			for (int i = 0; i < orderedFood.size(); i++) {
				System.out.println(orderedFood.get(i));
			}

			if (orderedAddOns.size() != 0) {
				for (int i = 0; i < orderedAddOns.size(); i++) {
					System.out.println(orderedAddOns.get(i));
				}
				System.out.println("Price of Add-Ons: $" + addOnsPrice);
				orderedAddOns.clear();

			}

			System.out.println("-----------------------------------");
			super.calculateTotalPrice();
			System.out.println("Subtotal: $" + (super.getTotalPrice() + waterPrice));
			System.out.println("Tax: $" + tax);
			System.out.println("Total: $" + (super.getTotalPriceTaxed() + waterPrice));

			addOnsPrice = 0;
			orderedFood.clear();
		}
	}

	// displays receipt for takeaway
	public void displayOrderT(String empName) {

		System.out.println("\t~~Welcome to SOLO~~");
		System.out.println("\t  Beirut, Lebanon");
		System.out.println("-----------------------------------");
		System.out.println("\t    " + orderType + " #" + (int) (Math.random() * 51));
		Date d = new Date();
		System.out.println("     " + d.toLocaleString());
		System.out.println("        Served by: " + empName);
		System.out.println("-----------------------------------");
		for (int i = 0; i < order.size(); i++) {
			int x = order.get(i);
			orderedFood.add(menu[x - 1] + "\t$" + sellingPrice[x - 1]);
		}

		for (int i = 0; i < orderedFood.size(); i++) {
			System.out.println(orderedFood.get(i));
		}

		if (orderedAddOns.size() != 0) {
			for (int i = 0; i < orderedAddOns.size(); i++) {
				System.out.println(orderedAddOns.get(i));
			}
			System.out.println("Price of Add-Ons: $" + addOnsPrice);

		}

		System.out.println("-----------------------------------");
		super.calculateTotalPrice();
		System.out.println("Subtotal: $" + super.getTotalPrice());
		System.out.println("Tax: $" + tax);
		System.out.println("Total: $" + super.getTotalPriceTaxed());

		addOnsPrice = 0;
		orderedFood.clear();
	}
}
