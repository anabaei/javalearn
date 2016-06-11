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
		
		IntNode front = new IntNode(17,null);
		System.out.println(front);
		System.out.println(front.data);
	}

}
