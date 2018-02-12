
public class finalP {
    private int sum;
    private final int NUMBER;//The number can only be set once
    
    public finalP(int x){
    	NUMBER = x;
    }
    public void add(){
    	sum+= NUMBER;
    }
    public String toString(){
    	return String.format("sum = %d \n", sum);
    }
}
