package banksys;

public class CheckTransaction extends Transaction{
	private int checkNumber;
	
	public CheckTransaction(double amount, account sourceAccount,int checkNumber) {
		super(amount, sourceAccount);
		this.checkNumber=checkNumber;
	}

	@Override
	public String getTransactionType() {
		return "Check";
	}
	@Override
	public String toString() {
		return 	super.toString() +"\t Check#: "+checkNumber;
	}
}
