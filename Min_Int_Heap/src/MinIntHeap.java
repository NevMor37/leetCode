import java.util.Arrays;

public class MinIntHeap {
     private int capacity = 10;
     private int size = 0;
     int [] items = new int [capacity];
     
     private int getLeftChildIndex(int parentIndex){ return 2 * parentIndex +1;}
     private int getRightChildIndex(int parentIndex){ return 2 * parentIndex +2;}
     private int getParentIndex(int childIndex){return (childIndex -1)/2;}
     
     private boolean hasLeftChild(int index){return getLeftChildIndex(index) < size;}
     private boolean hasRightChild(int index){return getRightChildIndex(index) < size;}
     private boolean hasParent(int index){return index > 0; }
     
     private int leftChild(int index){return items[getLeftChildIndex(index)];}
     private int rightChild(int index){return items[getRightChildIndex(index)];}
     private int parent(int index){return items[getParentIndex(index)];}
     
	private void swap(int f, int l) {
		int temp = items[f];
		items[f] = items[l];
		items[l] = temp;
	}

	private void ensureExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
		}
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		return items[0];
	}

	public int poll() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}
	
	public void add(int item){
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	public void heapifyUp(){
		 int index = size-1;
		 while(hasParent(index) && parent(index) > items[index]){
			 swap(getParentIndex(index), index);
			 index = getParentIndex(index);
		 }
	}
	
	public void heapifyDown(){
		 int index = 0;
		 while(hasLeftChild(index)){
			   int smallerChildIndex = getLeftChildIndex(index);
			   if(hasRightChild(index)){
				    if(rightChild(index) < smallerChildIndex){
				    	smallerChildIndex = getRightChildIndex(index);
				    }
			   }
			   if(items[index] > items[smallerChildIndex]){
				   swap(smallerChildIndex, index);
			   }else{
				   break;
			   }
		 }
	}
	public static void main(String [] args){
		MinIntHeap obj = new MinIntHeap();
		obj.add(25);
		obj.add(20);
		obj.add(10);
		obj.add(15);
		obj.add(17);
		//System.out.println(obj.poll());
		System.out.println(obj.peek());
		obj.add(8);
		System.out.println(obj.peek());
	}
}
