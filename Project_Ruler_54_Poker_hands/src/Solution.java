import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		int n = Integer.parseInt(num);
		String tempS="", 
		temp1 = "", 
		temp2 = "";
		/*
		for(int i=0;i<=n;i++){
			tempS = scan.nextLine();
			//temp1 = tempS.substring(0,14);
			//temp2 = tempS.substring(15);
		    System.out.println(i + " " + tempS);
			}	*/
		
		for(int i=0;i<n;i++){
			tempS = scan.nextLine();
			temp1 = tempS.substring(0,14);
			temp2 = tempS.substring(15);
			
			PokerHand obj1 = new PokerHand(temp1);
			PokerHand obj2 = new PokerHand(temp2);
			if(obj1.compareTo(obj2) == 1){
				System.out.println("Player1");
			}else{
				System.out.println("Player2");
			}			
		}
	}
}
