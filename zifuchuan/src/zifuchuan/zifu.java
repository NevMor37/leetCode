package zifuchuan;
import java.util.*;
public class zifu {
   public static void main(String args[]){
	     Scanner sc = new Scanner(System.in);
	     String line = sc.nextLine();
	     System.out.println(line);
	     //AA+DD+CC+
	     String [] t = new String [100];
	     int x=0;
	     for(int i=0;i<=line.length()-1;){
	    	 if((line.charAt(i+1) != '+') && (line.charAt(i+1) != '-')){
	    		   t[x] = line.substring(i,i+1);
	    		   i=i+1;
	    		   x++;
	    	 }else{
	    		 t[x] = line.substring(i,i+2);
	    		 i=i+2;
	    		 x++;
	    	 }
	     }
	     for(int i=0;i<x;i++){
	    	 System.out.println(t[x]);
	     }
   }
}
