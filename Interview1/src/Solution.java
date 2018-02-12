class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int res = 0;
        int i=0;
        while(A[i] != -1){
            res++;
            i = A[i];
        }
        return res+1;
        
    }
    public static void main(String [] args){
    	Solution obj = new Solution();
    	int []test = new int[]{1, 4, -1, 3, 2};
    	System.out.println(obj.solution(test));
    }
}