package banksys;

public interface InterestBearing {
	void accureMonthlyInterest(String period);
	void setInterestRate(float interestRate);
	float getInterestRate();
}
