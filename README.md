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
```

### Return an array in function
```java 
static int[] solve(int a) {} // this returns an array 
static int Sum(int n, int[] ar) {} // return an integer
```
* initialize array
```java
int[] series = {4,2};
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

#### Print for last item
* Only for the last item it prints "end!"
```java
for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : "end!"));
        }
```



