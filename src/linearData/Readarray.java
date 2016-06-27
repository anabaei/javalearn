package linearData;

import java.util.Stack;

public class Readarray {

	public String [] in;
	public int readit(String [] in){
		this.in = in;
		String operators = "+-*/";
		 
		Stack<String> stack = new Stack<String>();
		int i=0;
		while(i<in.length)
		{
			if (!operators.contains(in[i]))
			{
				stack.push(in[i]);
			}
			else
			{
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch(in[i])
				{
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				}
			}
		i++;	
		}
		int returnValue = Integer.valueOf(stack.pop());
		 
		return returnValue;	
		
	}
	
}
