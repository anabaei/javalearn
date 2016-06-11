package linearData;

//we define a link list as a class in package 

public class IntNode {
	
	//one part of data is integer so we define it
	public int data;
	// need a pointer to another node, the type of pointer is a node
	public IntNode next;
	
	// now we define a constructure
 public IntNode(int data_1, IntNode next_1)
 {
 	//assign the paramaters into the variables in this class
 	this.data = data_1;
 	this.next = next_1;		
 }
 
 public String toString()
 {
 	// command return data returns int but plus with " " returns string
 	return data + " ";
 }
}