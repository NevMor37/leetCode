
public class tuna {
    private String first;
    private String last;
    private static int members = 0;
    public tuna(String fn, String ln){
    	first = fn;
    	last =ln;
    	members ++;
    	System.out.printf("Constructor for %s %s, members in the club %d\n", first, last, members);
    }
    public String getFirst(){
    	return first;
    }
    public String getLast(){
    	return last;
    }
    public static void main(String [] args){
    	tuna member1 = new tuna("Megan", "Fox");
    	tuna member2 = new tuna("Natalie", "Portman");
    	tuna member3 = new tuna("Taylor", "Swift");
    	//System.out.println(member1.members);
    	System.out.println();
    	System.out.println(member1.getFirst());
    	System.out.println(member1.getLast());
    	System.out.println(member1.members);
    	
    	System.out.println();
    	System.out.println(tuna.members);// use class name.staticElement/staticMethods
    	
    	finalP test = new finalP(10);
    	test.add();
    	test.add();
    	test.add();
    	test.add();
    	test.add();
    	System.out.println(test.toString());
    	
    	child obj = new child();
    	obj.eat();
    	obj.eats();
    }
}
