
public class node {
      String name;
      int age;
      node next;
      public node(String name, int age){
    	    this.name = name;
    	    this.age = age;
      }      
      public void display(){
    	  System.out.println(name+" "+age);
      }
}
