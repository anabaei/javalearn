### Start

<details>
  <summary>Hello Java </summary>

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
  <summary> String Buffer & String </summart>
  * The difference is in order to loop through a array of string and add, it takes O(n^2) because everytime append or add run, it makes a copy of string which costs O(n). Therefore we use StringBuffer which doesnt duplicate everytime it append to string 
   * It takes O(n)
  
  ```java
      String a = "amir nabaei";
      String[] arra = a.split("");
      StringBuffer sentence = new StringBuffer();
      for(String w: arra) sentence.append(w);
  ```
  * But below takes O(n^2)
  ```java
      String a = "amir nabaei";
      String[] arra = a.split("");
      String[] res = new String[13];
      for (int i = 0; i < arra.length; i++) {\
         res[i] = arra[i];
      }
  ```
  
  </details>

