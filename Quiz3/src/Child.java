
public class Child extends Mother{
	 public int ValueC;
	 public int ValueD;
	 public Child(int a, int b, int c, int d){
		 this.ValueC = c;
		 this.ValueD = d;
		 super.ValueA = a;
		 super.ValueB = b;
	 }
	 public Child(int c, int d){
		 this.ValueC = c;
		 this.ValueD = d;	 
	 }
	 public int getterC(){
	    	return ValueC;
	    }
	    public int getterD(){
	    	return ValueD;
	    }
	    public void setterC(int c){
	    	this.ValueC = c;
	    }
	    public void setterB(int d){
	    	this.ValueD = d;
	    }
	    public int Add(int x, int y, int z){
	    	return x*y-z;
	    }
}
