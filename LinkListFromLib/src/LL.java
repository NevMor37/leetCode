import java.util.*;
public class LL {
     public static void main(String [] args){
    	   String [] things = {"apples","noobs","pwnge","bacon","goats"};
    	   List<String> list1 = new LinkedList<String>();
    	   for(String x:things)
    		    list1.add(x);
    	   String [] things2 = {"sausage","bacon","goats","hotpot"};
    	   List<String> list2 = new LinkedList<String>();
    	   for(String x:things2)
    		    list2.add(x);
    	   list1.addAll(list2);
    	   list2 = null;
    	   printMe(list1);
    	   System.out.println();
    	   removeStuff(list1,2,5);
    	   printMe(list1);
    	   System.out.println();
    	   reverseMe(list1);
    	   System.out.println();
    	   
    	   
    	   String [] stuff = {"babies","watermelong","melons","fudge"};
    	   //take the array and treat it as a list
    	   LinkedList<String> theList = new LinkedList<String>(Arrays.asList(stuff));
    	   theList.add("pumpkinf");
    	   theList.addFirst("firstthing");
    	   stuff = theList.toArray(new String[theList.size()]);
    	   for(String x:stuff)
    		   System.out.printf("%s ", x);
    	   
    	   
     }
     private static void printMe(List<String> l){
    	    for(String b:l)
    	    	System.out.printf("%s ",b);
     }
     private static void removeStuff(List<String> l,int from, int to){
    	   l.subList(from, to).clear();//java build-in method
     }
     private static void reverseMe(List<String> l){
    	  ListIterator<String> i= l.listIterator(l.size());//add ending point for the reverse operation
    	  while(i.hasPrevious())
    		  System.out.printf("%s ",i.previous());
    		  
     }
}
