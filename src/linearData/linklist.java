package linearData;

public class linklist {

	public static void main(String[] args) {
		
	   // we know we already have a class name intNod in package, int is 4 bytes
		// Two main tasks
		//1 - create a new node object
		//2- Tell where is this object 
		//3- Tell where is pointing this object
		
		// since it is an integer so if we know the location of first one by adding four byts the next available memory can be found
		
       // also when we use print, it automatically goes to toString method in intNode class
		// call a link list class (intNode)
	//	IntNode front = new IntNode(17,null);
	//	System.out.println(front);
	//	System.out.println(front.data);
		
		
	// Calling rotate array
		
	//	int age1 [] = {1,2,3,4,5};
	//	Rotatearray var1 = new Rotatearray ( age1, 2);
	//	var1.rotate();
	//	String in  = "How are you doing today? ";
//		Stringreverse var2 = new Stringreverse(in);
//		var2.reverse();
		String [] input = {"2","3","+"};
	//	Reversestack var3= new Reversestack(in);
	    Readarray var4 = new Readarray();
	  System.out.println(var4.readit(input));
	
	}
   
}
