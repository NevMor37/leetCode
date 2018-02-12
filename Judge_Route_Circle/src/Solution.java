import java.util.Scanner;
public class Solution {
	  public boolean judgeCircle(String moves){
		  int res1 = 0;
		  int res2 =0;
		  for(int i=0;i<moves.length();i++){
			   if(moves.charAt(i) == 'U'){
				   res1++;
			   }else if(moves.charAt(i) == 'D'){
				   res1--;
			   }else if(moves.charAt(i) == 'L'){
				   res2++;
			   }else if(moves.charAt(i) == 'R'){
				   res2--;
			   }
		  }
		  return (((res1 == 0) && (res2 == 0)) ? true:false);
	  }
	  public static void main(String [] args){
		   Scanner sc= new Scanner(System.in);
		   String test = sc.nextLine();
		   //System.out.println(test);
		   Solution s = new Solution();
		   System.out.println(s.judgeCircle(test));
	  }
}
