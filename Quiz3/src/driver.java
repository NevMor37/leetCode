public class driver {
    public static void main(String [] args){
    	Child objChild = new Child(1,2,3,4);
    	Mother objMother = new Mother(5,6);
    	System.out.println(objChild.getterA());
    	System.out.println(objChild.getterB());
    	System.out.println(objChild.Add(4, 5, 6));
    	System.out.println(objMother.Add(4, 5, 6));
    }
}
