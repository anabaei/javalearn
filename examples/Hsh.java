
import java.util.*;

public class Hsh {


   public Hsh(){
  //  HelloWorld tem = new HelloWorld();

    // res = tem.aaa;
}
    public static void main(String[] args) {
        // System.out.println("Hello, World");
        Hsh t = new Hsh();
        //t.buildMap();
        // String[] iarray = new String[]{ "aa","bb","cc" };
        // String[] barray = new String[]{ "aa","bb","cc" };
        // t.merge(iarray, barray);
       //    t.calduration();
      // test 1.1
      //  Boolean res = t.alluni("abcdefghi");
      //  System.out.println(res);
      // test 1.2
      // t.rev("amir nabaei");
      // test 1.3
      t.remdup("abcdeafghija");
    }

    public HashMap<Integer, String> buildMap(){
      HashMap<Integer, String> temp = new HashMap<Integer, String>();
      temp.put(1, "Amir");
      System.out.println("temp = "+temp);
      return temp;
    }

    /// merge two arrays to get a new one
    public ArrayList<String> merge(String[] words, String[] more)
    {
      ArrayList temp = new ArrayList<String>();
      for(String a: words) temp.add(a);
      for(String b: more) temp.add(b);
      System.out.println(temp);
      return temp;
    }

    public void calduration()
    {
      long startTime = System.nanoTime();
       addsentences1();
      long endTime = System.nanoTime();
      long duration = (endTime - startTime);
      System.out.println("1= "+duration);
    }

    public void addsentences1()
    {
      String a = "amir nabaei";
      String[] arra = a.split("");
      StringBuffer sentence = new StringBuffer();
      for(String w: arra) sentence.append(w);
      System.out.println(sentence);
    }
    public void addsentences2()
    {
      String a = "amir nabaei";
      String[] arra = a.split("");
      String[] res = new String[13];
      for (int i = 0; i < arra.length; i++) {

         res[i] = arra[i];
      }
        System.out.println(res);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////// Chapter 1 Arrays and Strings //////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// 1.1 Implement an algorithm to determine if a string has all unique characters What if you can not
    // use additional data structures?
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean alluni(String intp)
    {
      String[] str = intp.split("");
      StringBuffer sentence = new StringBuffer();
      for(String w: str) sentence.append(w);
       for(String fin: str)
       {
         if ( sentence.indexOf(fin) != sentence.lastIndexOf(fin) )
         {
           return false;
         }
       }
        // System.out.println(sentence.indexOf("d"));
        // System.out.println(sentence.lastIndexOf("d"));
      return true;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// 1.2 Write code to reverse a C-Style String (C-String means that
    // “abcd” is represented as five characters, including the null character )
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 public void rev(String str)
 {
   String[] temp = str.split("");
   StringBuffer sentence = new StringBuffer();
   for(String w: temp) sentence.append(w);
   sentence = sentence.reverse();
   System.out.println(sentence);
   // reverse again
   for(int i = temp.length-1; i>-1; i--)
   {
     System.out.print(temp[i]);
   }
 }






////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// 1.3 Design an algorithm and write code to remove the duplicate characters in a string without
    //   using any additional buffer note: One or two additional variables are fine An extra copy of the array is not
    /// FOLLOW UP
    /// Write the test cases for this method
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void remdup(String str)
{
  String[] temp = str.split("");
  for(int i=0; i<temp.length; i++)
  {
    for(int j=0;j<temp.length; j++)
    {
      if(j != i && temp[j] == temp[i])
      {
          System.out.println(temp[j]);
      }

    }
  }
}



}  // End of the class