import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class CustomList<T> implements List<T> {

    public int listSize = 32;
    private int size = 0;
    private int nextIndex = 0;

    private T[] list;

    public CustomList() {
        this.list = (T[]) new Object[32];
    }

    public CustomList(int size) {
        if(size < 32) this.list = (T[]) new Object[32];
        else {
            this.listSize = size;
            this.list = (T[]) new Object[size];
        }
    }

    public boolean add(T item) {
        if(item == null) throw new NullPointerException();
        try {
            list[nextIndex++] = item;
            size++;
            if(nextIndex == listSize) expand();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean addAll(Collection<T> values) {
        Object[] temp = new Object[listSize];
        System.arraycopy(list, 0, temp, 0, listSize);
        for (T value : values) add(value);
        return !Arrays.equals(temp, list);
    }

    public void clear() {
        list = (T[]) new Object[32];
        listSize = 32;
        size = 0;
    }

    public boolean contains(T item) {
        if(item == null) throw new NullPointerException();
        for (int i = 0; i < size; i++)
            if (list[i] != null && list[i].equals(item)) return true;
        return false;
    }

    public boolean containsAll(CustomList<T> collection) {
        if(collection == null) throw new NullPointerException();
        for(T i : collection.toArray())
            if (!contains(i)) return false;
        return true;
    }

    public T get(int index) {
        if(index > size || index < 0) throw new IndexOutOfBoundsException();
        return list[index];
    }

    public Iterator iterator() {
        return Arrays.stream(list).filter(Objects::nonNull).iterator();
    }

    public int indexOf(Object o) {
        if(o == null)
            throw new NullPointerException();
        for(int i = 0; i < size; i++)
            if (list[i].equals(o)) return i;
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean remove(int index) {
        if(index < 0 || index >= nextIndex) throw new IndexOutOfBoundsException();
        list[index] = null;
        shift();
        return true;
    }

    public boolean remove(T object) {
        if(object.equals(null)) throw new NullPointerException();
        if (contains(object)) {
            removeObject(object);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection<T> c) {
        if(c.equals(null)) throw new NullPointerException();
        if(c.isEmpty()) return false;
        int nextCheckIndex = 0;
        for(T item: c) {
            if(item.equals(null)) throw new NullPointerException();
            if(contains(item)) nextCheckIndex = removeObjectCollection(item, nextCheckIndex);
            else return false;
        }
        shift();
        return true;
    }

    public T set(int index, T item) {
        if(item.equals(null)) throw new NullPointerException();
        if(index < 0 || index >= nextIndex) throw new IndexOutOfBoundsException();
        T replaced = list[index];
        list[index] = item;
        return replaced;

    }

    public int size() {
        return size;
    }

    public T[] toArray() {
        return (T[]) Arrays.stream(list).filter(Objects::nonNull).toArray();
    }

    private void removeObject(T object) {
        for (int i = 0; i < list.length; i++) {
            T item = list[i];
            if (item != null && item.equals(object)) {
                list[i] = null;
                shift();
                break;
            }
        }
    }

    private int removeObjectCollection(T object, int checkIndex) {
        for (int i = checkIndex; i < list.length; i++) {
            T item = list[i];
            if (item != null && item.equals(object)) {
                list[i] = null;
                return i + 1;
            }
        }
        return -1;
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

    private void shift() {
        int tempInsertIndex = 0;
        T[] temp = (T[]) new Object[listSize];
        for(int i = 0; i < size; i++)
            if (list[i] != null) temp[tempInsertIndex++] = list[i];
        nextIndex--;
        System.arraycopy(list, 0, temp, 0, --size);
        list = temp;
        if(nextIndex < listSize / 2 && listSize > 32) reduce();
    }

    //TODO: fix Arrays.equals();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomList<?> that = (CustomList<?>) o;
        return listSize == that.listSize && size == that.size && nextIndex == that.nextIndex;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(listSize, size, nextIndex);
        result = 31 * result + Arrays.hashCode(list);
        return result;
    }
}