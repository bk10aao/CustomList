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

| Method                        |     Custom      |       JDK        | Winner |
|:------------------------------|:---------------:|:----------------:|:------:|
| **constructor()**             |     $O(1)$      |      $O(1)$      |  Tie   |
| **constructor(int)**          |     $O(1)$      |      $O(1)$      |  Tie   |
| **constructor(Collection)**   |     $O(m)$      |      $O(m)$      |  Tie   |
| **add(E)**                    |     $O(1)$      |      $O(1)$      |  Tie   |
| **add(int, E)**               |     $O(n)$      |      $O(n)$      |  Tie   |
| **addAll(Collection)**        |     $O(m)$      |      $O(m)$      |  Tie   |
| **addAll(int, Collection)**   |   $O(n + m)$    |    $O(n + m)$    |  Tie   |
| **clear()**                   |     $O(n)$      |      $O(n)$      |  Tie   |
| **contains(Object)**          |     $O(n)$      |      $O(n)$      |  Tie   |
| **containsAll(Collection)**   | $O(n \times m)$ | $O(n \times  m)$ |  Tie   |
| **equals(Object)**            |     $O(n)$      |      $O(n)$      |  Tie   |
| **get(int)**                  |     $O(1)$      |      $O(1)$      |  Tie   |
| **hashCode()**                |     $O(n)$      |      $O(n)$      |  Tie   |
| **indexOf(Object)**           |     $O(n)$      |      $O(n)$      |  Tie   |
| **isEmpty()**                 |     $O(1)$      |      $O(1)$      |  Tie   |
| **iterator()**                |     $O(1)$      |      $O(1)$      |  Tie   |
| **iterator().next()**         |     $O(1)$      |      $O(1)$      |  Tie   |
| **listIterator()**            |     $O(1)$      |      $O(1)$      |  Tie   |
| **listIterator(int)**         |     $O(1)$      |      $O(1)$      |  Tie   |
| **listIterator().next()**     |     $O(1)$      |      $O(1)$      |  Tie   |
| **listIterator().previous()** |     $O(1)$      |      $O(1)$      |  Tie   |
| **listIterator().add(E)**     |     $O(n)$      |      $O(n)$      |  Tie   |
| **listIterator().set(E)**     |     $O(1)$      |      $O(1)$      |  Tie   |
| **listIterator().remove()**   |     $O(n)$      |      $O(n)$      |  Tie   |
| **lastIndexOf(Object)**       |     $O(n)$      |      $O(n)$      |  Tie   |
| **remove(int)**               |     $O(n)$      |      $O(n)$      |  Tie   |
| **remove(Object)**            |     $O(n)$      |      $O(n)$      |  Tie   |
| **removeAll(Collection)**     |   $O(n + m)$    | $O(n \times m)$  | Custom |
| **retainAll(Collection)**     |   $O(n + m)$    | $O(n \times m)$  | Custom |
| **set(int, E)**               |     $O(1)$      |      $O(1)$      |  Tie   |
| **size()**                    |     $O(1)$      |      $O(1)$      |  Tie   |
| **subList(int, int)**         |     $O(1)$      |      $O(1)$      |  Tie   |
| **toArray()**                 |     $O(n)$      |      $O(n)$      |  Tie   |
| **toArray(T[])**              |     $O(n)$      |      $O(n)$      |  Tie   |
| **toString()**                |     $O(n)$      |      $O(n)$      |  Tie   |

# Space Complexity

| Method                        | Custom |  JDK   | Winner |
|:------------------------------|:------:|:------:|:------:|
| **constructor()**             | $O(1)$ | $O(1)$ |  Tie   |
| **constructor(int)**          | $O(1)$ | $O(1)$ |  Tie   |
| **constructor(Collection)**   | $O(m)$ | $O(m)$ |  Tie   |
| **add(E)**                    | $O(1)$ | $O(1)$ |  Tie   |
| **add(int, E)**               | $O(1)$ | $O(1)$ |  Tie   |
| **addAll(Collection)**        | $O(m)$ | $O(m)$ |  Tie   |
| **addAll(int, Collection)**   | $O(m)$ | $O(m)$ |  Tie   |
| **clear()**                   | $O(1)$ | $O(1)$ |  Tie   |
| **contains(Object)**          | $O(1)$ | $O(1)$ |  Tie   |
| **containsAll(Collection)**   | $O(1)$ | $O(1)$ |  Tie   |
| **equals(Object)**            | $O(1)$ | $O(1)$ |  Tie   |
| **get(int)**                  | $O(1)$ | $O(1)$ |  Tie   |
| **hashCode()**                | $O(1)$ | $O(1)$ |  Tie   |
| **indexOf(Object)**           | $O(1)$ | $O(1)$ |  Tie   |
| **isEmpty()**                 | $O(1)$ | $O(1)$ |  Tie   |
| **iterator()**                | $O(1)$ | $O(1)$ |  Tie   |
| **listIterator()**            | $O(1)$ | $O(1)$ |  Tie   |
| **listIterator(int)**         | $O(1)$ | $O(1)$ |  Tie   |
| **listIterator().next()**     | $O(1)$ | $O(1)$ |  Tie   |
| **listIterator().previous()** | $O(1)$ | $O(1)$ |  Tie   |
| **listIterator().add(E)**     | $O(1)$ | $O(1)$ |  Tie   |
| **listIterator().set(E)**     | $O(1)$ | $O(1)$ |  Tie   |
| **listIterator().remove()**   | $O(1)$ | $O(1)$ |  Tie   |
| **lastIndexOf(Object)**       | $O(1)$ | $O(1)$ |  Tie   |
| **remove(int)**               | $O(1)$ | $O(1)$ |  Tie   |
| **remove(Object)**            | $O(1)$ | $O(1)$ |  Tie   |
| **removeAll(Collection)**     | $O(m)$ | $O(1)$ |  JDK   |
| **retainAll(Collection)**     | $O(m)$ | $O(1)$ |  JDK   |
| **set(int, E)**               | $O(1)$ | $O(1)$ |  Tie   |
| **size()**                    | $O(1)$ | $O(1)$ |  Tie   |
| **subList(int, int)**         | $O(1)$ | $O(1)$ |  Tie   |
| **toArray()**                 | $O(n)$ | $O(n)$ |  Tie   |
| **toArray(T[])**              | $O(n)$ | $O(n)$ |  Tie   |
| **toString()**                | $O(n)$ | $O(n)$ |  Tie   |

**Legend**:
- `n`: Number of elements in the list (the receiver).
- `m`: Number of elements in the input collection (the argument).

# Performance Charts

Comparison table uses the average JMH score (ns/op) across sizes 10k–100k.

| Method                       | Custom (ns/op)    | JDK (ns/op)         |            Winner            |  Margin   |
|:-----------------------------|:------------------|:--------------------|:----------------------------:|:---------:|
| `constructor()`              | 27                | 25                  | **Statistically Equivalent** |   1.06x   |
| `constructor(int)`           | 2,335             | 2,282               | **Statistically Equivalent** |   1.02x   |
| `constructor(Collection)`    | 22,692            | 6,996               |           **JDK**            |   3.24x   |
| `add(T)`                     | 131,456           | 137,837             | **Statistically Equivalent** |   1.05x   |
| `add(int, T)`                | 172,809,146       | 172,508,926         | **Statistically Equivalent** |   1.00x   |
| `addAll(Collection<T>)`      | 23,294            | 15,874              |           **JDK**            |   1.47x   |
| `addAll(int, Collection<T>)` | 23,461            | 15,844              |           **JDK**            |   1.48x   |
| `clear()`                    | 36,572            | 20,291              |           **JDK**            |   1.80x   |
| `contains(T)`                | 23,715,246        | 23,711,892          | **Statistically Equivalent** |   1.00x   |
| `containsAll(List<T>)`       | 32,815            | 238,486             |          **Custom**          |   7.27x   |
| `get(int)`                   | 28,531            | 12,505              |           **JDK**            |   2.28x   |
| `indexOf(Object)`            | 24,840,036        | 23,116,613          | **Statistically Equivalent** |   1.07x   |
| `isEmpty()`                  | 22,500            | 6,821               |           **JDK**            |   3.30x   |
| `iterator().next()`          | 39,816            | 23,062              |           **JDK**            |   1.73x   |
| `listIterator().add(T)`      | 172,918           | 173,383             | **Statistically Equivalent** |   1.00x   |
| `listIterator().set(T)`      | 104,030           | 113,425             | **Statistically Equivalent** |   1.09x   |
| `listIterator().remove()`    | 170,895,132       | 170,551,306         | **Statistically Equivalent** |   1.00x   |
| `lastIndexOf(Object)`        | 235,379,712       | 218,047,877         | **Statistically Equivalent** |   1.08x   |
| `remove(int)`                | 168,998           | 72,410              |           **JDK**            |   2.33x   |
| `remove(T)`                  | 171,446,102       | 171,678,344         | **Statistically Equivalent** |   1.00x   |
| `removeAll(Collection<T>)`   | 406,091           | 613,281,857         |          **Custom**          | 1,510.21x |
| `retainAll(Collection<T>)`   | 413,416           | 621,401,017         |          **Custom**          | 1,503.09x |
| `set(int, T)`                | 108,404           | 92,333              |           **JDK**            |   1.17x   |
| `size()`                     | 34,391            | 6,942               |           **JDK**            |   4.95x   |
| `subList(int, int)`          | 24,139            | 6,974               |           **JDK**            |   3.46x   |
| `toArray()`                  | 31,907            | 14,591              |           **JDK**            |   2.19x   |
| `equals(Object)`             | 67,753            | 36,355              |           **JDK**            |   1.86x   |
| `hashCode()`                 | 72,009            | 56,503              |           **JDK**            |   1.27x   |
| `toString()`                 | 786,359           | 790,315             | **Statistically Equivalent** |   1.01x   |

#### Note: The following performance charts are designed to be viewed in dark mode.
![Combined Performance Charts](PerformanceTesting/heatmap.png)
![Combined Performance Charts](PerformanceTesting/plot_constructor__.png)
![Combined Performance Charts](PerformanceTesting/plot_constructor_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_constructor_Collection_.png)
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