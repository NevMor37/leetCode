import java.util.*;

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 1 || prerequisites.length == 0 || prerequisites == null) {
			return true;
		}
		List<List<Integer>> courseList = new ArrayList<>(numCourses);
		for(int i=0; i<numCourses; i++) {
	        courseList.add(new ArrayList<Integer>());
	    }
		for (int i = 0; i < prerequisites.length; i++) {
			courseList.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		int[] checkVisited = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(i, checkVisited, courseList))
				return false;
		}
		return true;
	}

	public boolean dfs(int course, int[] checkVisited, List<List<Integer>> courseList) {
		checkVisited[course] = 1; // mark it as being visiting
		List<Integer> eligibleCourses = courseList.get(course);
		for (int i = 0; i < eligibleCourses.size(); i++) {
			if (checkVisited[eligibleCourses.get(i).intValue()] == 1) {
				return false;
			}else if (checkVisited[eligibleCourses.get(i).intValue()] == 0) {
				if (!dfs(eligibleCourses.get(i), checkVisited, courseList)) {
					return false;
				}
			}
		}
		checkVisited[course] = 2;
		return true;
	}

	public static void main(String[] args) {

	}
}
