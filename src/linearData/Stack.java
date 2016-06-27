package linearData;

public class Stack {
    Node top;
	
    public Node peek()
    {
    	if(top != null){
    	return top;	
    	}
    	return null;
    }
    
    
    public void push(Node n)
    {
    if (top != null){
    	top.next = top;
    	top = n;
    }
    }
    
    public Node pop(){
    	Node temp = new Node(top.val);
    	top = top.next;
    	return temp;
    }
    
}
