package banksys;

public class CheckingAccount extends account implements Withdraw{
	public CheckingAccount(double initialBalance, Customer customer,bank bank){
		super(initialBalance,customer,bank);

	}
	public void writeCheck(double amount,int checkNumber) {
		this.decreaseBalance(amount);
		Transaction temp=new CheckTransaction(amount,this,checkNumber);
		super.addTransaction(temp);
	}
	@Override
	public String toString() {
		return super.toString();
	}
	public String getNewAccountNumber() {
		return "CHK-";

	}
	public String getAccountType() {
		return "Checking Account";
	}
	@Override
	public void withdraw(double amount) {
		this.decreaseBalance(amount);
		Transaction temp=new CashWithdrawalTransaction(amount,this);
		super.addTransaction(temp);
	}
}
