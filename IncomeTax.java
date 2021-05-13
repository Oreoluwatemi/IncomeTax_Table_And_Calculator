
package Project2;

public class IncomeTax {
	// Initializing the variables
	public final int SINGLE_FILER = 0;
	public final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER = 1;
	public final int MARRIED_SEPARATELY = 2;
	public final int HEAD_OF_HOUSEHOLD = 3;
	private int filingStatus;
	private double taxableIncome;

	// storing maximum amount of 2001 tax table to determine how much rate is to
	// applied on the taxable income
	int[][] interval = { { 27050, 65550, 136750, 297350 }, { 45200, 109250, 166500, 297350 },
			{ 22600, 54625, 83250, 148675 }, { 36250, 93650, 151650, 297350 } };

	// 2001 tax table rates are stored in these array
	double[] rates = { 15, 27.5, 30.5, 35.5, 39.1 };

	// no args-constructor
	public IncomeTax() {
	};

	// constructor with arguments
	public IncomeTax(int filingStatus, int[][] interval, double[] rates, double taxableIncome) {
		this.filingStatus = filingStatus;
		this.interval = interval;
		this.rates = rates;
		this.taxableIncome = taxableIncome;
	};

	// getters and setters
	public int[][] getInterval() {
		return interval;
	}

	public void setInterval(int[][] interval) {
		this.interval = interval;
	}

	public double[] getRates() {
		return rates;
	}

	public void setRates(double[] rates) {
		this.rates = rates;
	}

	public void setStatus(int filingStatus) {
		this.filingStatus = filingStatus;
	}

	public int getStatus() {
		return filingStatus;
	}

	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	public double getTaxableIncome() {
		return taxableIncome;
	}

	// Method getIncomeTax to calculate income tax
	public double getIncomeTax(double taxableIncome, int filingStatus) {
		double incomeLeft = taxableIncome;
		double taxToBeCharged = 0;
		double incomeCalculated = 0;
		for (int i = rates.length - 2; i >= 0; i--) {
			if (incomeLeft > interval[filingStatus][i]) {
				taxToBeCharged += (incomeCalculated = incomeLeft - interval[filingStatus][i]) * rates[i + 1];
				incomeLeft = incomeLeft - incomeCalculated;
			}
		}
		taxToBeCharged += interval[filingStatus][0] * rates[0];
		return taxToBeCharged / 100;
	}

	// logic behind writing the above loop

	/*
	 * For example income tax is 20000 20000 - 8350 = 11650 8350 * 0.10 = 835 11650
	 * * 0.15 = 1747.5 835 + 1747.5 = 2582.5
	 * 
	 * if (income <= 8350) tax = income * 0.10; else if (income <= 33950) tax = 8350
	 * * 0.10 + (income - 8350) * 0.15; else if (income <= 82250) tax = 8350 * 0.10
	 * + (33950 - 8350) * 0.15 + (income - 33950) * 0.25; else if (income <= 171550)
	 * tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (income
	 * - 82250) * 0.28; else if (income <= 372950) tax = 8350 * 0.10 + (33950 -
	 * 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (income -
	 * 171550) * 0.33; else tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 -
	 * 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (income
	 * - 372950) * 0.35;
	 */
}
