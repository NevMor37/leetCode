import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		// reading from a file
		Scanner fileReader = new Scanner(new File("InternetCompanies.csv"));
		// skip header from input
		fileReader.nextLine();
		// print output header
		System.out.println("Company, Country, PSR, Rounded PSR");
		while (fileReader.hasNextLine()) {
			// read line by line
			String line = fileReader.nextLine();
			// parse line to individual columns
			String company = Parser.parseCompany(line);
			String country = Parser.parseCountry(line);
			double marketCap = Parser.parseMarketCap(line);
			double revenue = Parser.parseRevenue(line);
			// calculate PSR
			double psr = FinancialCalculator.PSR(marketCap, revenue);
			double roundedPsr = FinancialCalculator.roundedPSR(marketCap, revenue,
			true);
			// display results 加入判断语句，如果没有psr值就输出NaN
			if(psr != 0){
			System.out.println(company + ", " + country + ", " + psr + ", "
			+ roundedPsr );
			}else{
				System.out.println(company + ", " + country + ", " + "NaN" + ", "
						+"NaN");
			}
		}
	}
}