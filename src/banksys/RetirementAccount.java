package banksys;

public class RetirementAccount extends account{
	private float interestRate;


	public RetirementAccount(float initialBalance,Customer customer,bank bank) {
		super(initialBalance, customer, bank);
		this.interestRate=bank.r;

	}
	@Override
	public String toString() {
		return super.toString();
	}
	public String getAccountType() {
		return "Retirement Account";
	}
	public String getNewAccountNumber() {
		return "RTR-";
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate=interestRate;
	}
	public void accrueMonthlyInterest(String period) {
		double temp=getBalance()*interestRate;
		this.increaseBalance(temp);
		Transaction t=new InterestEarnedTransaction(temp,this,period);
		this.addTransaction(t);
	}
	
}
