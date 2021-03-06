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

## Looping

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
   * For nested loops instead of O(n2) we can have O(n+n) by traversing one linklist or list and mark them, then travers the second one. For this we need to put first list into hash [here](https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/) 
   ```java
   import java.util.*;
    HashMap<Integer, String> temp = new HashMap<Integer, String>();
	   temp.put(1, "check");
	   temp.put(2, "check");
     ....
     //second loop first check
     temp.containsKey(2);
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
  <details>
  <summary> Sorting </summary>
 
 #### Quick Sort
 * We take a pivot, then compare everything with that if bigger change with next one then first round would be like all bigger numbers on right side and smaller ones at left side of pivot and then do it recurcsively
 ```java
 quickSort(arr[], low, high)
{
 // here I take pivot the last one we can take it as first one or accidentaly
 if (low < high)
    {
        pi = partition(arr, low, high);
	quicksort(arr,pi, high)
	quicksort(arr,low, pi-1)
    }
}
```
* In partitions we have two pointer, one i=-1 (low-1) and another is j=low 
* loop with j=low to high-1
* if smaller than pivot  i++, then swap arr[i], arr[j] and next loop in j. else just go next loop. finally return i+1 
```java
partition(arr[],low,high) {
   pivot = arr[high]
   for(int i=0; i<high-1,i++)
       if(arr[i]> pivot
}
 ```
 
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
 * Binary search [here](https://medium.com/@jeffrey.allen.lewis/javascript-algorithms-explained-binary-search-25064b896470)
 
 </details> 
 
 <details>
  <summary> Greedy Algorithms </summary>
  
  * There are [4 type](https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/)
  * Minimum Spaning Tree [MST](https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/)
  ```java
  
  ```
  * has a graph a cycle: 
  ```java
  * First assume a class with graph has two properties V and E as number of vertixes and edges
  * define an inside class Edge with two attribute int dest, src
  * define a function isCycle(graph graph) to 
  create a parent[] with size of vertices and assign them -1
  loop through graph.edge[i].dest and graph.edge[i].dest as
  x = find(graph.edge[i].dest, parent)
  y = find(graph.edge[i].src, parent)
  if x == y return 1
  else parent[x] = y
  * define find as a recursive function as 
  public int find(int i, parent[])
   if parent[i] == -1  // means has no connection or parent
       return i
       else fidn(parent[i], parent)
  
  ```
  </details>
 

