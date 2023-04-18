public class RetirementCalculator {
	int monthlyDeposit;
	double annualInterestRate;
	int startingYear;
	double targetSavings;

	public RetirementCalculator(int mD, double aIR, int sY, double tS) {
		monthlyDeposit = mD;
		annualInterestRate = aIR;
		startingYear = sY;
		targetSavings = tS;
	}

	public double getSavings(int year) {
		double savings = 0;
		for (int i = 0; i < (year - startingYear); i++) {
        	savings += monthlyDeposit * 12;
        	savings *= 1 + annualInterestRate;
    	}
		return savings;
	}

	public boolean canRetire(int year) {
		return getSavings(year) >= targetSavings;
	}
	
	public String toString() {
		int retirementYear = startingYear;
		while (!canRetire(retirementYear++)) {} // short but powerful!
		return "You are depositing $" + monthlyDeposit + " per month into an account that will be compounded annually at a " + annualInterestRate + "% annual interest rate. Since you started in " + startingYear + ", you will be able to retire in "+ retirementYear + " with $" + targetSavings + " in your account.";
	}
}
