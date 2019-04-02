<details>
  <summary> Eclipse IDE </summary>

* You can have web base JAVA EE or just JAVA package. I like to have JAVA EE since we can get advantage of web as well
```java
 new project- > java , then add aclass to src folder  
```
* If `tomcat apache` didn't show up you can download it and then use it
* Then you need create a class inside `src` folder

</details>
<details>
  <summary>Algorithms </summary>
  
* 
```java

```
</details>


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
 
 
 ## [LinkList](https://github.com/trekhleb/javascript-algorithms/tree/master/src/data-structures/linked-list) 
 <details>
  <summary> Node </summary>
     
* Remember, Head ( a pointer to a node) is always part of LinkList class and Node is inside LinkList class.  
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
  * In order to insert new node to linklist you can use this [resource](https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/)
  </details>
  <details>
  <summary> Stacks & Queues </summary>
     
 </details>
 
### [Hash Table](https://github.com/trekhleb/javascript-algorithms/tree/master/src/data-structures/hash-table)
* Hash tables by their hash function map keys to an index of an array with buckets.  

## Trees
* Trees are hierarchical data structures.



<details>
  <summary> Heap </summary>
  
  
 * [Heap](https://github.com/trekhleb/javascript-algorithms/tree/master/src/data-structures/heap) is a specialized tree-based data structure that parent value is bigger than children(heap max) and in heap min parents value is less than children 
</details>
<details>
  <summary> Graph </summary>
  
  * Usually showing graph using two types of data adjacing list and adjacing matrix from [here](https://www.geeksforgeeks.org/graph-and-its-representations/)
  * Graphs are a bunch of nodes connected to each other. We need `node`. Below is adjacing list 
  ```java
  import java.util.Hashmap;
import java.util.ArrayList;

class Node {
    String label;
    ArrayList<Node> adjacencyList;
}

HashMap<String, Node> graph = new HashMap<String, Node>();
  ```
 * BFS search [BFS for a Graph](https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/) 
 
 </details> 
 
 
 

