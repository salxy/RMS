import java.util.ArrayList;
import java.util.Date;

public class Report extends Manager {

	protected double profitO = 0;
	protected double revenueO = 0;
	protected double totalCostO = 0;

	protected double profitA = 0;
	protected double revenueA = 0;
	protected double totalCostA = 0;

	protected double totalCost = 0;
	protected double totalProfit = 0;
	protected double totalRevenue = 0;

	public double[] sellingPrice = { 8.99, 10.00, 7.00, 5.00, 5.50, 4.00, 2.00, 2.50, 2.50, 1.50, 2.00, 1.00 };
	private double[] cost = { 5.99, 6.23, 4.20, 3.34, 3.65, 2.00, 1.50, 1.75, 1.75, 0.50, 0.99, 0.30 };
	private static double costOfEachAddOn = 0.22;
	private static double priceOfEachAddOn = 2.0;


	// calculates cost, revenue, and profit of orders of the day
	public void profitO(ArrayList<Integer> orderCopy, int numAdds) {
		int x;
		for (int i = 0; i < orderCopy.size(); i++) {
			x = orderCopy.get(i);
			revenueO += sellingPrice[x - 1];
			totalCostO += cost[x - 1];
		}
		profitO = (revenueO - totalCostO);

		totalCostA = numAdds * costOfEachAddOn;
		revenueA = numAdds * priceOfEachAddOn;
		profitA = revenueA - totalCostA;

		totalCost = totalCostA + totalCostO;
		totalRevenue = revenueA + revenueO;
		totalProfit = profitA + profitO;

	}

	// prints daily report
	public void printReport(int orders, String name) {

		System.out.println("\t~~Report Of The Day~~");
		System.out.println("-----------------------------------");
		System.out.println("Number of orders of the day: " + orders);
		System.out.println("Cost of all the orders: $" + totalCost);
		System.out.println("Revenue from all the orders: $" + totalRevenue);
		System.out.println("Profit from all the orders: $" + totalProfit);
		System.out.println("-----------------------------------");
		System.out.println("\tSupervised by " + name);
		Date d = new Date();
		System.out.println("     " + d.toLocaleString());
	}
}
