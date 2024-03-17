import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class CustomList<T> implements List<T> {

    int listSize = 32;
    int size = 0;
    int nextIndex = 0;

    private T[] list;

    public CustomList() {
        this.list = (T[]) new Object[32];
    }

    public CustomList(int size) {
        if(size < 32) {
            this.list = (T[]) new Object[32];
        } else {
            this.listSize = size;
            this.list = (T[]) new Object[size];
        }
    }

    public boolean add(T item) {
        try {
            list[nextIndex++] = item;
            size++;
            if(nextIndex == listSize) expand();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addAll(Collection<T> values) {
        for(int i = 0; i < values.size(); i++) {
            add(values.iterator().next());
        }
        return true;
    }

    public void clear() {
        list = (T[]) new Object[32];
        listSize = 32;
        size = 0;
    }


    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(ArrayList<T> collection) {
        if(collection == null) {
            throw new NullPointerException();
        }
        for(T i : collection) {
            if (!contains(i))
                return false;
        }
        return true;
    }

    public Iterator iterator() {
        return Arrays.stream(list).filter(Objects::nonNull).iterator();
    }

    public T[] toArray() {
        return (T[]) Arrays.stream(list).filter(Objects::nonNull).toArray();
    }

    private void expand() {
        listSize *= 2;
        T[] temp = (T[]) new Object[listSize];
        System.arraycopy(list, 0, temp, 0, list.length);
        list = temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomList<?> that = (CustomList<?>) o;
        return listSize == that.listSize && size == that.size && nextIndex == that.nextIndex && Arrays.equals(list, that.list);
    }

    public T get(int index) {
        if(index > size) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    public int indexOf(Object o) {
        if(o == null)
            throw new NullPointerException();
        for(int i = 0; i < size; i++) {
            if(list[i].equals(o))
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(listSize, size, nextIndex);
        result = 31 * result + Arrays.hashCode(list);
        return result;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if(index >= size)
            throw new IndexOutOfBoundsException();
        list[index] = null;
        T[] copy = (T[]) new Object[listSize];
        int insertIndex = 0;
        for(int i = 0; i < size; i++)
            if (list[i] != null)
                copy[insertIndex++] = list[i];
        size--;
        list = copy;
        if (nextIndex - 1 == -1)
            nextIndex = 0;
        else
            nextIndex--;
        if(size  < listSize / 4) {
            reduce();
        }
    }

    private void reduce() {
        if(size <= 8) {
            T[] temp  = (T[]) new Object[32];
            for(int i = 0; i <= size + 1; i++) {
                temp[i] = list[i];
            }
            list = temp;
            listSize = 32;
        }
    }
}