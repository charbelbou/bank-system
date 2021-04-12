package banksys;

public class AccountTransferTransaction extends Transaction {
	public AccountTransferTransaction(double amount,account sourceAccount,account destinationAccount) {
		super(amount,sourceAccount);
		this.destinationAccount=destinationAccount;
	}

	public account getDestinationAccount() {
		return destinationAccount;
	}
	@Override
	public String getTransactionType() {
		return "Account Transfer";
	}
	@Override
	public String toString() {
		return super.toString() +"\t Destination Account: "+destinationAccount.accountNumber;
	}
	private account destinationAccount;
	

}
