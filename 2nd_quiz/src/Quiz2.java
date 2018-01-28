import java.util.Scanner;

public class Quiz2 {
	public boolean checkL(String Ref) {
		if (Ref.length() >= 3) {
			if (Ref.charAt(0) == 'A' && Ref.charAt(1) == 'A' && Ref.charAt(Ref.length() - 1) == 'B') {
				String newRef = Ref.substring(2, Ref.length() - 1);
				return checkL(newRef);
			} else {
				return false;
			}
		}
		if (Ref.length() == 0) {
			return true;
		} else {

			return false;
		}
	}

	public static void main(String[] args) {
		Quiz2 t = new Quiz2();
		String ack;
		do{
		  System.out.println("please input a String");
          Scanner sc = new Scanner(System.in);
          String test = sc.nextLine();
          System.out.println(t.checkL(test));
          System.out.println("Do you wish to continue? Type yes or no");
          ack = sc.nextLine();
	      }while(ack.equals("yes"));
	}
}
