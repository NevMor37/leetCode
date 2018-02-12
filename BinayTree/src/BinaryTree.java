
public class BinaryTree {
   Node root;
   public void addNode(int key, String name){
	   Node newNode = new Node(key, name);
	   if(root == null){
		   root = newNode;
	   }else{
		   Node focusNode = root;
		   Node parent;
		   while(true){
			   parent = focusNode;
			   if(key < focusNode.key){
				   focusNode = focusNode.leftchild;
				   if(focusNode == null){
					   parent.leftchild = newNode;
					   return;
				   } 
			   }else{
				   focusNode = focusNode.rightchild;
				   if(focusNode == null){
					   parent.rightchild = newNode;
					   return;
				   }
			   }
		   }
	   }
   }
   public void inOrderTraverse(Node focusNode){
	   if(focusNode != null){
		   inOrderTraverse(focusNode.leftchild);
		   System.out.println(focusNode.key);
		   inOrderTraverse(focusNode.rightchild);
	   }
   }
   
   public void preOrderTraverse(Node focusNode){
	   if(focusNode != null){
		   System.out.println(focusNode.key);
		   inOrderTraverse(focusNode.leftchild);
		   inOrderTraverse(focusNode.rightchild);
	   }
   }
   
   public void postOrderTraverse(Node focusNode){
	   if(focusNode != null){
		   inOrderTraverse(focusNode.leftchild);
		   inOrderTraverse(focusNode.rightchild);
		   System.out.println(focusNode.key);
	   }
   }
   
   public Node findNode(int key){
	   Node focusNode = root;
	   while(focusNode.key != key){
		   if(focusNode == null){
			   return null;
		   }else if(focusNode.key < key){
			  focusNode = focusNode.rightchild;
		   }else{
			   focusNode= focusNode.leftchild;
		   }
	   }
	   return focusNode;
   }
   Node deleteRec(Node root, int key){
	   if(root == null){
		   return root;
	   }
	   if(key<root.key){
		   root.leftchild = deleteRec(root.leftchild, key);
	   }else if(key>root.key){
		   root.rightchild = deleteRec(root.rightchild, key);
	   }else{
		   if(root.leftchild == null){
			   return root.rightchild;
		   }else if(root.rightchild == null){
			   return root.leftchild;
		   }
		   
		   root.key = minValue(root.rightchild);
		   root.rightchild = deleteRec(root.rightchild, root.key);
	   }
	   return root;
   }
    public int minValue(Node root){
    	int res = root.key;
           Node refNode;
           refNode = root;
           while(refNode != null){
        	    res = refNode.leftchild.key;
        	    refNode = refNode.leftchild;
           }
           return res;
    }
   public static void main(String [] args){
	   BinaryTree obj = new BinaryTree();
	   obj.addNode(50, "xiaoming");
	   obj.addNode(30, "dashuang");
	   obj.addNode(20, "liqiang");
	   obj.addNode(40, "hehe");
	   obj.addNode(70, "Mike");
	   obj.addNode(60, "Jack");
	   obj.addNode(80, "Shubin");
	   obj.inOrderTraverse(obj.root);
	   obj.deleteRec(obj.root, 50);
   }
}
