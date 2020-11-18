package cafeBillingService;

import java.util.HashMap;
import java.util.Scanner;

public class CafeBillingService {

	public static void main(String[] args) {
		
		//get customer order
		HashMap<String, Integer> order = new HashMap<String, Integer>();
		
		Scanner customerOrder = new Scanner(System.in);
		System.out.println("Welcome to Caffe MacD! Please order here ");
		System.out.println("Enter number of Coca Cola ( $"+ CafeMenu.COCA_COLA +" ):");
		order.put("cola", customerOrder.nextInt());
		System.out.println("Enter number of Coffee ( $"+ CafeMenu.COFFEE +" ) :");
		order.put("coffee", customerOrder.nextInt());
		System.out.println("Enter number of CheesSandwitch ( $"+ CafeMenu.CHEASE_SANDWITCH +" ) :");
		order.put("cheeseSandwitch", customerOrder.nextInt());
		System.out.println("Enter number of SteakSandwitch ( $"+ CafeMenu.STEAK_SANDWITCH +" ) :");
		order.put("steakSandwitch", customerOrder.nextInt());
		customerOrder.close();
		
		CafeBillingService caffeBill = new CafeBillingService();
		String total = caffeBill.processInvoice(order);
		System.out.println("Total Bill : $" + total);
	}


	public String processInvoice(HashMap<String, Integer> customerOrder) {
		
		CalculatePrice cp = new CalculatePrice();
		return cp.calculateTotalPrice(customerOrder);
		
	}
	
	
	
	
	
}

