# List

Implementation of a List using an array

# Methods

1. CustomList(int size) - constructor.
2. CustomList() - constructor.
3. add(T item) - add item to list, returns true if successful.
4. addAll(Collection<T> values) - adds collection of items to list, returns true if successful
5. clear() - removes all items from list.
6. contains(T item) = returns boolean determining if List contains item.
7. containsAll(CustomList<T> collection) - returns boolean determining if all items were added to list. Throws NullPointerException on empty Collection.
8. get(int index) - returns item from List given Index. Throws IndexOutOfBoundsException. 
9. iterator() - returns an iterator. 
10. indexOf(Object o) - returns the index of specified object. Throws NullPointerException.
11. isEmpty() - returns boolean determining if collection is empty.
12. remove(int index) - removes object from List given index returning boolean result. Throws IndexOutOfBoundsException.
13. remove(T object) - removes specified object from List returning boolean result. Throws NullPointerException.
14. removeAll(Collection<T> c) - removes collection of objects from List returning boolean result. Throws NullPointerException on either null Collection or null item in Collection. 
15. T set(int index, T item) - replaces element at given index. Throws NullPointerException on null item. Throws IndexOutOfBoundsException.
16. size() - returns size of list as Integer.
17. toArray() - returns list without null elements.
18. equals(Object o) - returns boolean comparing List instances.
19. hashCode() - returns Integer HashCode.
