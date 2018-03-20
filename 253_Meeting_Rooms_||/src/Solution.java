import java.util.Arrays;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

  
public class Solution { 
	public int minMeetingRooms(Interval[] intervals){
		 int ans = 0;
		 int [] starts = new int [intervals.length];
		 int [] ends = new int [intervals.length];
		 for(int i=0;i<intervals.length;i++){
			 starts[i] = intervals[i].start;
			 ends[i] = intervals[i].end;
		 }
		 Arrays.sort(starts);
		 Arrays.sort(ends);
		 int pointer = 0;
		 for(int i=0;i<intervals.length;i++){
			  if(starts[i] < ends[pointer]){
				  ans++;
			  }else{
				  pointer++;
			  }
		 }
		 return ans;
	}
}
