```
Experience in optimization mathematics such as linear programming and nonlinear optimization
Ability to effectively articulate technical challenges and solutions Adept at handling ambiguous or undefined problems as well as ability to think abstractly
```

### Java Learn

* Static methods can not access to instance variables outside, unless the instance was created inside static mehthods like calling non static classes inside main static [here](https://www.quora.com/What-is-the-difference-between-static-and-non-static-methods-memory-allocation-in-java)
* Static methods are not-thread safe so only one thread running but non-static methods are thread-safe and more than one thread can run. 

<details>
           <summary>JRE & JDK </summary>
             <p>JRE includes a Java Virtual Machine (JVM) which allow to java run on all platforms. JRE required to run an application so end users only required to install it but JDK provide tools for us to build an app so normally developers install JDK and JDK includes JRE </p>
           <P> When create a source code in order to running we need JDK. We feed up source code into JDK and produce Java application. Java is not like C which when you compile then you can run it. JDK produces `ByteCode` which is an abstraction platform independent and only JRE provides what Bytecode needs to execute on any host environment 
           </p>
</details>
<details> 
           <summary> JAR & WAR</summary>  
  
 * WAR(Web Application Archive) files are for web applicaitons. JAR(Java Archive) files can be saved as any format but WAR files are created from Servlets. WAR has a WEB-INF/lib directory, xml and classes.  
 * EJB are packed as JAR files whereas web modules are packaged as WAR files which contains JSP files
</details>
<details>
           <summary> Serialize </summary>
           
* To serialize an object means to convert its state to a byte stream so that the byte stream can be reverted back into a copy of the object.            
</details>

These codes are Java 8 exercises for keeping in mind fresh objects in object oriented concepts. 

Test
In linklist.java there is a main test source. I use unit test for each class in that file and then comment it.

#### Java 7
* Some basic exerceise with chronological order 
* Strong vs Weak, Dynamic vs Static type of language

<details>
           <summary>In/Out </summary>
           
           
```java
 Scanner in = new Scanner(System.in); int a; a = in.nextInt();
 System.out.println(sum);
 int n = in.nextInt(); int[] ar = new int[n]; // define an array with size of n
 long input = in.nextLong();
 float myFloat = 2.001f;
```
 </details>


<details>
           <summary>Return an array in function </summary>

```java 
static int[] solve(int a) {} // this returns an array 
static int Sum(int n, int[] ar) {} // return an integer
```
</details>
<details>
           <summary>Return an array in function </summary>
           
           
* initialize array
```java
int[] series = {4,2};
long[] ar = new long[n];
int[] ar = new int[n];
int a[][] = new int[n][n];
```
</details>
<details>
           <summary>Integers & Float </summary>

* integer numbsers are 32-bit so the range is `(-2^31, 2^31 -1)` therefore a number like `5123456789` is bigger than `2147483647` or two power 31 so we need long type.
* To represent decimal numbsrs with 2 decimal floats 
```java
System.out.printf("%.2f", val);
```
#### 1.3333334
* To create fraction numbers use double format which give you a big decimal result
```java
double frac = 1.0000/n;
```
* But you are able to display them as float numbers as below with `6` decimal numbers
```java
System.out.printf("%.6f",frac);  System.out.printf("%n");
```
* %n is used for next line in printf 
##### 64 bits numbers
* To avoid stackover felow with big numbres we use double numbers, and to present them still use float as below
```java
double[] result={0,0};
System.out.printf("%.0f", result[0]);
```
* Result is an array may contain big numbers, print with 0 decimal numbers
</details>
<details>
           <summary>Array vs ArrayList </summary>
* ArrayList has a set of methods to access elements and modify them. Array is a fixed size data structure while ArrayList is not. One need not to mention the size of Arraylist while creating its object.
* The size of array is immutable in java, it means after we created we can not change it, however we can have different collection as

```java
List<Integer> myList = new ArrayList<Integer>();
myList.add(5);
myList.add(7);
```
</details>

<details>
           <summary>Array vs Hash Set </summary>

* Hash Set have unique value and you have O(1) `cotains` 
* Array are does not ensure there are duplicates `contains` is O(n)

####  Travers a List 
* Convert Array to ArrayList and to Set (hash)
```java
 Integer[] A = {-1,-2,1,3,6,43};
 List<Integer> assetList = Arrays.asList(A); // to arraylist
 Set<Integer> set = new HashSet<Integer>(assetList); // to Set
 set.contains(-2) // true 
```

* With a wrapper method
```java
public void addMember(Integer x) {
    myList.add(x);
};
```
* with a trick you can add item to an array with fixed size only if you copy it like:
```java
public static void main(String[] args) {
    int[] series = {4,2}; series = addElement(series, 1);
}
static int[] addElement(int[] a, int e) {
    a  = Arrays.copyOf(a, a.length + 1); a[a.length - 1] = e;
    return a;
}
```
</details>

<details>
           <summary> Print Last Item </summary>
           
* Only for the last item it prints "end!"
```java
for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : "end!")); }
```
</details>

<details>
           <summary> Char vs String </summary>

* find charAt from string and split
```java
String[] res = s.split('-');
char mil = s.charAt(8);
```
* To compare Char and one charactor
```java
mil == 'p' // it is true
mil == "p" // it assumes p as string not char!
```
</details>
<details>
           <summary> BufferReader with inputstreamreader </summary>

* Allows to read line by line from user inputs or from a txt file and has autoclose. Bufferreader has `readLine` function and since it doesnt have close tag so we have to put it inside try catch as below from [link](https://docs.oracle.com/javase/7/docs/api/java/io/InputStreamReader.html)
```java
import java.io.*;
public static void main(String[] args) {

try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
    System.out.println("you typed:"+ br.readLine()); //return line by line, read() return ascii code
    	}
catch(IOException e)
   {
       System.out.print(e.getMessage());
    }
 }
```
</details>
<details>
           <summary>Break outer loop </summary>

* This code breaks only inside loop if you want to break outer loop check [this](https://stackoverflow.com/questions/886955/breaking-out-of-nested-loops-in-java) linke
```java
for (Type type : types) {
    for (Type t : types2) {
         if (some condition) {
             // Do something and break...
             break; // Breaks out of the inner loop
         }
    }
}
```
</details>


#### Debug in Eclipse
* create a java project and create a class name 
* Add breaking line and on class right click debug java

#### [Input Output](https://www.tutorialspoint.com/java/io/index.htm) 
#### [Scanner next](https://www.javatpoint.com/Scanner-class)


