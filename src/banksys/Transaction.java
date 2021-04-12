package banksys;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

abstract public class Transaction {
	private LocalDateTime transactionDate;
	private double amount;
	private account sourceAccount;
	private String transactionNumber;
	static private long lastTransactionNumber;
	DecimalFormat temp = new DecimalFormat("0000000000");

	private Transaction() {
		this.transactionDate=java.time.LocalDateTime.now();
		this.transactionNumber=temp.format(++lastTransactionNumber);
	}
	public Transaction(double amount,account sourceAccount) {
		this.transactionDate=java.time.LocalDateTime.now();
		this.amount=amount;
		this.sourceAccount=sourceAccount;
		this.transactionNumber=temp.format(++lastTransactionNumber);
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public account getSourceAccount() {
		return sourceAccount;
	}
	public String toString() {
		return transactionDate +"\t |"+getTransactionType()+"\t\t\t |"+transactionNumber+"| \t $"+ amount;
	}
	public abstract String getTransactionType();
	
}
