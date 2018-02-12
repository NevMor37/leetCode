
public class Node {
    int key;
    String name;
    Node leftchild;
    Node rightchild;
    
    public Node (int key, String name){
    	this.key = key;
    	this.name = name;
    	this.leftchild = null;
    	this.rightchild = null;
    }
   public String toString(){
	   return name + "has a key of" + key;
   }
    
}
