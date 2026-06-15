# List

Implementation of a List using an array

1. [time complexity](https://github.com/bk10aao/CustomList/tree/main?tab=readme-ov-file#time-complexity)
2. [space complexity](https://github.com/bk10aao/CustomList/tree/main?tab=readme-ov-file#space-complexity)
3. [performance testing](https://github.com/bk10aao/CustomList/blob/main/README.md#performance-charts)

All methods implemented are identical to those found in the Java [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html) interface.

# Build and Test
1. To build and test the project run command `./gradlew clean build`
2. To test the project run command `gradle test --tests CustomListTest`

# Time Complexity

| Method                     |  CustomList  |  ArrayList  | Winner |
|:---------------------------|:------------:|:-----------:|:------:|
| add(E)                     |     O(1)     |    O(1)     |  Tie   |
| add(int, E)                |     O(n)     |    O(n)     |  Tie   |
| addAll(Collection)         |     O(m)     |    O(m)     |  Tie   |
| addAll(int, Collection)    |   O(n + m)   |  O(n + m)   |  Tie   |
| clear()                    |     O(n)     |    O(n)     |  Tie   |
| contains(Object)           |     O(n)     |    O(n)     |  Tie   |
| containsAll(Collection)    |   O(n * m)   |  O(n * m)   |  Tie   |
| equals(Object)             |     O(n)     |    O(n)     |  Tie   |
| get(int)                   |     O(1)     |    O(1)     |  Tie   |
| hashCode()                 |     O(n)     |    O(n)     |  Tie   |
| indexOf(Object)            |     O(n)     |    O(n)     |  Tie   |
| isEmpty()                  |     O(1)     |    O(1)     |  Tie   |
| iterator()                 |     O(1)     |    O(1)     |  Tie   |
| iterator().next()          |     O(1)     |    O(1)     |  Tie   |
| listIterator()             |     O(1)     |    O(1)     |  Tie   |
| listIterator(int)          |     O(1)     |    O(1)     |  Tie   |
| listIterator().next()      |     O(1)     |    O(1)     |  Tie   |
| listIterator().previous()  |     O(1)     |    O(1)     |  Tie   |
| listIterator().add(E)      |     O(n)     |    O(n)     |  Tie   |
| listIterator().set(E)      |     O(1)     |    O(1)     |  Tie   |
| listIterator().remove()    |     O(n)     |    O(n)     |  Tie   |
| lastIndexOf(Object)        |     O(n)     |    O(n)     |  Tie   |
| remove(int)                |     O(n)     |    O(n)     |  Tie   |
| remove(Object)             |     O(n)     |    O(n)     |  Tie   |
| removeAll(Collection)      |   O(n + m)   |  O(n * m)   | Custom |
| retainAll(Collection)      |   O(n + m)   |  O(n * m)   | Custom |
| set(int, E)                |     O(1)     |    O(1)     |  Tie   |
| size()                     |     O(1)     |    O(1)     |  Tie   |
| subList(int, int)          |     O(1)     |    O(1)     |  Tie   |
| toArray()                  |     O(n)     |    O(n)     |  Tie   |
| toArray(T[])               |     O(n)     |    O(n)     |  Tie   |
| toString()                 |     O(n)     |    O(n)     |  Tie   |

# Space Complexity

| Method                     |  CustomList  |  ArrayList  | Winner |
|:---------------------------|:------------:|:-----------:|:------:|
| add(E)                     |     O(1)     |    O(1)     |  Tie   |
| add(int, E)                |     O(1)     |    O(1)     |  Tie   |
| addAll(Collection)         |     O(m)     |    O(m)     |  Tie   |
| addAll(int, Collection)    |     O(m)     |    O(m)     |  Tie   |
| clear()                    |     O(1)     |    O(1)     |  Tie   |
| contains(Object)           |     O(1)     |    O(1)     |  Tie   |
| containsAll(Collection)    |     O(1)     |    O(1)     |  Tie   |
| equals(Object)             |     O(1)     |    O(1)     |  Tie   |
| get(int)                   |     O(1)     |    O(1)     |  Tie   |
| hashCode()                 |     O(1)     |    O(1)     |  Tie   |
| indexOf(Object)            |     O(1)     |    O(1)     |  Tie   |
| isEmpty()                  |     O(1)     |    O(1)     |  Tie   |
| iterator()                 |     O(1)     |    O(1)     |  Tie   |
| iterator().next()          |     O(1)     |    O(1)     |  Tie   |
| listIterator()             |     O(1)     |    O(1)     |  Tie   |
| listIterator(int)          |     O(1)     |    O(1)     |  Tie   |
| listIterator().next()      |     O(1)     |    O(1)     |  Tie   |
| listIterator().previous()  |     O(1)     |    O(1)     |  Tie   |
| listIterator().add(E)      |     O(1)     |    O(1)     |  Tie   |
| listIterator().set(E)      |     O(1)     |    O(1)     |  Tie   |
| listIterator().remove()    |     O(1)     |    O(1)     |  Tie   |
| lastIndexOf(Object)        |     O(1)     |    O(1)     |  Tie   |
| remove(int)                |     O(1)     |    O(1)     |  Tie   |
| remove(Object)             |     O(1)     |    O(1)     |  Tie   |
| removeAll(Collection)      |     O(m)     |    O(1)     |  JDK   |
| retainAll(Collection)      |     O(m)     |    O(1)     |  JDK   |
| set(int, E)                |     O(1)     |    O(1)     |  Tie   |
| size()                     |     O(1)     |    O(1)     |  Tie   |
| subList(int, int)          |     O(1)     |    O(1)     |  Tie   |
| toArray()                  |     O(n)     |    O(n)     |  Tie   |
| toArray(T[])               |     O(n)     |    O(n)     |  Tie   |
| toString()                 |     O(n)     |    O(n)     |  Tie   |

**Legend**:
- `n`: Number of elements in the list.
- `m`: Number of elements in the input collection.
- `k`: Number of elements in the sublist (`toIndex - fromIndex`).

# Performance Charts

Below performance is a comparison made at 100,000 operations per method.

Note: all data is an average of 100 runs.

| Method                       | CustomList (ns) | ArrayList (JDK) (ns) |   Winner   | Margin |
|:-----------------------------|:----------------|:---------------------|:----------:|:------:|
| `add(T)`                     | 129,842.3       | 134,050.4            | **Custom** | 1.03x  |
| `add(int, T)`                | 39,987,587.3    | 39,869,189.7         |  **JDK**   |  1.0x  |
| `addAll(Collection<T>)`      | 17,335.4        | 16,984.0             |  **JDK**   | 1.02x  |
| `addAll(int, Collection<T>)` | 16,144.4        | 17,117.2             | **Custom** | 1.06x  |
| `clear()`                    | 40,862.2        | 20,518.7             |  **JDK**   | 1.99x  |
| `contains(T)`                | 20,741,947.9    | 25,823,647.9         | **Custom** | 1.24x  |
| `containsAll(List<T>)`       | 251,168.9       | 251,035.2            |  **JDK**   |  1.0x  |
| `get(int)`                   | 55,673.7        | 81,834.5             | **Custom** | 1.47x  |
| `indexOf(Object)`            | 27,907,925.4    | 27,420,772.9         |  **JDK**   | 1.02x  |
| `isEmpty()`                  | 3,591.4         | 2,943.8              |  **JDK**   | 1.22x  |
| `iterator().next()`          | 118,878.7       | 84,016.3             |  **JDK**   | 1.41x  |
| `listIterator().add(T)`      | 227,499.6       | 226,641.1            |  **JDK**   |  1.0x  |
| `listIterator().set(T)`      | 195,600.3       | 168,727.7            |  **JDK**   | 1.16x  |
| `listIterator().remove()`    | 39,658,450.5    | 39,555,930.3         |  **JDK**   |  1.0x  |
| `lastIndexOf(Object)`        | 181,425,136.3   | 166,173,874.5        |  **JDK**   | 1.09x  |
| `remove(int)`                | 123,813.1       | 167,557.9            | **Custom** | 1.35x  |
| `remove(T)`                  | 40,609,898.8    | 39,832,145.4         |  **JDK**   | 1.02x  |
| `removeAll(Collection<T>)`   | 210,603.8       | 210,612.9            | **Custom** |  1.0x  |
| `retainAll(Collection<T>)`   | 157,239.7       | 199,319.5            | **Custom** | 1.27x  |
| `set(int, T)`                | 176,908.0       | 183,415.4            | **Custom** | 1.04x  |
| `size()`                     | 27.9            | 138.7                | **Custom** | 4.97x  |
| `subList(int, int)`          | 3,151.1         | 3,797.9              | **Custom** | 1.21x  |
| `toArray()`                  | 8,377.2         | 8,395.5              | **Custom** |  1.0x  |
| `equals(Object)`             | 71,602.9        | 44,334.4             |  **JDK**   | 1.62x  |
| `hashCode()`                 | 51,916.2        | 50,897.9             |  **JDK**   | 1.02x  |
| `toString()`                 | 585,878.8       | 558,610.5            |  **JDK**   | 1.05x  |


#### Note: The following performance charts are designed to be viewed in dark mode.
![Combined Performance Charts](PerformanceTesting/geometric_mean.png)
![Combined Performance Charts](PerformanceTesting/plot_add_T_.png)
![Combined Performance Charts](PerformanceTesting/plot_add_int_T_.png)
![Combined Performance Charts](PerformanceTesting/plot_addAll_CollectionT_.png)
![Combined Performance Charts](PerformanceTesting/plot_addAll_int_CollectionT_.png)
![Combined Performance Charts](PerformanceTesting/plot_clear__.png)
![Combined Performance Charts](PerformanceTesting/plot_contains_T_.png)
![Combined Performance Charts](PerformanceTesting/plot_containsAll_ListT_.png)
![Combined Performance Charts](PerformanceTesting/plot_equals_Object_.png)
![Combined Performance Charts](PerformanceTesting/plot_get_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_hashCode__.png)
![Combined Performance Charts](PerformanceTesting/plot_indexOf_Object_.png)
![Combined Performance Charts](PerformanceTesting/plot_isEmpty__.png)
![Combined Performance Charts](PerformanceTesting/plot_iterator___next__.png)
![Combined Performance Charts](PerformanceTesting/plot_lastIndexOf_Object_.png)
![Combined Performance Charts](PerformanceTesting/plot_listIterator___add_T_.png)
![Combined Performance Charts](PerformanceTesting/plot_listIterator___remove__.png)
![Combined Performance Charts](PerformanceTesting/plot_listIterator___set_T_.png)
![Combined Performance Charts](PerformanceTesting/plot_remove_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_remove_T_.png)
![Combined Performance Charts](PerformanceTesting/plot_removeAll_CollectionT_.png)
![Combined Performance Charts](PerformanceTesting/plot_retainAll_CollectionT_.png)
![Combined Performance Charts](PerformanceTesting/plot_set_int_T_.png)
![Combined Performance Charts](PerformanceTesting/plot_size__.png)
![Combined Performance Charts](PerformanceTesting/plot_subList_int_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_toArray__.png)
![Combined Performance Charts](PerformanceTesting/plot_toString__.png)


























