package linearData;

public class Rotatearray {
	
	//one part of data is integer so we define it
	public int[] num;
	// need a pointer to another node, the type of pointer is a node
	public int k;
	
	// now we define a constructure
 public Rotatearray(int[] num, int k)
 {
 	//assign the paramaters into the variables in this class
 	this.k = k;
 	this.num = num;		
 }

 public void rotate(){
	 System.out.println(num.length);
 }
 
}
