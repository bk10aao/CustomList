import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Benjamin Kane
 * A resizable array-backed implementation of the {@link List} interface that
 * does not permit {@code null} elements.
 *
 * <p>This implementation provides all optional list operations, runs in
 * amortized constant time for additions at the end of the list, and resizes
 * dynamically with a growth factor of 1.5. Capacity is never reduced below
 * 32 elements.</p>
 *
 * <p>This class is not synchronized.</p>
 *
 * @param <E> the type of elements in this list
 * LinkedIn - <a href="https://www.linkedin.com/in/benjamin-kane-81149482/"/>
 * GitHub account bk10aao - <a href="https://github.com/bk10aao"/>
 * Repository - <a href="https://github.com/bk10aao/CustomList"/>
 * <E> – the type of elements in this list
 */
public class CustomList<E> implements List<E> {

    private int capacity = 32;

    private static final int GROWTH_FACTOR = 10;
    private static final int MINIMUM_CAPACITY = 32;
    private int size = 0;

    private E[] list;

    /**
     * Constructs an empty list.
     */
    public CustomList() {
        this.list = (E[])Array.newInstance(Object.class, MINIMUM_CAPACITY);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity  the initial capacity of the list
     **/
    public CustomList(final int initialCapacity) {
        this.capacity = Math.max(initialCapacity, MINIMUM_CAPACITY);
        this.list = (E[]) Array.newInstance(Object.class, capacity);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean add(final E e) {
        if(e == null)
            throw new NullPointerException();
        ensureCapacity(size + 1);
        list[size++] = e;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right.
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index > size()})
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        if(element == null)
            throw new NullPointerException();
        ensureCapacity(size + 1);
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = element;
        size++;
    }

    /**
     * Appends all elements in the specified collection to the end of this list, in the order returned by the
     * collection's iterator.
     *
     * @param values collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection or any of its elements is null
     */
    @Override
    public boolean addAll(final Collection<? extends E> values) {
        if(values == null)
            throw new NullPointerException();
        if(values.isEmpty())
            return false;
        ensureCapacity(size + values.size());
        int oldSize = size;
        for (E value : values) {
            if(value == null)
                throw new NullPointerException();
            list[size++] = value;
        }
        return size != oldSize;
    }

    /**
     * Inserts all elements in the specified collection into this list, starting at the specified position. Shifts the
     * element currently at that position and subsequent elements to the right.
     *
     * @param index index at which to insert the first element from the
     *              specified collection
     * @param c collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index > size()})
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        if (c == null)
            throw new NullPointerException();
        if(index == size)
            return addAll(c);
        return insert(index, c);
    }

    /**
     * Removes all elements from this list.
     */
    @Override
    public void clear() {
        this.list = (E[])Array.newInstance(Object.class, MINIMUM_CAPACITY);
        capacity = MINIMUM_CAPACITY;
        size = 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element. .
     *
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean contains(final Object o) {
        if(o == null)
            throw new NullPointerException();
        return indexOf(o) != -1;
    }

    /**
     * Returns {@code true} if this list contains all elements in Collection.
     *
     * @param c collection to check for all values in CustomList
     * @return {@code true} if this list contains all elements in collection
     * @throws NullPointerException if the specified collection or any of its elements is null
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        if(c == null)
            throw new NullPointerException();
        for (Object i : c) {
            if (i == null)
                throw new NullPointerException();
            if(indexOf(i) == -1)
                return false;
        }
        return true;
    }

    /**
     * Compares the specified object with this list for equality. Returns true if and only if the specified object is
     * also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal.
     * @param o the object to be compared for equality with this list
     * @return {@code true} if the specified object is equal to this list
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof List<?> other))
            return false;
        if (size != other.size())
            return false;
        Iterator<?> otherIterator = other.iterator();
        for (int i = 0; i < size; i++)
            if (!Objects.equals(list[i], otherIterator.next()))
                return false;
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E get(final int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return list[index];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < size; i++)
            result = 31 * result + Objects.hashCode(list[i]);
        return result;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1.
     * {@code Objects.equals(o, get(i))},
     */
    @Override
    public int indexOf(final Object o) {
        if(o == null)
            throw new NullPointerException();
        for(int i = 0; i < size; i++)
            if (list[i].equals(o))
                return i;
        return -1;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return list[index++];
            }
        };
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1.
     */
    @Override
    public int lastIndexOf(final Object o) {
        if(o == null)
            throw new NullPointerException();
        for(int i = size - 1; i >= 0; i--)
            if (list[i].equals(o))
                return i;
        return -1;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public ListIterator<E> listIterator() {
        return new CustomListIterator(0);
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     * @param index the index of the start of List Iterator
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        return new CustomListIterator(index);
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E remove(final int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        E o = list[index];
        for (int i = index; i < size - 1; i++)
            list[i] = list[i + 1];
        list[size - 1] = null;
        size--;
        if (size < capacity / 2 && capacity > MINIMUM_CAPACITY)
            reduce();
        return o;
    }


    /**
     * Removes the Object from list.
     *
     * @param object the index of the element to be removed
     * @return true if removed from list
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public boolean remove(final Object object) {
        if(object == null)
            throw new NullPointerException();
        int index = indexOf(object);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Removes from this list all elements that are contained in the specified collection.
     *
     * @param c collection containing elements to be removed from this list
     * @return {@code true} if this list changed
     * @throws NullPointerException if the specified collection or any of its elements is null
     * @see Collection#contains(Object)
     */
    @Override
    public boolean removeAll(Collection<?> c){
        if (c == null)
            throw new NullPointerException();
        if(c.contains(null))
            throw new NullPointerException();
        boolean changed = false;
        java.util.Set<?> set = (c instanceof java.util.Set) ? (java.util.Set<?>) c : new java.util.HashSet<>(c);
        int index = 0;
        for (int r = 0; r < size; r++)
            if (!set.contains(list[r]))
                list[index++] = list[r];
            else
                changed = true;
        for (int i = index; i < size; i++)
            list[i] = null;
        size = index;
        if (size < capacity / 2 && capacity > MINIMUM_CAPACITY)
            reduce();
        return changed;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection. Removes all other
     * elements from this list.
     *
     * @param c collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     * @see Collection#contains(Object)
     */
    @Override
    public boolean retainAll(final Collection<?> c) {
        if (c == null)
            throw new NullPointerException();
        java.util.Set<?> set = (c instanceof java.util.Set) ? (java.util.Set<?>) c : new java.util.HashSet<>(c);
        boolean changed = false;
        int index = 0;
        for (int i = 0; i < size; i++)
            if (set.contains(list[i]))
                list[index++] = list[i];
            else
                changed = true;
        for (int i = index; i < size; i++)
            list[i] = null;
        size = index;
        if (size < capacity / 2 && capacity > MINIMUM_CAPACITY)
            reduce();
        return changed;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public E set(final int index, final E element) {
        if(element == null)
            throw new NullPointerException();
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        E replaced = list[index];
        list[index] = element;
        return replaced;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a new list containing the portion of this list between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive. If
     * {@code fromIndex} and {@code toIndex} are equal, the returned list is empty.
     * Note: The returned list is a copy, not a view backed by the original.
     *
     * @param fromIndex index of the first element (inclusive)
     * @param toIndex index after the last element (exclusive)
     * @return a new list containing the specified range of elements
     * @throws IndexOutOfBoundsException if {@code fromIndex < 0}, {@code toIndex > size()},
     * or {@code fromIndex > toIndex}
     */
    @Override
    public CustomList<E> subList(final int fromIndex, final int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        int subListSize = toIndex - fromIndex;
        CustomList<E> subList = new CustomList<>(subListSize);
        System.arraycopy(list, fromIndex, subList.list, 0, subListSize);
        subList.size = subListSize;
        return subList;
    }

    /**
     * Returns an array containing all the elements in this list in proper sequence (from first to last element).
     *
     * @return an array containing all the elements in this list in proper sequence
     */
    @Override
    public E[] toArray() {
        return Arrays.copyOf(list, size);
    }

    /**
     * Returns an array containing all the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.  If the list fits in the
     * specified array, it is returned therein.  Otherwise, a new array is
     * allocated with the runtime type of the specified array and the size of
     * this list.
     *
     * @param a the array into which the elements of the list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of the list
     * @throws ArrayStoreException if the runtime type of the specified array
     *         is not a supertype of the runtime type of every element in
     *         this list
     * @throws NullPointerException if the specified array is null
     */
    @Override
    @SuppressWarnings("SuspiciousSystemArraycopy")
    public <T> T[] toArray(T[] a) {
        if (a == null)
            throw new NullPointerException();
        if (a.length < size)
            return (T[]) Arrays.copyOf(list, size, a.getClass());
        System.arraycopy(list, 0, a, 0, size);
        if(a.length > size)
            a[size] = null;
        return a;
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string in the format {@code CustomList{size=<size>, list=<elements>}}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CustomList{size=").append(size).append(", list=[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]);
            if (i < size - 1)
                sb.append(", ");
        }
        return sb.append("]}").toString();
    }

    /**
     * Reduces the size of the array when removing items.
     */
    private void reduce() {
        int newCapacity = Math.max(capacity / GROWTH_FACTOR, MINIMUM_CAPACITY);
        E[] temp = (E[]) Array.newInstance(Object.class, newCapacity);
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
        capacity = newCapacity;
    }

    /**
     * Inserts, shifts and resizes list based on insertion index.
     * @param index the index for collection to be inserted into
     * @param c the collection of values to be inserted
     * @return true if list has changed
     */
    private boolean insert(int index, Collection<? extends E> c) {
        if(c.isEmpty())
            return false;
        ensureCapacity(size + c.size());
        int oldSize = size;
        System.arraycopy(list, index, list, index + c.size(), size - index);
        int updateIndex = index;
        for(E o : c) {
            if(o == null)
                throw new NullPointerException();
            list[updateIndex++] = o;
        }
        size += c.size();
        return size != oldSize;
    }

    /**
     * Ensures correct capacity when resizing list based on add or remove methods.
     * @param required the new capacity required by the list.
     */
    private void ensureCapacity(int required) {
        if (required > capacity) {
            int newCapacity = Math.max(required, Math.max(capacity * GROWTH_FACTOR, MINIMUM_CAPACITY));
            E[] temp = (E[]) Array.newInstance(Object.class, newCapacity);
            System.arraycopy(list, 0, temp, 0, size);
            list = temp;
            capacity = newCapacity;
        }
    }

    /**
     * A custom implementation of ListIterator
     */
    private class CustomListIterator implements ListIterator<E> {
        private int index;
        private int lastReturned = -1;
        private boolean canModify = false;

        CustomListIterator(int index) {
            this.index = index;
        }

        public void add(E e) {
            if (e == null)
                throw new NullPointerException();
            ensureCapacity(size + 1);
            System.arraycopy(list, index, list, index + 1, size - index);
            list[index] = e;
            size++;
            index++;
            canModify = false;
        }

        public boolean hasNext() {
            return index < size;
        }

        public boolean hasPrevious() {
            return index > 0;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = index;
            index++;
            canModify = true;
            return list[lastReturned];
        }

        public int nextIndex() {
            return index;
        }

        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            index--;
            lastReturned = index;
            canModify = true;
            return list[lastReturned];
        }

        public int previousIndex() {
            return index - 1;
        }

        public void remove() {
            if (!canModify)
                throw new IllegalStateException();
            if (lastReturned < 0 || lastReturned >= size)
                throw new IllegalStateException();
            for (int i = lastReturned; i < size - 1; i++)
                list[i] = list[i + 1];
            list[size - 1] = null;
            size--;
            index = lastReturned;
            canModify = false;
            if (size < capacity / 2 && capacity > MINIMUM_CAPACITY)
                reduce();
        }

        public void set(E e) {
            if (!canModify)
                throw new IllegalStateException();
            if (lastReturned < 0 || lastReturned >= size)
                throw new IllegalStateException();
            if (e == null)
                throw new NullPointerException();
            list[lastReturned] = e;
        }
    }
}