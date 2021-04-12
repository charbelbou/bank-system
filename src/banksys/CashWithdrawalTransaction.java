package banksys;

public class CashWithdrawalTransaction extends Transaction {
	public CashWithdrawalTransaction(double amount, account sourceAccount) {
		super(amount, sourceAccount);
	}

	@Override
	public String getTransactionType() {
		return "Withdrawal";
	}
}