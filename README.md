# List

Implementation of a List using an array

# Methods

1. CustomList(int size) - constructor.
2. CustomList() - constructor.
3. add(T item) - add item to list, returns true if successful. Throws NullPointerException on null item.
4. addAll(Collection<T> values) - adds collection of items to list, returns true if successful
6. clear() - removes all items from list.
6. contains(T item) = returns boolean determining if List contains item. Throws NullPointerException on null item.
7. containsAll(CustomList<T> collection) - returns boolean determining if all items were added to list. Throws NullPointerException on empty Collection.
8. get(int index) - returns item from List given Index. Throws IndexOutOfBoundsException. 
9. iterator() - returns an iterator. 
10. indexOf(Object o) - returns the index of specified object. Throws NullPointerException on null item.
12. isEmpty() - returns boolean determining if collection is empty.
12. lastIndexOf(Object o) returns the last index of specified object if exists, else -1. Throws NullPointerException on null item.
13. remove(int index) - removes object from List given index returning boolean result. Throws IndexOutOfBoundsException.
14. remove(T object) - removes specified object from List returning boolean result. Throws NullPointerException.
15. removeAll(Collection<T> c) - removes collection of objects from List returning boolean result. Throws NullPointerException on either null Collection or null item in Collection.
16. retainAll(Collection<T> collection) removes all elements from list that do not exist in collection. Throws NullPointerException on either null Collection or null item in Collection.
16. T set(int index, T item) - replaces element at given index. Throws NullPointerException on null item. Throws IndexOutOfBoundsException.
17. size() - returns size of list as Integer.
18. CustomList subList(int firstIndex, int secondIndex) - returns sub collection of given range. Throws IndexOutOfBoundsException if 
    - firstIndex is less than 0. 
    - if firstIndex is bigger than secondIndex, 
    - if firstIndex is bigger than size, 
    - if secondIndex is less than 0, 
    - if secondIndex is bigger than size
19. toArray() - returns list without null elements.
19. equals(Object o) - returns boolean comparing List instances.
20. hashCode() - returns Integer HashCode.
21. toString = returns String representation of List.
