package linearData;

public class Rotatearray {
	
	//one part of data is integer so we define it
	public int[] num;
	public int[] result;
	// need a pointer to another node, the type of pointer is a node
	public int k;
	
	
	// now we define a constructure
 public Rotatearray(int[] num, int k)
 {
 	//assign the paramaters into the variables in this class
 	this.k = k;
 	this.num = num;
 	this.result = new int[num.length];
 }

 public void rotate(){
	 for (int i=0; i<k; i++){
	 result[i] =  num[num.length -i -1]; 
		
	 }
	 for (int i=0; i<num.length-k; i++)
	 {
   	 result[i+k] = num[i]; 
	 }
	 int j=0;
	 while (j< result.length) 
	 {
	 System.out.println(result[j]);
	 j++;
	 }
	 
	 }
 
}
