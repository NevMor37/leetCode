import java.math.*;

public class FinancialCalculator {
	public static double result;

	public static double PSR(double marketCap, double revenue) {
		if (marketCap != 0 && revenue != 0) {
			result = marketCap / revenue;
		} else {
			result = 0;
		}
		return result;
	}

	public static double roundedPSR(double marketCap, double revenue, boolean c) {
		if (c == true) {
			double res = PSR(marketCap, revenue);
			return Math.round(res * 100.0) / 100.0;
		} else
			return 0;
	}
}
