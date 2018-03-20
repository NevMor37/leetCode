import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Graph objGraph = new Graph();
		
		//objGraph.generateGraph("nsf_14_node_tplgy.txt", 15, 40, 5, 25, "nsf14nodev1.txt");
		
		ArrayList<Integer> llist = new ArrayList<Integer>();
		
		for(int i =0; i<5;i++)
			llist.add(i);
		
		System.out.print(Arrays.toString(llist.toArray()));
		
		Collections.shuffle(llist);
		
		System.out.print(Arrays.toString(llist.toArray()));
		
	}

}
