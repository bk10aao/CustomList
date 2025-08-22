import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements, including null. In addition to implementing the List interface, this class provides methods to manipulate the size of the array that is used internally to store the list.
 * @author Benjamin Kane
 * LinkedIn - <a href="https://www.linkedin.com/in/benjamin-kane-81149482/"/>
 * GitHub account bk10aao - <a href="https://github.com/bk10aao"/>
 * Repository - <a href="https://github.com/bk10aao/CustomSetV2"/>
 * <E> – the type of elements in this list
 */
public class CustomList<E> implements List<E> {

    public int listSize = 32;
    private int size = 0;

    private E[] list;

    /**
     * Constructs an empty list with an initial capacity of 32.
     */
    public CustomList() {
        this.list = (E[])Array.newInstance(Object.class, 32);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     * If the specified capacity is less than 32, the list is initialized with a capacity of 32.
     *
     * @param  initialCapacity  the initial capacity of the list
     **/
    public CustomList(final int initialCapacity) {
        if(initialCapacity < 32)
            this.list = (E[])Array.newInstance(Object.class, 32);
        else {
            this.listSize = initialCapacity;
            this.list = (E[])Array.newInstance(Object.class, initialCapacity);
        }
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws NullPointerException if the specified element is null
     */
    public boolean add(final E e) {
        if(e == null)
            throw new NullPointerException();
        list[size++] = e;
        if(size == listSize)
            expand();
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index > size()})
     * @throws NullPointerException if the specified element is null
     */
    public void add(int index, E element) {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        if(element == null)
            throw new NullPointerException();
        insert(index, List.of(element));
    }

    /**
     * Appends all elements in the specified collection to the end of this list, in the order returned by the collection's iterator. The behavior is undefined if the specified collection is modified during the operation (including if the collection is this list and is non-empty).
     *
     * @param values collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection or any of its elements is null
     */
    public boolean addAll(final Collection<? extends E> values ) {
        if (values == null)
            throw new NullPointerException();
        int oldSize = size;
        for (E value : values)
            add(value);
        return size != oldSize;
    }

    /**
     * Inserts all elements in the specified collection into this list, starting at the specified position. Shifts the element currently at that position (if any) and subsequent elements to the right (increases their indices). The new elements appear in the order returned by the collection's iterator.
     *
     * @param index index at which to insert the first element from the
     *              specified collection
     * @param c collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index > size()})
     * @throws NullPointerException if the specified collection is null
     */
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
     * Removes all elements from this list, resetting it to an empty state with an initial capacity of 32.
     */
    public void clear() {
        list =  (E[])Array.newInstance(Object.class, 32);
        listSize = 32;
        size = 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element. More formally, returns {@code true} if and only if this list contains at least one element {@code e} such that {@code Objects.equals(o, e)}.
     *
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     * @throws NullPointerException if the specified element is null
     */
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
     * Compares the specified object with this list for equality. Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal. (Two elements e1 and e2 are equal if Objects. equals(e1, e2).) In other words, two lists are defined to be equal if they contain the same elements in the same order. This definition ensures that the equals method works properly across different implementations of the List interface.
     * @param o the object to be compared for equality with this list
     * @return {@code true} if the specified object is equal to this list
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CustomList<?> customOther))
            return false;
        if (size != customOther.size)
            return false;
        for (int i = 0; i < size; i++)
            if (!Objects.equals(list[i], customOther.get(i)))
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
    public E get(final int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return list[index];
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < size; i++)
            result = 31 * result + list[i].hashCode();
        return result;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     */
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
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * <p>The returned iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator iterator() {
        return new Iterator<E>() {

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
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the highest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     */
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
    public ListIterator<E> listIterator() {
        return new CustomListIterator(0);
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     * @param index the index of the start of List Iterator
     */
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        return new CustomListIterator(index);
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E remove(final int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        E o = list[index];
        for (int i = index; i < size - 1; i++)
            list[i] = list[i + 1];
        list[size - 1] = null;
        size--;
        if (size < listSize / 2 && listSize > 32)
            reduce();
        return o;
    }


    /**
     * Removes the Object from list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param object the index of the element to be removed
     * @return true if removed from list
     * @throws NullPointerException {@inheritDoc}
     */
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
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection or any of its elements is null
     * @see Collection#contains(Object)
     */
    public boolean removeAll(Collection<?> c){
        if (c == null) throw new NullPointerException();
        boolean changed = false;
        for (Object item : c) {
            if (item == null)
                throw new NullPointerException();
            while (indexOf(item) != -1) {
                remove(indexOf(item));
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection. Removes all other elements from this list.
     *
     * @param c collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     * @see Collection#contains(Object)
     */
    public boolean retainAll(final Collection<?> c) {
        if (c == null)
            throw new NullPointerException();
        boolean changed = false;
        for (int i = size - 1; i >= 0; i--) {
            if (!c.contains(list[i])) {
                remove(i);
                changed = true;
            }
        }
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
    public int size() {
        return size;
    }

    /**
     * Returns a new list containing the portion of this list between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive. If
     * {@code fromIndex} and {@code toIndex} are equal, the returned list is empty.
     * The new list has a minimum initial capacity of 32.
     *
     * @param fromIndex index of the first element (inclusive)
     * @param toIndex index after the last element (exclusive)
     * @return a new list containing the specified range of elements
     * @throws IndexOutOfBoundsException if {@code fromIndex < 0}, {@code toIndex > size()}, or {@code fromIndex > toIndex}
     */
    public CustomList subList(final int fromIndex, final int toIndex) {
        if (fromIndex < 0 || fromIndex > size || toIndex < fromIndex || toIndex > size)
            throw new IndexOutOfBoundsException();
        int subListSize = toIndex - fromIndex;
        CustomList<E> subList = new CustomList<>(Math.max(32, subListSize));
        System.arraycopy(list, fromIndex, subList.list, 0, subListSize);
        subList.size = subListSize;
        return subList;
    }

    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must allocate
     * a new array).  The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list in
     *         proper sequence
     */
    public E[] toArray() {
        E[] result = (E[]) Array.newInstance(list.getClass().getComponentType(), size);
        System.arraycopy(list, 0, result, 0, size);
        return result;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.  If the list fits in the
     * specified array, it is returned therein.  Otherwise, a new array is
     * allocated with the runtime type of the specified array and the size of
     * this list.
     *
     * <p>If the list fits in the specified array with room to spare
     * (i.e., the array has more elements than the list), the element in
     * the array immediately following the end of the collection is set to
     * {@code null}.  (This is useful in determining the length of the
     * list <i>only</i> if the caller knows that the list does not contain
     * any null elements.)
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
    @SuppressWarnings("SuspiciousSystemArraycopy")
    public <T> T[] toArray(T[] a) {
        if (a == null)
            throw new NullPointerException();

        if (a.length >= size) {
            System.arraycopy(list, 0, a, 0, size);
            if (a.length > size) {
                for (int i = size; i < a.length; i++) {
                    a[i] = null;
                }
            }
            return a;
        }
        T[] result = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        System.arraycopy(list, 0, result, 0, size);
        return result;
    }

    /**
     * Returns a string representation of this list, including its size and elements.
     *
     * @return a string in the format {@code CustomList{size=<size>, list=<elements>}}
     */
    @Override
    public String toString() {
        return "CustomList{" +
                "size=" + size +
                ", list=" + Arrays.toString(toArray()) +
                '}';
    }

    private void expand() {
        listSize = (int) (listSize * 1.5);
        E[] temp = (E[]) Array.newInstance(Object.class, listSize);
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }

    private void reduce() {
        listSize = Math.max(32, listSize / 2);
        E[] temp = (E[]) Array.newInstance(Object.class, listSize);
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }

    private boolean insert(int index, Collection<? extends E> c) {
        int oldSize = size;
        E[] newList = (E[]) Array.newInstance(list.getClass().getComponentType(), size + c.size());
        System.arraycopy(list, 0, newList, 0, index);
        int updateIndex = index;
        for(E o : c) {
            if(o == null)
                throw new NullPointerException();
            newList[updateIndex++] = o;
        }
        System.arraycopy(list, index, newList, updateIndex, size - index);
        this.list = newList;
        this.size = size + c.size();
        return size != oldSize;
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

        public boolean hasNext() {
            return index < size;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = index;
            index++;
            canModify = true;
            return list[lastReturned];
        }

        public boolean hasPrevious() {
            return index > 0;
        }

        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            index--;
            lastReturned = index;
            canModify = true;
            return list[lastReturned];
        }

        public int nextIndex() {
            return index;
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

            if (size < listSize / 2 && listSize > 32)
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

        public void add(E e) {
            if (e == null)
                throw new NullPointerException();
            if (size == list.length)
                expand();

            for (int i = size; i > index; i--)
                list[i] = list[i - 1];
            list[index] = e;
            size++;
            index++;
            canModify = false;
        }
    }
}