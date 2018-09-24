import java.util.*;
public class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue <List<Integer>> queue = new LinkedList<> ();
        boolean []checkList = new boolean [rooms.size()]; 
        if(rooms == null || rooms.size() == 0) return false;
        checkList[0]=true;
        queue.offer(rooms.get(0));
        //System.out.println(rooms.get(0));
        while (!queue.isEmpty()) {
            List<Integer> temp = queue.poll();
            for(int i= 0;i<temp.size();i++) {
            	if(!checkList[temp.get(i)]){
            		queue.offer(rooms.get(temp.get(i)));
            		checkList[temp.get(i)] = true;
            	}
            }      
        }
        for(boolean e : checkList) {
        	//System.out.println(e);
            if(!e) {
            	return false;
            } 
        }
        return true;
    }
	public static void main(String [] args) {
		List <List<Integer>> test = new LinkedList<>();
		List <Integer> a = new LinkedList<>();
		List <Integer> b = new LinkedList<>();
		List <Integer> c = new LinkedList<>();
		List <Integer> d = new LinkedList<>();
		a.add(1);
//		a.add(3);
//		b.add(3);
//		b.add(0);
//		b.add(1);
//		c.add(2);
//		d.add(0);
		b.add(2);
		c.add(3);
		test.add(a);
		test.add(b);
		test.add(c);
		test.add(d);
		Solution obj = new Solution();
		obj.canVisitAllRooms(test);
	}
}
