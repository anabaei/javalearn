Java Learn

These codes are Java 8 exercises for keeping in mind fresh objects in object oriented concepts. 

Test
In linklist.java there is a main test source. I use unit test for each class in that file and then comment it.

#### Java 7
* Some basic exerceise with chronological order 

#### In/Out
```java
 Scanner in = new Scanner(System.in); int a; a = in.nextInt();
 System.out.println(sum);
 int n = in.nextInt(); int[] ar = new int[n]; // define an array with size of n
 long input = in.nextLong();
 float myFloat = 2.001f;
```

### Return an array in function
```java 
static int[] solve(int a) {} // this returns an array 
static int Sum(int n, int[] ar) {} // return an integer
```
* initialize array
```java
int[] series = {4,2};
long[] ar = new long[n];
int[] ar = new int[n];
int a[][] = new int[n][n];
```
* integer numbsers are 32-bit so the range is `(-2^31, 2^31 -1)` therefore a number like `5123456789` is bigger than `2147483647` or two power 31 so we need long type.
* To represent decimal numbsrs with 2 decimal floats 
```java
System.out.printf("%.2f", val);
```
* The size of array is immutable in java, it means after we created we can not change it, however we can have different collection as
```java
List<Integer> myList = new ArrayList<Integer>();
myList.add(5);
myList.add(7);
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

#### Print for last item
* Only for the last item it prints "end!"
```java
for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : "end!")); }
```

#### Debug in Eclipse
* create a java project and create a class name 
* Add breaking line and on class right click debug java


