### Start

<details>
  <summary>Hello </summary>


```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World"); 
    }
}
```
* To run 
```java
javac HelloWorld.java   // Use JDK to create a bytecode file 
javac -d results HelloWorld.java /// creates java files in result directory 
java HelloWorld         // this command feeding JRE which use JVM to run it 
```
</details>

## Arrays

<details>
  <summary> HashMap </summary>
   
```java
   import java.util.*;
     public HashMap<Integer, String> buildMap(){
      HashMap<Integer, String> temp = new HashMap<Integer, String>();
      temp.put(1, "Amir");
      System.out.println("temp = "+temp);
      return temp;
    }
   ```
 </details>
 <details>
  <summary> MergeArrays </summary>
   
```java
 
   ```
 </details>
 
  <details>
  <summary> String Buffer & String </summary>
    The difference is in order to loop through a array of string and add, it takes O(n^2) because everytime append or add run, it makes a copy of string which costs O(n). Therefore we use StringBuffer which doesnt duplicate everytime it append to string 
  
```java
  It takes O(n)
        String a = "amir nabaei";
        String[] arra = a.split("");
        StringBuffer sentence = new StringBuffer();
        for(String w: arra) sentence.append(w);
     takes O(n^2)
      String a = "amir nabaei";
      String[] arra = a.split("");
      String[] res = new String[13];
      for (int i = 0; i < arra.length; i++) {\
         res[i] = arra[i];
      }
   ```
   Some usefull methos to manipulate strings in stringBuffer class [here](https://www.tutorialspoint.com/java/java_string_buffer.htm)
   `StringBuffer` and `StringBuilder` are same and have same methods except `StringBuffer` is `thread safe` 
 </details>
 
 <details>
  <summary> Split & Append String</summary>
  
```java
  String[] temp = str.split("");  // convert string to array 
  StringBuilder builder = new StringBuilder();
  for(String s: temp)
   builder.append(s);
   // in Java 8 
   String str1 = String.join("", temp);
  ```
  Char array [link](https://www.dotnetperls.com/char-array-java)
 </details>
 
 
 ## LinkList 
 <details>
  <summary> Node </summary>
     
     
  ```java
     public class Node{
       int data;
       Node next;
       public Node(int d)
       {
          data = d;
       }
     }
  ```
  </details>
  <details>
  <summary> Linkedlist </summary>
  
  A good practice [here](https://www.geeksforgeeks.org/linked-list-set-1-introduction/)
  There is a linklist class which inside keeps node classes
  Each Linklist class has a head to tell from where to start nodes
  </details>
  <details>
  <summary> Stacks & Queues </summary>
     
 </details>

## Trees
* Unlike Arrays, Linked Lists, Stack and queues, which are linear data structures, trees are hierarchical data structures.


