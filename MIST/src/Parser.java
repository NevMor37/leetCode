public class Parser {

	public static String Company;
	public static String Country;
	public static double MarketCap;
	public static double Revenue;

	public static String parseCompany(String line) {
        String [] dataArray = line.split(",");
        return dataArray[0];
        //返回第一个数据， 字符串
	}

	public static String parseCountry(String line) {
		String [] dataArray = line.split(",");
        return dataArray[1];
        //返回第二个数据 字符串
	}

	public static double parseMarketCap(String line) {
		String [] dataArray = line.split(",");
		String bf = dataArray[2];
		bf = bf.replaceAll("\\$","");
		MarketCap = Double.parseDouble(bf);
		return MarketCap;
		//返回第三个数据 去除$后转化为double
	}

	public static double parseRevenue(String line) {
		String [] dataArray = line.split(",");
		String bf = dataArray[4];
		bf = bf.replaceAll("\\$","");
		Revenue = Double.parseDouble(bf);
		return Revenue;
		// 返回第四个数据， 去除$后转化为double
	}
}