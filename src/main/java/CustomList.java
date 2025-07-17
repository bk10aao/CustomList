import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
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
        if(values == null)
            throw new NullPointerException();
        Object[] temp = new Object[listSize];
        System.arraycopy(list, 0, temp, 0, size);
        for (T value : values) {
            if(value == null)
                throw new NullPointerException();
            add(value);
        }
        return !Arrays.equals(temp, list);
    }

    public void clear() {
        list = (T[]) new Object[32];
        listSize = 32;
        size = 0;
        nextIndex = 0;
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
            if (i == null)
                throw new NullPointerException();
            if(indexOf(i) == -1)
                return false;
        }
        return true;
    }

    public T get(final int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return list[index];
    }

    public int indexOf(final Object o) {
        if(o == null)
            throw new NullPointerException();
        for(int i = 0; i < size; i++)
            if (list[i].equals(o))
                return i;
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }
            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return list[index++];
            }
        };
    }

    public int lastIndexOf(final Object o) {
        if(o == null)
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
        if(object == null)
            throw new NullPointerException();
        int index = indexOf(object);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public boolean removeAll(final Collection<T> c) {
        if (c == null) throw new NullPointerException();
        boolean changed = false;
        for (T item : c) {
            if (item == null)
                throw new NullPointerException();
            while (indexOf(item) != -1) {
                remove(indexOf(item));
                changed = true;
            }
        }
        return changed;
    }

    public boolean retainAll(final Collection<T> collection) {
        if (collection == null)
            throw new NullPointerException();
        boolean changed = false;
        for (int i = size - 1; i >= 0; i--) {
            if (!collection.contains(list[i])) {
                remove(i);
                changed = true;
            }
        }
        return changed;
    }

    public T set(final int index, final T item) {
        if(item == null)
            throw new NullPointerException();
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        T replaced = list[index];
        list[index] = item;
        return replaced;
    }

    public int size() {
        return size;
    }

    public CustomList subList(final int firstIndex, final int secondIndex) {
        if (firstIndex < 0 || firstIndex > size || secondIndex < firstIndex || secondIndex > size)
            throw new IndexOutOfBoundsException();
        CustomList<T> subList = new CustomList(Math.max(32, secondIndex - firstIndex));
        for (int i = firstIndex; i < secondIndex; i++)
            subList.add(list[i]);
        return subList;
    }

    public T[] toArray() {
        T[] result = (T[]) java.lang.reflect.Array.newInstance(list.getClass().getComponentType(), size);
        System.arraycopy(list, 0, result, 0, size);
        return result;
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
            if (!Objects.equals(list[i], customOther.get(i)))
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < size; i++)
            result = 31 * result + list[i].hashCode();
        return result;
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
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }

    private void reduce() {
        listSize = Math.max(32, listSize / 2);
        T[] temp = (T[]) new Object[listSize];
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }
}