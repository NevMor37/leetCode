
public class LinkList {
     public Link firstLink;
     LinkList(){
    	 firstLink = null;
     }
     public boolean isEmpty(){
    	 return (firstLink ==null);
     }
     public void insertFirstLink(String  bookName, int millionsSold){
    	  Link newLink = new Link(bookName, millionsSold);
    	  newLink.next = firstLink;
    	  firstLink = newLink; 
     }
     public Link removeFirst(){
    	 Link theLink = firstLink;
    	 if(!isEmpty()){
    		 firstLink = firstLink.next;
    	 }else{
    		 System.out.println("Can't remove, empty link list");
    	 }
    	 return theLink;
     }
     public void display(){
    	 Link theLink = firstLink;
    	 while(theLink != null){
    		 theLink.display();
    		 //System.out.println("Next Link: " + theLink.next);
    		 theLink = theLink.next;
    	 }
     }
     public Link find(String bookName){
    	Link theLink = firstLink;
    	if(!isEmpty()){
    		while(theLink.bookName!=bookName){
    			if(theLink.next ==null)
    			{
    				return null;
    			}else{
    			   theLink = theLink.next;
    			}   			
    		}
    	}else{
    		System.out.println("Empty link list");
    	}
    	return theLink;
     }
     public Link removeLink(String bookName){
    	 Link currentLink = firstLink;
    	 Link previousLink = firstLink;
    	 while(currentLink.bookName != bookName){
    		  if (currentLink.next == null){
    			  System.out.println("There is no match");
    			  return null;
    		  }
    		  else{
    			  previousLink = currentLink;
    			  currentLink = currentLink.next;
    		  }
    	 }
    	 if(currentLink == firstLink){
    		 firstLink = firstLink.next;
    	 }else{
    	 previousLink.next = currentLink.next;}
    	 return currentLink;
     }
     public static void main(String [] args){
    	 LinkList obj = new LinkList();
    	 obj.insertFirstLink("DS",500);
    	 obj.insertFirstLink("DS1",600);
    	 obj.insertFirstLink("DS2",700);
    	 obj.insertFirstLink("DS3",800);
    	 obj.insertFirstLink("DS4",900);
    	 //obj.display();
    	 obj.removeFirst();
    	 obj.removeLink("DS");
    	 System.out.println(obj.find("DS2").bookName);
    	 obj.display(); 
     }
}
