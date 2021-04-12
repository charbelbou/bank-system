package banksys;

public class CashDepositTransaction extends Transaction{

	public CashDepositTransaction(double amount, account sourceAccount) {
		super(amount, sourceAccount);
	}

	@Override
	public String getTransactionType() {
		return "Deposit";
	}
	

}
