import java.util.*;
public class Solution {
public String[] findWords(String[] words) {
	Hashtable <Character, Integer> ab = new Hashtable<Character, Integer>();
	ab.put('q', 1);
	ab.put('w', 1);
	ab.put('e', 1);
	ab.put('r', 1);
	ab.put('t', 1);
	ab.put('y', 1);
	ab.put('u', 1);
	ab.put('i', 1);
	ab.put('o', 1);
	ab.put('p', 1);
	ab.put('a', 2);
	ab.put('s', 2);
	ab.put('d', 2);
	ab.put('f', 2);
	ab.put('g', 2);
	ab.put('h', 2);
	ab.put('j', 2);
	ab.put('k', 2);
	ab.put('l', 2);
	ab.put('z', 3);
	ab.put('x', 3);
	ab.put('c', 3);
	ab.put('v', 3);
	ab.put('b', 3);
	ab.put('n', 3);
	ab.put('m', 3);
	List<String> res = new LinkedList<>();
        for(int i=0; i<words.length; i++){
        	
        	boolean check = true;
        	String temp = words[i].toLowerCase();
        	int ini =ab.get(temp.charAt(0));
        	for(int j=0;j<temp.length(); j++){
        		if(ab.get(temp.charAt(j)) != ini){
        			check = false;
        			break;
        		}
        	}
        	if(check == true){
        		res.add(words[i]);
        	}
        }
        return res.toArray(new String[0]);
    }
     public static void main(String [] args){
    	 String [] test = new String [] {"Hello", "Alaska", "Dad", "Peace"};
    	 Solution obj = new Solution();
    	 obj.findWords(test);
    	 
    	 for(String element : obj.findWords(test)){
    		 System.out.println(element);
    	 }
     }
}
