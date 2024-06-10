# List

Implementation of a List using an array

# Methods

1. `CustomList(int size)` - constructor.
2. `CustomList()` - constructor.
3. `boolean add(T item)` - add item to list, returns true if successful. Throws NullPointerException on null item.
4. `boolean addAll(Collection<T> values)` - adds collection of items to list, returns true if successful
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
    - firstIndex is less than 0. 
    - firstIndex is bigger than secondIndex, 
    - firstIndex is bigger than size, 
    - secondIndex is less than 0, 
    - secondIndex is bigger than size
20. `T[] toArray()` - returns list without null elements.
21. `boolean equals(Object o)` - returns boolean comparing List instances.
22. `int hashCode()` - returns Integer HashCode.
23. `String toString()` = returns String representation of List.