package banksys;

public class InterestEarnedTransaction extends Transaction{
	private String period;
	public InterestEarnedTransaction(double amount, account sourceAccount,String period) {
		super(amount, sourceAccount);
		this.period=period;
	}
	@Override
	public String getTransactionType() {
		return "Interest";
	}
	public String getPeriod() {
		return period;
	}
	
}
