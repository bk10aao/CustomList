# List

Implementation of a List using an array

# Methods

1. `CustomList()` - Constructs an empty list with an initial capacity of 32. 
2. `CustomList(int initialCapacity)` - Constructs an empty list with the specified initial capacity (minimum 32). 
3. `boolean add(E element)` - Appends the specified element to the end of the list. Returns true. Throws NullPointerException if the element is null. 
4. `void add(int index, E element)` - Inserts the specified element at the given index, shifting elements to the right. Throws IndexOutOfBoundsException if index < 0 or index > size(). Throws NullPointerException if the element is null. 
5. `boolean addAll(Collection<? extends E> c)` - Appends all elements from the specified collection to the end of the list, in the order returned by the collection’s iterator. Returns true if the list changed. Throws NullPointerException if the collection or any of its elements is null.
6. `boolean addAll(int index, Collection<? extends E> c)` - Inserts all elements from the specified collection at the given index, shifting elements to the right. Returns true if the list changed. Throws IndexOutOfBoundsException if index < 0 or index > size(). Throws NullPointerException if the collection or any of its elements is null.
7. `void clear()` - Removes all elements from the list, resetting it to an empty state with a capacity of 32. 
8. `boolean contains(Object o)` - Returns true if the list contains the specified element (using Objects.equals). Throws NullPointerException if the element is null. 
9. `boolean containsAll(Collection<?> c)` - Returns true if the list contains all elements from the specified collection. Throws NullPointerException if the collection or any of its elements is null.
10. `boolean equals(Object o)` - Returns true if the specified object is a list with the same size and elements in the same order (using Objects.equals).
11. `E get(int index)` - Returns the element at the specified index. Throws IndexOutOfBoundsException if index < 0 or index >= size().
12. `int hashCode()` - Returns the hash code of the list based on its elements.
13. `int indexOf(Object o)` - Returns the index of the first occurrence of the specified element, or -1 if not found. Throws NullPointerException if the element is null.
14. `boolean isEmpty()` - Returns true if the list contains no elements.
15. `Iterator<E> iterator()` - Returns an iterator over the elements in the list in proper sequence.
16. `int lastIndexOf(Object o)` - Returns the index of the last occurrence of the specified element, or -1 if not found. Throws NullPointerException if the element is null.
17. `ListIterator<E> listIterator()` - Returns a list iterator over the elements in the list starting at index 0.
18. `ListIterator<E> listIterator(int index)` - Returns a list iterator over the elements in the list starting at the specified index. Throws IndexOutOfBoundsException if index < 0 or index > size().
19. `E remove(int index)` - Removes and returns the element at the specified index, shifting elements to the left. Throws IndexOutOfBoundsException if index < 0 or index >= size().
20. `boolean remove(Object o)` - Removes the first occurrence of the specified element, returning true if the list changed. Throws NullPointerException if the element is null.
21. `boolean removeAll(Collection<?> c)` - Removes all elements from the list that are contained in the specified collection, returning true if the list changed. Throws NullPointerException if the collection or any of its elements is null.
22. `boolean retainAll(Collection<?> c)` - Removes all elements from the list that are not contained in the specified collection, returning true if the list changed. Throws NullPointerException if the collection or any of its elements is null.
23. `E set(int index, E element)` - Replaces the element at the specified index with the given element, returning the previous element. Throws IndexOutOfBoundsException if index < 0 or index >= size(). Throws NullPointerException if the element is null.
24. `int size()` - Returns the number of elements in the list.
25. `CustomList<E> subList(int fromIndex, int toIndex)` - Returns a new CustomList containing elements from fromIndex (inclusive) to toIndex (exclusive). Throws IndexOutOfBoundsException if fromIndex < 0, toIndex > size(), fromIndex > toIndex
26. `E[] toArray()` - Returns an array containing all elements in the list in proper sequence.
27. `T[] toArray(T[] a)` - Returns an array containing all elements in the list in proper sequence, using the provided array if it is large enough, or a new array of the same type. Throws NullPointerException if the array is null. Throws ArrayStoreException if the array’s type is incompatible.
28. `String toString()` - Returns a string representation of the list in the format CustomList{size=<size>, list=<elements>}.

# Time Complexity Comparison
| Method                                  | CustomList O()     | ArrayList O()     | Winner         |
|----------------------------------------|--------------------|-------------------|----------------|
| add(E)                                | O(1) amortized     | O(1) amortized    | Tie            |
| add(int, E)                           | O(n)               | O(n)              | Tie            |
| addAll(Collection)                    | O(m) amortized     | O(m) amortized    | Tie            |
| addAll(int, Collection)               | O(n + m)           | O(n + m)          | Tie            |
| clear()                               | O(1)               | O(1)              | Tie            |
| contains(Object)                      | O(n)               | O(n)              | Tie            |
| containsAll(Collection)               | O(n * m)           | O(n * m)          | Tie            |
| equals(Object)                        | O(n)               | O(n)              | Tie            |
| get(int)                              | O(1)               | O(1)              | Tie            |
| hashCode()                            | O(n)               | O(n)              | Tie            |
| indexOf(Object)                       | O(n)               | O(n)              | Tie            |
| isEmpty()                             | O(1)               | O(1)              | Tie            |
| iterator()                            | O(1)               | O(1)              | Tie            |
| iterator().next()                     | O(1)               | O(1)              | Tie            |
| listIterator()                        | O(1)               | O(1)              | Tie            |
| listIterator(int)                     | O(1)               | O(1)              | Tie            |
| listIterator().next()                 | O(1)               | O(1)              | Tie            |
| listIterator().previous()             | O(1)               | O(1)              | Tie            |
| listIterator().add(E)                 | O(n)               | O(n)              | Tie            |
| listIterator().set(E)                 | O(1)               | O(1)              | Tie            |
| listIterator().remove()               | O(n)               | O(n)              | Tie            |
| lastIndexOf(Object)                   | O(n)               | O(n)              | Tie            |
| remove(int)                           | O(n)               | O(n)              | Tie            |
| remove(Object)                        | O(n)               | O(n)              | Tie            |
| removeAll(Collection)                 | O(n * m)           | O(n * m)          | Tie            |
| retainAll(Collection)                 | O(n * m)           | O(n * m)          | Tie            |
| set(int, E)                           | O(1)               | O(1)              | Tie            |
| size()                                | O(1)               | O(1)              | Tie            |
| subList(int, int)                     | O(k)               | O(1)              | ArrayList      |
| toArray()                             | O(n)               | O(n)              | Tie            |
| toArray(T[])                          | O(n)               | O(n)              | Tie            |
| toString()                            | O(n)               | O(n)              | Tie            |
| expand() (private)                    | O(n)               | O(n)              | Tie            |
| reduce() (private)                    | O(n)               | O(n)              | Tie            |
| insert(int, Collection) (private)     | O(n + m)           | O(n + m)          | Tie            |

**Legend**:
- `n`: Number of elements in the list.
- `m`: Number of elements in the input collection.
- `k`: Number of elements in the sublist (`toIndex - fromIndex`).

# Space Complexity Comparison
| Method                                  | CustomList Space O() | ArrayList Space O() | Winner         |
|----------------------------------------|----------------------|---------------------|----------------|
| add(E)                                | O(n) worst-case      | O(n) worst-case     | Tie            |
| add(int, E)                           | O(n)                 | O(n)                | Tie            |
| addAll(Collection)                    | O(n) worst-case      | O(n) worst-case     | Tie            |
| addAll(int, Collection)               | O(n + m)             | O(n + m)            | Tie            |
| clear()                               | O(1)                 | O(1)                | Tie            |
| contains(Object)                      | O(1)                 | O(1)                | Tie            |
| containsAll(Collection)               | O(1)                 | O(1)                | Tie            |
| equals(Object)                        | O(1)                 | O(1)                | Tie            |
| get(int)                              | O(1)                 | O(1)                | Tie            |
| hashCode()                            | O(1)                 | O(1)                | Tie            |
| indexOf(Object)                       | O(1)                 | O(1)                | Tie            |
| isEmpty()                             | O(1)                 | O(1)                | Tie            |
| iterator()                            | O(1)                 | O(1)                | Tie            |
| iterator().next()                     | O(1)                 | O(1)                | Tie            |
| listIterator()                        | O(1)                 | O(1)                | Tie            |
| listIterator(int)                     | O(1)                 | O(1)                | Tie            |
| listIterator().next()                 | O(1)                 | O(1)                | Tie            |
| listIterator().previous()             | O(1)                 | O(1)                | Tie            |
| listIterator().add(E)                 | O(n) worst-case      | O(n) worst-case     | Tie            |
| listIterator().set(E)                 | O(1)                 | O(1)                | Tie            |
| listIterator().remove()               | O(n) worst-case      | O(n) worst-case     | Tie            |
| lastIndexOf(Object)                   | O(1)                 | O(1)                | Tie            |
| remove(int)                           | O(n) worst-case      | O(n) worst-case     | Tie            |
| remove(Object)                        | O(n) worst-case      | O(n) worst-case     | Tie            |
| removeAll(Collection)                 | O(n) worst-case      | O(n) worst-case     | Tie            |
| retainAll(Collection)                 | O(n) worst-case      | O(n) worst-case     | Tie            |
| set(int, E)                           | O(1)                 | O(1)                | Tie            |
| size()                                | O(1)                 | O(1)                | Tie            |
| subList(int, int)                     | O(k)                 | O(1)                | ArrayList      |
| toArray()                             | O(n)                 | O(n)                | Tie            |
| toArray(T[])                          | O(n) worst-case      | O(n) worst-case     | Tie            |
| toString()                            | O(n)                 | O(n)                | Tie            |
| expand() (private)                    | O(n)                 | O(n)                | Tie            |
| reduce() (private)                    | O(n)                 | O(n)                | Tie            |
| insert(int, Collection) (private)     | O(n + m)             | O(n + m)            | Tie            |

**Legend**:
- `n`: Number of elements in the list.
- `m`: Number of elements in the input collection.
- `k`: Number of elements in the sublist (`toIndex - fromIndex`).

# Performance Charts

## Custom List vs Array List
![Combined Performance Charts](PerformanceTesting/CustomList_vs_ArrayList_Performance_Comparisons.png)
