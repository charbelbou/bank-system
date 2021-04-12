package banksys;
import java.lang.NullPointerException;
import java.util.HashMap;
import java.util.Map;

public class Customer extends person{
	private String customerNumber;
	private static int lastCustomerNumber;
	private HashMap<String,account> accounts;
	private String nssf;
	private int numberOfAccounts;
	
	public Customer(String firstName,String lastName,String nssf) {
		super(firstName,lastName);
		this.nssf=nssf;
        accounts = new HashMap<String,account>(); 

	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public String getnssf() {
		return nssf;
	}
	public HashMap<String,account> getAccounts() {
		return accounts;
	}
	public double getNetWorth() {
		double sum=0;
		for(account tt : accounts.values()) {
			sum=sum+tt.getBalance();
		}
		return sum;
	}
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	public void addAccount(account a) {
		accounts.put(a.getAccountNumber(), a);
		numberOfAccounts++;
	}
	public account openAccount(AccountTypeEnum accountType, double initialBalance,bank bank){
		if(accountType==AccountTypeEnum.Checking) {
			account p=new CheckingAccount(initialBalance,this,bank);
			return p;
		}
		else if(accountType==AccountTypeEnum.Retirement) {
			account p=new RetirementAccount((float) initialBalance,this,bank);
			return p;
		}
		else if(accountType==AccountTypeEnum.Savings) {
			account p=new SavingsAccount((float) initialBalance,this,bank);
			return p;
		}
		else return null;

	}
	public String toString() {
		String temp="";
		for(account tt : accounts.values()) {
			temp=temp+tt.toString()+"\t";
		}
		return "***" +firstName+" "+lastName+ "***\n\tCustomer Accounts:\n\t\t"+temp;
	}
	public static void main(String[] args) {
	//	bank audi=new bank("audi");
/*		audi.addCustomer("Charbel", "Bou Malhab", "2131");
		audi.getCustomers()[0].openAccount(AccountTypeEnum.Retirement, 30, audi);
		audi.getCustomers()[0].openAccount(AccountTypeEnum.Checking, 50, audi);
		audi.getCustomers()[0].openAccount(AccountTypeEnum.Savings, 10, audi);
		

		for(int i=0;i<audi.getAccountCount();i++) {
			audi.getAccounts()[i].toString();
		}
		audi.getCustomers()[0].toString();*/
/*		Customer p=new Customer("Charbel","Bou Malhab","444");
		CheckingAccount q=new CheckingAccount(1231,p,audi);
		SavingsAccount w=new SavingsAccount(13,p,audi);
		w.withdraw(40);
		q.transferTo(w, 23);
		w.transferTo(q, 23);
		q.writeCheck(23, 1);*/
		
	//	System.out.println(audi.toString());

	//	Transaction temp=new CashWithdrawalTransaction(30,q);
	//	Transaction temp1=new CheckTransaction(30,q,242);
	//	System.out.println(p.toString()+"\n");
	//	System.out.println(w.getTransactionCount());
	//	System.out.println(audi.toString());
	//	audi.addAccount(q);
		bank b = new bank("New Bank of Lebanon");
        
        b.addCustomer("Joe", "Smith", "1234");
        b.addCustomer("Jane", "Jones", "4567");
        b.addCustomer("Mark","Williams","5345");
        
        Customer c1 = b.getCustomers().get(0);
        Customer c2 = b.getCustomers().get(1);
        Customer c3=b.getCustomers().get(2);
        
        
        c1.openAccount(AccountTypeEnum.Checking, 100, b);
        c1.openAccount(AccountTypeEnum.Savings, 1020.34, b);
        
        c2.openAccount(AccountTypeEnum.Checking, 1030.30, b);
        c2.openAccount(AccountTypeEnum.Savings, 34020.43, b);
        c2.openAccount(AccountTypeEnum.Retirement, 27602.43, b);
        
        CheckingAccount a1c1 = (CheckingAccount) c1.getAccounts().get("CHK-000001");
        SavingsAccount a2c1 = (SavingsAccount) c1.getAccounts().get("SAV-000002");

        
        a1c1.withdraw(23.5);
        a1c1.writeCheck(12.11, 101);
        a2c1.accrueMonthlyInterest("March 2020");
        
        CheckingAccount a1c2 = (CheckingAccount) c2.getAccounts().get("CHK-000003");
        SavingsAccount a2c2 = (SavingsAccount) c2.getAccounts().get("SAV-000004");
        CheckingAccount a1c3=new CheckingAccount(25,c3,b);

        
        a2c2.transferTo(a1c2, 5000);
        

        System.out.println(b.toString());
	}
}
