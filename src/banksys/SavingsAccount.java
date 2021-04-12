package banksys;

public class SavingsAccount extends account implements Withdraw{

	public SavingsAccount(float initialBalance,Customer customer,bank bank) {
		super(initialBalance, customer, bank);
		this.interestRate=bank.r;


	}
	
	public String getAccountType() {
		return "Savings Account";
	}
	public String getNewAccountNumber() {
		return "SAV-";

	}
	public void setInterestRate(float interestRate) {
		this.interestRate=interestRate;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void accrueMonthlyInterest(String period) {
		double temp=getBalance()*interestRate;
		this.increaseBalance(temp);
		Transaction t=new InterestEarnedTransaction(temp,this,period);
		this.addTransaction(t);
	}
	
	private float interestRate;

	@Override
	public void withdraw(double amount) {
		this.decreaseBalance(amount);
		Transaction temp=new CashWithdrawalTransaction(amount,this);
		super.addTransaction(temp);
	}
	
}
