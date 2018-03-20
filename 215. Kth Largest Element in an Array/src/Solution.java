import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
	public int findKthLargest(int[] nums, int k) {
           PriorityQueue<Integer> minHeap = new PriorityQueue<>();
           for(int num : nums){
        	   if(minHeap.size() < k || num > minHeap.peek()){
        		      minHeap.offer(num);
        		      if(minHeap.size() > k){
        		    	  minHeap.poll();
        		      }
        	   }
           }
           return minHeap.poll();
	}
	public static void main(String [] args){
		
	}
}
