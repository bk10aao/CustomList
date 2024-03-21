import java.util.Collection;
import java.util.Iterator;

public interface List<T> {

    /**
     * Add item to List.
     * @param item - item to be added to List.
     * @return boolean true if successful, else false.
     * @throws NullPointerException on null item.
     */
    boolean add(T item);

    /**
     * Add Collection of items to List.
     * @param values - values to be added to List.
     * @return boolean true if successful, else false.
     */
    boolean addAll(Collection<T> values);

    /**
     * Clear all items from collection.
     */
    void clear();

    /**
     * Check if List contains item
     * @param item - item to be searched for in List.
     * @return boolean true if contains, else false.
     * @throws NullPointerException on null item.
     */
    boolean contains(T item);

    /**
     * Check if List contains all items in collection.
     * @param collection - collection to be checked for in List.
     * @return boolean true if contains all items, else false.
     * @throws NullPointerException on null collection.
     */
    boolean containsAll(CustomList<T> collection);

    /**
     * Get Object by index.
     * @param index - index of item to be returned.
     * @return Object if successful.
     * @throws IndexOutOfBoundsException on null item.
     */
    T get(int index);

    /**
     * Get iterator for list.
     * @return Iterator.
     */
    Iterator iterator();

    /**
     * Get index of Object
     * @param o - object to find index of.
     * @return Integer index of Object.
     * @throws NullPointerException on null item.
     */
    int indexOf(Object o);

    /**
     * Check if List is Empty.
     * @return True if empty, else false.
     */
    boolean isEmpty();

    /**
     * Remove object by index.
     * @param index - index of object to be removed.
     * @return true if successful.
     */
    boolean remove(int index);

    /**
     * Remove object by index.
     * @param object - object to be removed from List.
     * @return true if successful.
     */
    boolean remove(T object);

    /**
     * Remove all Object in Collection from List.
     * @param c - collection to be added to List.
     * @return true if successful.
     * @throws NullPointerException on null collection.
     * @throws NullPointerException on null item in collection.
     */
    boolean removeAll(Collection<T> c);

    /**
     * Set object at index to new Object.
     * @param index - index of item to be set to.
     * @param item - item to be added to index.
     * @return Object previously at index.
     * @throws NullPointerException on null Object.
     */
    T set(int index, T item);

    /**
     * Get size of List.
     * @return Integer size of list.
     */
    int size();

    /**
     * Get List as Array.
     * @return T[] array of List.
     */
    T[] toArray();

    /**
     * Compares two Lists.
     * @param o - List to compare.
     * @return true if equal.
     */
    boolean equals(Object o);

}