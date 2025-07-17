# List

Implementation of a List using an array

# Methods

1. `CustomList(int size)` - constructor.
2. `CustomList()` - constructor.
3. `boolean add(T item)` - add item to list, returns true if successful. Throws NullPointerException on null item.
4. `boolean addAll(Collection<T> values)` - adds collection of items to list, returns true if successful.
5. `void clear()` - removes all items from list.
6. `boolean contains(T item)` = returns boolean determining if List contains item. Throws NullPointerException on null item.
7. `boolean containsAll(CustomList<T> collection)` - returns boolean determining if all items were added to list. Throws NullPointerException on empty Collection.
8. `T get(int index)` - returns item from List given Index. Throws IndexOutOfBoundsException. 
9. `Iterator iterator()` - returns an iterator. 
10. `int indexOf(Object o)` - returns the index of specified object. Throws NullPointerException on null item.
11. `boolean isEmpty()` - returns boolean determining if collection is empty.
12. `int lastIndexOf(Object o)` - returns the last index of specified object if exists, else -1. Throws NullPointerException on null item.
13. `boolean remove(int index)` - removes object from List given index returning boolean result. Throws IndexOutOfBoundsException.
14. `boolean remove(T object)` - removes specified object from List returning boolean result. Throws NullPointerException.
15. `boolean removeAll(Collection<T> c)` - removes collection of objects from List returning boolean result. Throws NullPointerException on either null Collection or null item in Collection.
16. `boolean retainAll(Collection<T> collection)` - removes all elements from list that do not exist in collection. Throws NullPointerException on either null Collection or null item in Collection.
17. `T set(int index, T item)` - replaces element at given index. Throws NullPointerException on null item. Throws IndexOutOfBoundsException.
18. `int size()` - returns size of list as Integer.
19. `CustomList subList(int firstIndex, int secondIndex)` - returns sub collection of given range. Throws IndexOutOfBoundsException if: 
    - firstIndex is less than 0 
    - firstIndex is larger than secondIndex
    - firstIndex is larger than size
    - secondIndex is less than 0
    - secondIndex is larger than size
20. `T[] toArray()` - returns list without null elements.
21. `boolean equals(Object o)` - returns boolean comparing List instances.
22. `int hashCode()` - returns HashCode.
23. `String toString()` = returns String representation of List.

# Time Complexity Comparison

| Method                  |  CustomList Time Complexity  |  ArrayList Time Complexity  |      Winner      |
|-------------------------|:----------------------------:|:---------------------------:|:----------------:|
| add(T item)             |             O(1)             |            O(1)             |       Tie        |
| addAll(Collection)      |             O(n)             |            O(n)             |       Tie        |
| clear()                 |             O(1)             |            O(n)             |  **CustomList**  |
| contains(T item)        |             O(n)             |            O(n)             |       Tie        |
| containsAll(Collection) |           O(n * m)           |          O(n * m)           |       Tie        |
| get(int index)          |             O(1)             |            O(1)             |       Tie        |
| indexOf(Object o)       |             O(n)             |            O(n)             |       Tie        |
| isEmpty()               |             O(1)             |            O(1)             |       Tie        |
| iterator()              |             O(1)             |            O(1)             |       Tie        |
| lastIndexOf(Object o)   |             O(n)             |            O(n)             |       Tie        |
| remove(int index)       |             O(n)             |            O(n)             |       Tie        |
| remove(Object o)        |             O(n)             |            O(n)             |       Tie        |
| removeAll(Collection)   |           O(n * m)           |          O(n * m)           |       Tie        |
| retainAll(Collection)   |           O(n * m)           |          O(n * m)           |       Tie        |
| set(int index, T item)  |             O(1)             |            O(1)             |       Tie        |
| size()                  |             O(1)             |            O(1)             |       Tie        |
| subList(a, b)           |             O(n)             |            O(1)             |  **ArrayList**   |
| toArray()               |             O(n)             |            O(n)             |       Tie        |
| equals(Object o)        |             O(n)             |            O(n)             |       Tie        |
| hashCode()              |             O(n)             |            O(n)             |       Tie        |
| toString()              |             O(n)             |            O(n)             |       Tie        |

# Space Complexity Comparison

| **Method**                          | **Java ArrayList** | **CustomList<T>** | **Winner**         |
|-------------------------------------|:------------------:|:-----------------:|:------------------:|
| `add(T)`                            | O(1)              | O(1)              | Tie                |
| `addAll(Collection<? extends T>)`   | O(1)              | O(n)              | ArrayList          |
| `clear()`                           | O(1)              | O(1)              | Tie                |
| `contains(Object)`                  | O(1)              | O(1)              | Tie                |
| `containsAll(Collection<?>)`        | O(1)              | O(1)              | Tie                |
| `get(int)`                          | O(1)              | O(1)              | Tie                |
| `indexOf(Object)`                   | O(1)              | O(1)              | Tie                |
| `isEmpty()`                         | O(1)              | O(1)              | Tie                |
| `iterator()`                        | O(1)              | O(1)              | Tie                |
| `lastIndexOf(Object)`               | O(1)              | O(1)              | Tie                |
| `remove(int)`                       | O(1)              | O(1)              | Tie                |
| `remove(Object)`                    | O(1)              | O(1)              | Tie                |
| `removeAll(Collection<?>)`          | O(1)              | O(1)              | Tie                |
| `retainAll(Collection<?>)`          | O(1)              | O(1)              | Tie                |
| `set(int, T)`                       | O(1)              | O(1)              | Tie                |
| `size()`                            | O(1)              | O(1)              | Tie                |
| `subList(int, int)`                 | O(1)              | O(n)              | ArrayList          |
| `toArray()`                         | O(n)              | O(n)              | Tie                |
- *n* = number of elements in the CustomList or ArrayList.
- *m* = number of elements in the input Collection (used in methods like addAll, containsAll, etc.).

# Performance Charts
## Custom List vs Array List
![Combined Performance Charts](PerformanceTesting/CustomList_vs_ArrayList_Performance_Comparisons.png)

## Custom List
![Combined Performance Charts](PerformanceTesting/CustomList_Performance.png)

## Array List
![Combined Performance Charts](PerformanceTesting/ArrayList_Performance.png)
