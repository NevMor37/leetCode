
public class namelist {
 node firstnode;
 public namelist(){
	 firstnode = null;
 }
 public boolean Empty(){
	 return (firstnode == null);
 }
 public void insert(String name, int age){
	  node newNode = new node(name, age);
	  newNode.next = firstnode;
	  firstnode = newNode;
 }
 public node removeFromFirst(){
	   node rNode = firstnode;
	   if(!Empty()){
		   firstnode = firstnode.next;
	   }
	   return rNode;
 }
 public int getCountbyR(node rnode){
	 if(rnode!= null)
		 return 1+getCountbyR(rnode.next);
	 else
		 return 0;
 }
 public int getCountbyI(){
	 node rnode = firstnode;
	 int i=0;
	 while(rnode != null){
		 i++;
		 rnode = rnode.next;;
	 }
	 return i;
 }
 public void display(){
	  node temp = firstnode;
	  if(!Empty()){
	  while(temp!= null){
		    temp.display();
		    temp = temp.next;
	  }
	 }else{
		 System.out.println("Empty link list");
	 }
 }
 public node remove(String name){
	  node pNode = firstnode;
	  node cNode = firstnode;
	  if(!Empty()){
		  while(cNode.name != name){
			  if(cNode.next != null){
			  pNode = cNode;
			  cNode = cNode.next;
			  }else{
				  System.out.println("Can't find the match.");
				  return null;
			  }
		  }
		  if(cNode ==firstnode){
			  firstnode = firstnode.next;
		  }else{
			  pNode.next = cNode.next;
		  }
	  }else{
		  System.out.println("Empty link list");
		  return null;
	  }
	  return cNode;
 }
 public node find(String name){
	  node rNode = firstnode;
	  if(!Empty()){
		  while(rNode.name != name){
			  if(rNode.next == null){
				  System.out.println("There is no match");
				  return null;
			  }
			  rNode = rNode.next;
		  }
	  }else{
		  System.out.println("Empty link list");
	  }
	  return rNode;
 }
    public static void main(String [] args){
    	 namelist obj = new namelist();
    	 obj.insert("Xiaoming", 18);
    	 obj.insert("Xiaohong", 19);
    	 obj.insert("Xiaogang", 20);
    	 obj.insert("Xiaofang", 21);
    	 //obj.display();
    	 //obj.removeFromFirst();
    	 //obj.remove("Xiaohong");
    	 //System.out.println(obj.find("Xiaoming").name);
    	 //obj.display();
    	 System.out.println(obj.getCountbyI());
    	 System.out.println(obj.getCountbyR(obj.firstnode));
    	 
    	 
    }
}
