package banksys;

import java.util.HashMap;

public class bank {
	private String bankName;
	private HashMap<Integer,Customer> customers;
	private HashMap<String,account> accounts;
	private float currentInterestRate;
	private int numberOfCustomers;
	private int numberOfAccounts;
	static float r;

	
	public bank(String bankName) {
		this.bankName=bankName;
		r= (float)(Math.random());
        accounts = new HashMap<String,account>(); 
        customers = new HashMap<Integer,Customer>(); 

	}
	public void addCustomer(String firstName,String lastName,String nssf) {
		Customer temp=new Customer(firstName,lastName,nssf);
		customers.put(numberOfCustomers, temp);
		numberOfCustomers++;
	}
	public void addCustomer1(Customer p) {
		customers.put(numberOfCustomers, p);
		numberOfCustomers++;

	}
	public String getBankName() {
		return bankName;
	}
	public String toString() {
		String temp="";
		String temp1="";
		for(Customer tt : customers.values()) {
			temp=temp+tt.toString();
		}
		for(account tt : accounts.values()) {
			temp1=temp1+tt.toString()+"\t\t";
		}
		return "Bank Name: "+bankName +"\n"+ "Number of Customers "+numberOfCustomers+ "\n" +"Number of Accounts: "+numberOfAccounts +"\n" +"Total Deposits: $"+getTotalDeposits()+"\nCustomers\n"
		+"\t"+temp+"\nAll Bank Accounts: \n\t"+temp1;
	}
	public boolean customerExists(Customer p) {
		for(Customer tt : customers.values()){
			if(tt.firstName.equals(p.firstName) && tt.lastName.equals(p.lastName) && tt.getnssf().equalsIgnoreCase(p.getnssf())) {
				return true;
			}
		}
		return false;
	}
	public HashMap<Integer,Customer> getCustomers() {
		return customers;
	}
	public int getIndex(Customer p) {
		for(int i=0;i<numberOfCustomers;i++) {
			if(customers.get(i).firstName.equals(p.firstName) && customers.get(i).lastName.equals(p.lastName) && customers.get(i).getnssf().equalsIgnoreCase(p.getnssf())) {
				return i;
			}
		}
		return -1;
	}
	public HashMap<String,account> getAccounts() {
		return accounts;
	}
	public int getCustomerCount() {
		return numberOfCustomers;
	}
	public int getAccountCount() {
		return numberOfAccounts;
	}
	public double getTotalDeposits() {
		double sum=0;
		for(account tt : accounts.values()) {
			sum=sum+tt.getBalance();
		}
		return sum;
	}
	public float getCurrentInterestRate() {
		return currentInterestRate;
	}
	
	public void addAccount(account a) {
		accounts.put(a.getAccountNumber(), a);
		numberOfAccounts++;
	}
}
