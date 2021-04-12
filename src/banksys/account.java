package banksys;
import java.util.HashMap; // import the HashMap class
import java.util.Map;


abstract public class account {
	public String accountNumber;
	private HashMap<String,Transaction> transactions;
	private double balance;
	private int transactionCount;
	private Customer customer;
	private bank bank;
	public static int lastAccountNumber;
	private account() {
		this.accountNumber=Integer.toString(++lastAccountNumber);
		this.accountNumber=getNewAccountNumber()+"00000"+accountNumber;
        transactions = new HashMap<String,Transaction>(); 

	}
	public account(double initialBalance,Customer customer,bank bank) {
		this.customer=customer;
		this.bank=bank;
		this.accountNumber=Integer.toString(++lastAccountNumber);
		this.accountNumber=getNewAccountNumber()+"00000"+accountNumber;
		transactionCount=0;
        transactions = new HashMap<String,Transaction>(); 
		this.Deposit(initialBalance);
		bank.addAccount(this);
		if(!bank.customerExists(customer)) {
			bank.addCustomer1(customer);
		}
		bank.getCustomers().get(bank.getIndex(customer)).addAccount(this);

		
	}
	
	public HashMap<String,Transaction> getTransactions() {
		return transactions;
	}
	double getBalance() {
		return balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String toString() {
		String temp="";
		for(Transaction tt : transactions.values()) {
			temp=temp+"\t\t\t\t"+tt.toString()+"\n";
		}
		return getAccountType()+ "|"+accountNumber +"\t|$"+balance+"\n"+"\t\t\tTransactions: \n"+temp;
	}
	public void increaseBalance(double amount) {
		balance=balance+amount;
	}
	public void decreaseBalance(double amount) {
		balance=balance-amount;
	}
	public bank getBank() {
		return bank;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void addTransaction(Transaction transaction1) {
		transactions.put(transaction1.getTransactionNumber(), transaction1);
		transactionCount++;
	}
	public int getTransactionCount() {
		return transactionCount;
	}
	public void transferTo(account toAccount, double amount) {
		toAccount.increaseBalance(amount);
		this.decreaseBalance(amount);
		Transaction temp=new AccountTransferTransaction(amount,this,toAccount);
		this.addTransaction(temp);
		toAccount.addTransaction(temp);
	}
	public void Deposit(double amount) {
		this.increaseBalance(amount);
		Transaction temp= new CashDepositTransaction(amount,this);
		this.addTransaction(temp);
	}
	public abstract String getAccountType();
	public abstract String getNewAccountNumber();
}

