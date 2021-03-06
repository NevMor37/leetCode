//You are given an n x n 2D matrix representing an image.
//
//Rotate the image by 90 degrees (clockwise).
//
//Note:
//You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
//DO NOT allocate another 2D matrix and do the rotation.

//解法为先以左上右下对角线交换元素，再以中轴交换元素
public class Solution {
//	public void rotate(int[][] matrix) {
//			for(int i=0;i<matrix.length;i++){
//				for(int j=i;j<matrix[0].length;j++){
//					   int temp = matrix[i][j];
//					   matrix[i][j] = matrix[j][i];	
//					   matrix[j][i] = temp;
//				}
//			}
//			for(int i = 0;i < matrix.length;i++){
//				 for(int j=0; j<matrix[0].length/2;j++){
//					   int temp = matrix[i][j];
//					   matrix[i][j] = matrix[i][matrix.length-1-j];	
//					   matrix[i][matrix.length-1-j] = temp;
//				 }
//			}
//			for(int i = 0;i < matrix.length;i++){
//				 for(int j=0; j<matrix[0].length;j++){
//					 System.out.printf("%d ", matrix[i][j]);
//				 }
//				 System.out.println();
//			}
//	}
	public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return;
        int top = 0, left = 0, right = matrix[0].length-1, bot = matrix.length-1;
        int count = matrix.length;
        while(count > 1) {
        	for(int i= 0; i< count-1;i++) {
        		int temp = matrix[top][left+i];
        		matrix[top][left+i] = matrix[bot-i][left];
        		matrix[bot-i][left] = matrix[bot][right-i];
        		matrix[bot][right-i] = matrix[top+i][right];
        		matrix[top+i][right] = temp;
        	}
        	count -= 2;
        	top +=1;
        	left+=1;
        	right-=1;
        	bot-=1;
        }
        for(int i = 0;i < matrix.length;i++){
			 for(int j=0; j<matrix[0].length;j++){
				 System.out.printf("%d ", matrix[i][j]);
			 }
			 System.out.println();
		}
        
    }
	public static void main(String [] args){
		  int [][]test1 = new int [][]{
			   {1,2,3},
			   {4,5,6},
			   {7,8,9}
		  };
		  int [][]test2 = new int [][]{
			   {1,2,3,4},
			   {5,6,7,8},
			   {9,10,11,12},
			   {13,14,15,16}
		  };
		  Solution obj = new Solution();
		  obj.rotate(test1);
		  obj.rotate(test2);
	} 
}
