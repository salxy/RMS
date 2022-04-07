import java.util.ArrayList;
import java.util.Scanner;

public class SOLOs {

	public static void main(String[] args) throws InterruptedException {

		// add random dish
		// water price if dine in

		Scanner con = new Scanner(System.in);

		Manager m1 = new Manager();
		Employee e1 = new Employee();
		Table t1 = new Table();
		Receipt r1 = new Receipt();
		Report rp1 = new Report();

		String username, password;
		boolean flag1 = true;
		int countOrders = 0;
		String emname = " ";

		ArrayList<String> namesOfEmp = new ArrayList<String>();

		do {

			System.out.println("Welcome to SOLO!");
			System.out.println("Enter your username: ");
			username = con.next();
			System.out.println("Enter your Password: ");
			password = con.next();

			// manager's page
			if (m1.checkPosition(username, password)) {
				flag1 = true;
				boolean flag3 = false;

				System.out.println("Enter your name: ");
				String manname = con.nextLine();
				manname = con.nextLine();
				System.out.println("Log in successful!\n");
				do {
					System.out.println();
					System.out.println(
							"Choose: \n1. View Daily Report \n2. View Employees \n3. Log out \n4. Shutdown System");
					int num = con.nextInt();
					if (num == 1) {
						rp1.printReport(countOrders, manname);
						flag3 = false;
					} else if (num == 2) {
						rp1.viewEmployees(namesOfEmp);
						flag3 = false;

					} else if (num == 3) {
						flag1 = false;
						System.out.println("Logged Out.");
						System.out.println();
						flag3 = true;
					} else if (num == 4) {
						System.err.print("System is shutting down");
						char dot;
						for (int j = 0; j < 3; j++) {
							Thread.sleep(500);
							dot ='.';
							System.err.print(dot);
							Thread.sleep(500);
						}
						
						System.out.println();
						Thread.sleep(2000);

						System.out.println("Shutdown complete, have a nice day!");

						System.exit(0);
					} else {
						System.out.println("Invalid Choice.");
					}

				} while (flag3 == false);

				// employee's page
			} else if (e1.checkPosition(username, password)) {
				flag1 = true;
				int x = 0;
				boolean u = false;
				boolean flag2 = false;
				ArrayList<Integer> theOrder = new ArrayList<Integer>();

				System.out.println("Enter your name: ");
				emname = con.nextLine();
				emname = con.nextLine();
				System.out.println("Log in successful!\n");
				namesOfEmp.add(emname);
				do {
					System.out.println();
					System.out.println("Choose: \n1. Take Order \n2. Print Receipt \n3. Log out");
					int num = con.nextInt();

					if (num == 1) {

						e1.displayMenu();
						System.out.println();

// 						due to exams, we weren't able to perfect this part
//						int randomDish = e1.chooseDish();
//						if(randomDish != 0) theOrder.add(randomDish);

						theOrder = r1.takeOrder();
						countOrders++;

						System.out.println();
						int numberOfAddOns = r1.takeAddOns();

						rp1.profitO(theOrder, numberOfAddOns);
						if (r1.orderType.equals("Takeaway")) {
							r1.displayOrderT(emname);
						} else if (r1.orderType.equals("Dine in")) {
							x = t1.chooseTable();

						}

					} else if (num == 2) {

						try {
							if (r1.orderType.equals("Dine in")) {
								u = t1.isNotOccupied();
								r1.displayOrderD(u, x, emname);
							}
						} catch (Exception e) {
							System.out.println("No occupied tables yet.");
						}

					} else if (num == 3) {
						System.out.println("Logged Out.");
						System.out.println();
						flag2 = true;
						flag1 = false;
					} else {
						System.out.println("Invalid Choice.");
					}

				} while (flag2 == false);

			} else {
				System.err.print("Invalid username or Password. Please try again.");
				System.out.println();
				System.out.println();
				flag1 = false;
			}

		} while (flag1 == false);

		con.close();
	}

}
