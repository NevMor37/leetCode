
public class Solution {
	/*
	 // Brute force algorithm
	public int countPrimes(int n) {
		     if(n<=2) return 0;
		     if(n == 3){return 1;}
             int count = 1;
             
             for(int i=3;i<n;i++){
            	   boolean check = true;
            	   for(int j=2;j<=Math.sqrt(i);j++){
            		    if(i % j == 0){
            		    	check = false;
            		    } 
            	   }
            	   if(check == true) {count++;}
             }
             //System.out.println(count);
             return count;
	}
*/
	//艾拉托斯特尼算法
	public int countPrimes(int n) {
		    if(n < 3) return 0;
            int count = 0;
            boolean []list = new boolean [n];
            for(int i=0;i<n;i++){
            	list[i] = true;
            }
            list[0] = false;
            list[1] = false;
            
            for(int i = 2; i <= Math.sqrt(n);i++){
            	  if(!list[i]) continue;
            	  for(int j = i*i; j<n;j=j+i){
            		    list[j] = false;
            	  }
            }
            
            for(boolean i : list){
            	count += (i == true) ? 1 : 0;
            	//System.out.println(i);
            }
            return count;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		boolean []list = new boolean [10];
		System.out.println(obj.countPrimes(4));
		// System.out.println(Math.sqrt(3));
	}
}
