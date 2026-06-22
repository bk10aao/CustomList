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
| `add(T)`                     | 129842          | 134050               | **Custom** | 1.03x  |
| `add(int, T)`                | 39987587        | 39869189             |  **Tie**   |  1.0x  |
| `addAll(Collection<T>)`      | 17335           | 16984                |  **JDK**   | 1.02x  |
| `addAll(int, Collection<T>)` | 16144           | 17117                | **Custom** | 1.06x  |
| `clear()`                    | 40862           | 20518                |  **JDK**   | 1.99x  |
| `contains(T)`                | 20741947        | 25823647             | **Custom** | 1.24x  |
| `containsAll(List<T>)`       | 251168          | 251035               |  **Tie**   |  1.0x  |
| `get(int)`                   | 55673           | 81834                | **Custom** | 1.47x  |
| `indexOf(Object)`            | 27907925        | 27420772             |  **JDK**   | 1.02x  |
| `isEmpty()`                  | 3591            | 2943                 |  **JDK**   | 1.22x  |
| `iterator().next()`          | 118878          | 84016                |  **JDK**   | 1.41x  |
| `listIterator().add(T)`      | 227499          | 226641               |  **Tie**   |  1.0x  |
| `listIterator().set(T)`      | 195600          | 168727               |  **JDK**   | 1.16x  |
| `listIterator().remove()`    | 39658450        | 39555930             |  **Tie**   |  1.0x  |
| `lastIndexOf(Object)`        | 181425136       | 166173874            |  **JDK**   | 1.09x  |
| `remove(int)`                | 123813          | 167557               | **Custom** | 1.35x  |
| `remove(T)`                  | 40609898        | 39832145             |  **JDK**   | 1.02x  |
| `removeAll(Collection<T>)`   | 210603          | 210612               |  **Tie**   |  1.0x  |
| `retainAll(Collection<T>)`   | 157239          | 199319               | **Custom** | 1.27x  |
| `set(int, T)`                | 176908          | 183415               | **Custom** | 1.04x  |
| `size()`                     | 27              | 138                  | **Custom** | 4.97x  |
| `subList(int, int)`          | 3151            | 3797                 | **Custom** | 1.21x  |
| `toArray()`                  | 8377            | 8395                 |  **Tie**   |  1.0x  |
| `equals(Object)`             | 71602           | 44334                |  **JDK**   | 1.62x  |
| `hashCode()`                 | 51916           | 50897                |  **JDK**   | 1.02x  |
| `toString()`                 | 585878          | 558610               |  **JDK**   | 1.05x  |

#### Note: The following performance charts are designed to be viewed in dark mode.
![Combined Performance Charts](PerformanceTesting/geometric_mean.png)
![Combined Performance Charts](PerformanceTesting/heatmap.png)
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