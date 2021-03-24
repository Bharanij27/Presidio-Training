package CollectionTest;

import java.util.HashMap;
import java.util.Map;

public class Q4 {
	public static void main(String[] args) {
		
	}
	 
}

class AccountManager{
	private Map<String, Integer> accountTotals = new HashMap<String, Integer>();
	private int retirementFund;
	 
	public int getBalance(String accountName) {
		Integer total = (Integer) accountTotals.get(accountName);
		if (total == null)
			total = 0;
		return total;
	 }
	 
	public void setBalance(String accountName, int amount) {
		accountTotals.put(accountName, amount);
		// from here we can say that accountTotals is map with String as key and Integer as value
	 }
}
