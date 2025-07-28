import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public interface ListInterface<E> {

    /**
     * Add item to List.
     * @param item - item to be added to List.
     * @return boolean true if successful, else false.
     * @throws NullPointerException on null item.
     */
    boolean add(E item);

    /**
     * Add Collection of items to List.
     * @param values - values to be added to List.
     * @return boolean true if successful, else false.
     */
    boolean addAll(Collection<? extends E> values);

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
    boolean contains(Object item);

    /**
     * Check if List contains all items in collection.
     * @param collection - collection to be checked for in List.
     * @return boolean true if contains all items, else false.
     * @throws NullPointerException on null collection.
     */
    boolean containsAll(List<E> collection);

    /**
     * Compares two Lists.
     *
     * @param list - List to compare.
     * @return true if equal.
     */
    boolean equals(Object list);

    /**
     * Get Object by index.
     * @param index - index of item to be returned.
     * @return Object if successful.
     * @throws IndexOutOfBoundsException on index larger < 0.
     * @throws IndexOutOfBoundsException on index >= size().
     */
    E get(int index);

    /**
     * Get HashCode for List Object
     * @return hashcode for List
     */
    int hashCode();

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
     * Get last Index of Object in List
     * @return last Index of object if present, else -1
     * @throws NullPointerException on null object
     */
    int lastIndexOf(Object o);

    /**
     * Remove object by index.
     * @param index - index of object to be removed.
     * @throws IndexOutOfBoundsException if index < 0.
     * @throws IndexOutOfBoundsException if index >= size().
     * @return true if successful.
     */
    boolean remove(int index);

    /**
     * Remove object by index.
     * @param object - object to be removed from List.
     * @throws IndexOutOfBoundsException - on null item.
     * @return true if successful.
     */
    boolean remove(E object);

    /**
     * Remove all Object in Collection from List.
     * @param c - collection to be added to List.
     * @return true if successful.
     * @throws NullPointerException on null collection.
     * @throws NullPointerException on null item in collection.
     */
    boolean removeAll(Collection<E> c);

    /**
     * Remove all Objects in Collection except those in list.
     * @param c - collection to be kept in List.
     * @return true if successful, else false.
     * @throws NullPointerException on null List.
     */
    boolean retainAll(Collection<E> c);

    /**
     * Set object at index to new Object.
     * @param index - index of item to be set to.
     * @param item - item to be added to index.
     * @return Object previously at index.
     * @throws IndexOutOfBoundsException on index <0
     * @throws IndexOutOfBoundsException on index >= size().
     * @throws NullPointerException on null Object.
     */
    E set(int index, E item);

    /**
     * Get size of List.
     * @return Integer size of list.
     */
    int size();

    /**
     * Get subList of List
     * @param firstIndex start index of List to generate subList
     * @param secondIndex end index of List to generate subList
     * @throws IndexOutOfBoundsException if first index is smaller than 0
     * @throws IndexOutOfBoundsException if secondIndex is smaller than 0
     * @throws IndexOutOfBoundsException if first index is larger than list size
     * @throws IndexOutOfBoundsException if second index is bigger than list size
     * @throws IndexOutOfBoundsException if first index is larger than second index
     * @return new CustomList sublist of CustomList
     */
    CustomList subList(int firstIndex, int secondIndex);

    /**
     * Get List as Array.
     * @throws NullPointerException if list is empty.
     * @return T[] array of List.
     */
    E[] toArray();

    /**
     * Get List object as String
     * @return String representation of List
     */
    String toString();
}