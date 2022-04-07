import java.util.Date;
import java.util.Scanner;

public class Table extends Receipt {

	private int[] tableNumber = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	private int table;

	
	// prompts customer to choose table
	public int chooseTable() {
		Scanner console = new Scanner(System.in);
		System.out.println("Available Tables:");
		for (int i = 0; i < 10; i++) {
			if (tableNumber[i] != 0) {
				System.out.print(tableNumber[i] + " ");
			}
		}
		System.out.println();
		System.out.println("Choose Table: ");
		table = console.nextInt();
		System.out.println();
		isOccupied();
		return table;
	}

	// checks if a table is occupied, table becomes occupied if not
	public void isOccupied() {
		boolean flag = false;
		for (int i = 0; i < 10; i++) {
			if (tableNumber[i] == table) {
				System.out.println("Table number " + table + " is not occupied. Please take a seat.");
				tableNumber[i] = 0;
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("Invalid table number.");
			System.out.println();
			chooseTable();
		}
	}

	// checks if a table wants receipt, table becomes empty if they order receipt
	public boolean isNotOccupied() {

		Scanner console = new Scanner(System.in);
		boolean flag = true;
		System.out.println("What table would like the receipt? (11 for none)");
		int x = console.nextInt();
		while (x == 0 || x>11) {
			System.out.println("Invalid table number. Choose a table between 1 and 10. (11 for none)");
			x = console.nextInt();
		}
		if (tableNumber[x - 1] == 0) {
			tableNumber[x - 1] = x;
			flag = true;
		} else if (x > 0 && x < 11 && tableNumber[x - 1] != 0) {
			System.out.println("Invalid table.");
			flag = false;
		}else if(x==11) {
			flag=false;
		}
		return flag;
	}


}
