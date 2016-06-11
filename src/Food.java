import java.util.ArrayList;

public class Food {
	
	void eat() {
	        System.out.println("This is eat from food class");     
	    
  
	ArrayList<Integer> mylist = new ArrayList<Integer>(3);
	mylist.add(11);mylist.add(12);mylist.add(13);mylist.add(14);mylist.add(15);
	mylist.add(16);mylist.add(17);
	mylist.remove("11");
	System.out.print(mylist.size());
  
}
}
