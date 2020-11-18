package cafeBillingService;

import java.text.DecimalFormat;
import java.util.HashMap;

public class CalculatePrice {

	
	public String calculateTotalPrice(HashMap<String, Integer> order) {
		
		double total = 0.0;
		double colaPrice, coffeePrice, cheeseSandPrice, steakSandPrice;
		DecimalFormat df = new DecimalFormat("0.00");
		
		//add total price for coca-cola
		if(order.get("cola") != 0) {
			colaPrice = CalculatePrice.getColaTotalPrice(order.get("cola"));
			total += colaPrice;
		}
		
		//add total price for coffee
		if(order.get("coffee") != 0) {
			coffeePrice = CalculatePrice.getCoffeeTotalPrice(order.get("coffee"));
			total += coffeePrice;
		}
		
		//add total price for cheeSandWitch
		if(order.get("cheeseSandwitch") != 0) {
			cheeseSandPrice = CalculatePrice.getCheesSandwitchTotalPrice(order.get("cheeseSandwitch"));
			total += cheeseSandPrice;
		}

		//add total price for cheeSandWitch
		if(order.get("steakSandwitch") != 0 ) {
			steakSandPrice = CalculatePrice.getSteakSandwitchTotalPrice(order.get("steakSandwitch"));
			total += steakSandPrice;
		}

		System.out.println("Subtotal : $" + df.format(total));
		//System.out.println(df.format(total));1
		
		//add service charge if customer order food
		if(order.get("cheeseSandwitch") != 0 || order.get("steakSandwitch") != 0 ) {
			total = total + (total/10);
			System.out.println("SC (10%) : $" + df.format(total/10));
		}
		else {
			System.out.println("SC : NA");
		}

		//Round of total bill
		return df.format( Math.round(total) );
		
	}


	public static double getColaTotalPrice(int orderCount) {
		
		double colaTotalPrice = CafeMenu.COCA_COLA * orderCount;
		return colaTotalPrice;
	}


	public static double getCoffeeTotalPrice(int orderCount) {
		
		double colaTotalPrice = CafeMenu.COFFEE * orderCount;
		return colaTotalPrice;
	}


	public static double getCheesSandwitchTotalPrice(int orderCount) {
		
		double colaTotalPrice = CafeMenu.CHEASE_SANDWITCH * orderCount;
		return colaTotalPrice;
	}


	public static double getSteakSandwitchTotalPrice(int orderCount) {
		
		double colaTotalPrice = CafeMenu.STEAK_SANDWITCH * orderCount;
		return colaTotalPrice;
	}
	
}
