//Given a collection of intervals, merge all overlapping intervals.
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
          List <Interval> ans = new ArrayList<>();
          if(intervals.size()<=1) return intervals;
          Collections.sort(intervals, (a, b) ->a.start - b.start);
          int start = intervals.get(0).start;
          int end = intervals.get(0).end;
          for(Interval interval : intervals){
        	   if(interval.start <= end){
        		   end = Math.max(end, interval.end);
        	   }else{
        		   ans.add(new Interval(start, end));
        		   start  =interval.start;
        		   end = interval.end;
        	   }
          }
          ans.add(new Interval(start, end));
          return ans;
	}
	public static void main(String [] args){
		 List<Interval> test = new ArrayList<>();
		 Interval a = new Interval(1, 3);
		 Interval b = new Interval(2, 6);
		 Interval c = new Interval(8, 10);
		 Interval d = new Interval(15, 18);
		 test.add(a);
		 test.add(b);
		 test.add(c);
		 test.add(d);
		 Solution obj = new Solution();
		 List<Interval> ansTest = obj.merge(test);
		 for(int i=0;i<ansTest.size();i++){
			 System.out.println(ansTest.get(i).start + " " + ansTest.get(i).end);
		 }
	}
}
