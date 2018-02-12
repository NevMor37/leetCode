import java.util.EnumSet;

public enum tuna {
	
     Bucky ("nice", "22"),
	 Kelsey("cutie", "10"),
	 Julia("bigmistake","12"),
	 Nicole("Italian", "13"),
	 Candy("different","14"),
	 Erin("iwish","16");
	
	 private final String desc;
	 private final String year;
	 
	tuna (String description, String birthday){
		desc = description;
		year = birthday;
	} 
	public String getDesc(){
		return desc;
	}
	public String getYear(){
		return year;
	}
	public static void main(String [] args){
		//enum.values is a built in array to store enums in.
		for(tuna people : tuna.values()){
			System.out.printf("%s \t %s \t %s \n", people, people.getDesc(), people.getYear());
		}
		System.out.println("\nAnd now for the range of a numeration");
		
		for(tuna people : EnumSet.range(tuna.Kelsey, tuna.Candy)){
			System.out.printf("%s \t %s \t %s \n", people, people.getDesc(), people.getYear());
		}
		System.out.println("\n"+tuna.Bucky.getDesc());
	}
}
