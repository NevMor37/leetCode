
public class Mother {
    public int ValueA;
    public int ValueB;
    public Mother(){
    	this.ValueA = this.ValueB = 1;
    }
    public Mother(int a, int b){
    	this.ValueA = a;
    	this.ValueB = b;
    }
    public int getterA(){
    	return ValueA;
    }
    public int getterB(){
    	return ValueB;
    }
    public void setterA(int a){
    	this.ValueA = a;
    }
    public void setterB(int b){
    	this.ValueB = b;
    }
    public int Add(int x, int y, int z){
    	return x*y+z;
    }
}
