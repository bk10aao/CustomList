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

| Method                    | CustomList                     | ArrayList                             |    Winner    |
|---------------------------|--------------------------------|---------------------------------------|:------------:|
| add(E)                    | O(1) amortized, O(n) worst     | O(1) amortized, O(n) worst            |     Tie      |
| add(int, E)               | O(n)                           | O(n)                                  |     Tie      |
| addAll(Collection)        | O(m) amortized, O(n + m) worst | O(m) amortized, O(n + m) worst        |     Tie      |
| addAll(int, Collection)   | O(n + m)                       | O(n + m)                              |     Tie      |
| clear()                   | O(n)                           | O(n)                                  |     Tie      |
| contains(Object)          | O(n)                           | O(n)                                  |     Tie      |
| containsAll(Collection)   | O(n * m)                       | O(n * m)                              |     Tie      |
| equals(Object)            | O(n)                           | O(n)                                  |     Tie      |
| get(int)                  | O(1)                           | O(1)                                  |     Tie      |
| hashCode()                | O(n)                           | O(n)                                  |     Tie      |
| indexOf(Object)           | O(n)                           | O(n)                                  |     Tie      |
| isEmpty()                 | O(1)                           | O(1)                                  |     Tie      |
| iterator()                | O(1)                           | O(1)                                  |     Tie      |
| iterator().next()         | O(1)                           | O(1)                                  |     Tie      |
| listIterator()            | O(1)                           | O(1)                                  |     Tie      |
| listIterator(int)         | O(1)                           | O(1)                                  |     Tie      |
| listIterator().next()     | O(1)                           | O(1)                                  |     Tie      |
| listIterator().previous() | O(1)                           | O(1)                                  |     Tie      |
| listIterator().add(E)     | O(n)                           | O(n)                                  |     Tie      |
| listIterator().set(E)     | O(1)                           | O(1)                                  |     Tie      |
| listIterator().remove()   | O(n)                           | O(n)                                  |     Tie      |
| lastIndexOf(Object)       | O(n)                           | O(n)                                  |     Tie      |
| remove(int)               | O(n)                           | O(n)                                  |     Tie      |
| remove(Object)            | O(n)                           | O(n)                                  |     Tie      |
| removeAll(Collection)     | O(n + m) average               | O(n * m) worst *(when passed a List)* |  CustomList  |
| retainAll(Collection)     | O(n + m) average               | O(n * m) worst *(when passed a List)* |  CustomList  |
| set(int, E)               | O(1)                           | O(1)                                  |     Tie      |
| size()                    | O(1)                           | O(1)                                  |     Tie      |
| subList(int, int)         | O(1)                           | O(1)                                  |     Tie      |
| toArray()                 | O(n)                           | O(n)                                  |     Tie      |
| toArray(T[])              | O(n)                           | O(n)                                  |     Tie      |
| toString()                | O(n)                           | O(n)                                  |     Tie      |

# Space Complexity

| Method                    | CustomList     | ArrayList      |   Winner    |
|---------------------------|----------------|----------------|:-----------:|
| add(E)                    | O(1) auxiliary | O(1) auxiliary |     Tie     |
| add(int, E)               | O(1) auxiliary | O(1) auxiliary |     Tie     |
| addAll(Collection)        | O(m)           | O(m)           |     Tie     |
| addAll(int, Collection)   | O(m)           | O(m)           |     Tie     |
| clear()                   | O(1)           | O(1)           |     Tie     |
| contains(Object)          | O(1)           | O(1)           |     Tie     |
| containsAll(Collection)   | O(1)           | O(1)           |     Tie     |
| equals(Object)            | O(1)           | O(1)           |     Tie     |
| get(int)                  | O(1)           | O(1)           |     Tie     |
| hashCode()                | O(1)           | O(1)           |     Tie     |
| indexOf(Object)           | O(1)           | O(1)           |     Tie     |
| isEmpty()                 | O(1)           | O(1)           |     Tie     |
| iterator()                | O(1)           | O(1)           |     Tie     |
| iterator().next()         | O(1)           | O(1)           |     Tie     |
| listIterator()            | O(1)           | O(1)           |     Tie     |
| listIterator(int)         | O(1)           | O(1)           |     Tie     |
| listIterator().next()     | O(1)           | O(1)           |     Tie     |
| listIterator().previous() | O(1)           | O(1)           |     Tie     |
| listIterator().add(E)     | O(1) auxiliary | O(1) auxiliary |     Tie     |
| listIterator().set(E)     | O(1)           | O(1)           |     Tie     |
| listIterator().remove()   | O(1)           | O(1)           |     Tie     |
| lastIndexOf(Object)       | O(1)           | O(1)           |     Tie     |
| remove(int)               | O(1)           | O(1)           |     Tie     |
| remove(Object)            | O(1)           | O(1)           |     Tie     |
| removeAll(Collection)     | O(m) auxiliary | O(1) auxiliary |  ArrayList  |
| retainAll(Collection)     | O(m) auxiliary | O(1) auxiliary |  ArrayList  |
| set(int, E)               | O(1)           | O(1)           |     Tie     |
| size()                    | O(1)           | O(1)           |     Tie     |
| subList(int, int)         | O(1)           | O(1)           |     Tie     |
| toArray()                 | O(n)           | O(n)           |     Tie     |
| toArray(T[])              | O(n) worst     | O(n) worst     |     Tie     |
| toString()                | O(n)           | O(n)           |     Tie     |

**Legend**:
- `n`: Number of elements in the list.
- `m`: Number of elements in the input collection.
- `k`: Number of elements in the sublist (`toIndex - fromIndex`).

# Performance Charts

#### Note: The following performance charts are designed to be viewed in dark mode.

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


























