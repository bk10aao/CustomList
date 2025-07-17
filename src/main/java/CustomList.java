import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CustomList<T> implements ListInterface<T> {

    public int listSize = 32;
    private int size = 0;
    private int nextIndex = 0;

    private T[] list;

    public CustomList() {
        this.list = (T[]) new Object[32];
    }

    public CustomList(final int size) {
        if(size < 32)
            this.list = (T[]) new Object[32];
        else {
            this.listSize = size;
            this.list = (T[]) new Object[size];
        }
    }

    public boolean add(final T item) {
        if(item == null)
            throw new NullPointerException();
        try {
            list[nextIndex++] = item;
            size++;
            if(nextIndex == listSize)
                expand();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean addAll(final Collection<T> values) {
        if(values.equals(null))
            throw new NullPointerException();
        Object[] temp = new Object[listSize];
        System.arraycopy(list, 0, temp, 0, listSize);
        for (T value : values) {
            if(value.equals(null))
                throw new NullPointerException();
            add(value);
        }
        return !Arrays.equals(temp, list);
    }

    public void clear() {
        list = (T[]) new Object[32];
        listSize = 32;
        size = 0;
    }

    public boolean contains(final T item) {
        if(item == null)
            throw new NullPointerException();
        return indexOf(item) != -1;
    }

    public boolean containsAll(final List<T> collection) {
        if(collection == null)
            throw new NullPointerException();
        for (T i : collection) {
            if (i.equals(null))
                throw new NullPointerException();
            if(indexOf(i) == -1)
                return false;
        }
        return true;
    }

    public T get(final int index) {
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException();
        return list[index];
    }

    public int indexOf(final Object o) {
        if(o == null)
            throw new NullPointerException();
        for(int i = 0; i < size; i++) {
            if (list[i] == null)
                continue;
            if (list[i].equals(o))
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator iterator() {
        return Arrays.stream(list).filter(Objects::nonNull).iterator();
    }

    public int lastIndexOf(final Object o) {
        if(o.equals(null))
            throw new NullPointerException();
        for(int i = size - 1; i >= 0; i--)
            if (list[i].equals(o))
                return i;

        return -1;
    }

    public boolean remove(final int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++)
            list[i] = list[i + 1];
        list[size - 1] = null;
        size--;
        nextIndex--;
        if (nextIndex < listSize / 2 && listSize > 32)
            reduce();
        return true;
    }

    public boolean remove(final T object) {
        if(object.equals(null))
            throw new NullPointerException();
        if (indexOf(object) != -1) {
            removeObject(object);
            return true;
        }
        return false;
    }

    public boolean removeAll(final Collection<T> c) {
        if (c == null)
            throw new NullPointerException();
        if(c.isEmpty())
            return false;
        int nextCheckIndex = 0;
        for(T item: c) {
            if(item == null)
                throw new NullPointerException();
            else if(indexOf(item) != -1)
                nextCheckIndex = removeObjectCollection(item, nextCheckIndex);
            else
                return false;
        }
        shift();
        return true;
    }

    public boolean retainAll(final Collection<T> collection) {
        if (collection == null || size == 0)
            throw new NullPointerException();
        boolean changed = false;
        if(collection.isEmpty())
            throw new NullPointerException();
        if(containsAll(collection.stream().toList()))
            for (T t : collection)
                if (remove(t))
                    changed = true;

        return changed;
    }

    public T set(final int index, final T item) {
        if(item.equals(null))
            throw new NullPointerException();
        if(index < 0 || index >= nextIndex)
            throw new IndexOutOfBoundsException();
        T replaced = list[index];
        list[index] = item;
        return replaced;
    }

    public int size() {
        return size;
    }

    public CustomList subList(final int firstIndex, final int secondIndex) {
        if(firstIndex < 0 || firstIndex > size)
            throw new IndexOutOfBoundsException();
        if(secondIndex < firstIndex || secondIndex > size)
            throw new IndexOutOfBoundsException();
        CustomList subList = new CustomList(size);
        Arrays.stream(list, firstIndex, secondIndex).forEach(subList::add);
        return subList;
    }

    public T[] toArray() {
        if(list == null)
            throw new NullPointerException();
        return (T[]) Arrays.stream(list).filter(Objects::nonNull).toArray();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CustomList<?> customOther))
            return false;
        if (size != customOther.size)
            return false;
        for (int i = 0; i < size; i++)
            if (!Objects.equals(list[i], customOther.list[i]))
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(listSize, size, nextIndex) + Arrays.hashCode(list);
    }

    @Override
    public String toString() {
        return "CustomList{" +
                "size=" + size +
                ", list=" + Arrays.toString(toArray()) +
                '}';
    }

    private void expand() {
        listSize *= 2;
        T[] temp = (T[]) new Object[listSize];
        System.arraycopy(list, 0, temp, 0, list.length);
        list = temp;
    }

    private void reduce() {
        listSize = listSize / 2;
        System.arraycopy(list, 0, list, 0, size);
    }

    private void removeObject(final T object) {
        for (int i = 0; i < list.length; i++) {
            T item = list[i];
            if (item != null && item.equals(object)) {
                list[i] = null;
                shift();
                break;
            }
        }
    }

    private int removeObjectCollection(final T object, final int checkIndex) {
        for (int i = checkIndex; i < list.length; i++) {
            T item = list[i];
            if (item != null && item.equals(object)) {
                list[i] = null;
                return i + 1;
            }
        }
        return -1;
    }

    private void shift() {
        int newIndex = 0;
        T[] temp = (T[]) new Object[listSize];
        for (int i = 0; i < size; i++)
            if (list[i] != null)
                temp[newIndex++] = list[i];
        size = newIndex;
        nextIndex = newIndex;
        list = temp;
        if (nextIndex < listSize / 2 && listSize > 32)
            reduce();
    }
}