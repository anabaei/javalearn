package linearData;

public class Stringreverse {
	
	public char[] str;
	
	
	public Stringreverse(String in)
	{
		char[] ss= in.toCharArray();
		this.str = ss;
	}

	public void reverse(){
		int j = 0;
		for (int i =0; i < str.length ; i++){
			if (str[i] == ' ' )
			{
			  rev(str, j, i-1);
			  j= i+1;
			  
			}
			
		}
		rev(str, 0, str.length-1);
		
		for (int r=0; r< str.length ; r++)
		{
			System.out.print(str[r]);
		}

	}

	public void rev(char[] str, int j, int i) {
		// TODO Auto-generated method stub
		char temp;
		while (j < i)
		{
		    temp = str[i];
		    str[i] = str[j];
		    str[j] = temp;
		    j++;
		    i--;
		}
	}
	
}
