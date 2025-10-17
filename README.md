# List

Implementation of a List using an array

1. [time complexity](https://github.com/bk10aao/CustomList/tree/main?tab=readme-ov-file#time-complexity)
2. [space complexity](https://github.com/bk10aao/CustomList/tree/main?tab=readme-ov-file#space-complexity)
3. [performance testing](https://github.com/bk10aao/CustomList/blob/main/README.md#performance-charts)

All methods implemented are identical to those found in the Java [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html) interface.

# Time Complexity
| Method                            | CustomList O()                 | ArrayList O()                  | Winner    |
|-----------------------------------|--------------------------------|--------------------------------|-----------|
| add(E)                            | O(1) amortized, O(n) worst     | O(1) amortized, O(n) worst     | Tie       |
| add(int, E)                       | O(n)                           | O(n)                           | Tie       |
| addAll(Collection)                | O(m) amortized, O(n + m) worst | O(m) amortized, O(n + m) worst | Tie       |
| addAll(int, Collection)           | O(n + m)                       | O(n + m)                       | Tie       |
| clear()                           | O(n)                           | O(n)                           | Tie       |
| contains(Object)                  | O(n)                           | O(n)                           | Tie       |
| containsAll(Collection)           | O(n * m)                       | O(n * m)                       | Tie       |
| equals(Object)                    | O(n)                           | O(n)                           | Tie       |
| get(int)                          | O(1)                           | O(1)                           | Tie       |
| hashCode()                        | O(n)                           | O(n)                           | Tie       |
| indexOf(Object)                   | O(n)                           | O(n)                           | Tie       |
| isEmpty()                         | O(1)                           | O(1)                           | Tie       |
| iterator()                        | O(1)                           | O(1)                           | Tie       |
| iterator().next()                 | O(1)                           | O(1)                           | Tie       |
| listIterator()                    | O(1)                           | O(1)                           | Tie       |
| listIterator(int)                 | O(1)                           | O(1)                           | Tie       |
| listIterator().next()             | O(1)                           | O(1)                           | Tie       |
| listIterator().previous()         | O(1)                           | O(1)                           | Tie       |
| listIterator().add(E)             | O(n)                           | O(n)                           | Tie       |
| listIterator().set(E)             | O(1)                           | O(1)                           | Tie       |
| listIterator().remove()           | O(n)                           | O(n)                           | Tie       |
| lastIndexOf(Object)               | O(n)                           | O(n)                           | Tie       |
| remove(int)                       | O(n)                           | O(n)                           | Tie       |
| remove(Object)                    | O(n)                           | O(n)                           | Tie       |
| removeAll(Collection)             | O(n * m)                       | O(n * m)                       | Tie       |
| retainAll(Collection)             | O(n * m)                       | O(n * m)                       | Tie       |
| set(int, E)                       | O(1)                           | O(1)                           | Tie       |
| size()                            | O(1)                           | O(1)                           | Tie       |
| subList(int, int)                 | O(k)                           | O(1)                           | ArrayList |
| toArray()                         | O(n)                           | O(n)                           | Tie       |
| toArray(T[])                      | O(n)                           | O(n)                           | Tie       |
| toString()                        | O(n)                           | O(n)                           | Tie       |
| expand() (private)                | O(n)                           | O(n)                           | Tie       |
| reduce() (private)                | O(n)                           | O(n)                           | Tie       |
| insert(int, Collection) (private) | O(n + m)                       | O(n + m)                       | Tie       |

# Space Complexity
| Method                            | CustomList Space O()          | ArrayList Space O()           | Winner    |
|-----------------------------------|-------------------------------|-------------------------------|-----------|
| add(E)                            | O(n) worst-case               | O(n) worst-case               | Tie       |
| add(int, E)                       | O(n)                          | O(n)                          | Tie       |
| addAll(Collection)                | O(n) worst-case               | O(n) worst-case               | Tie       |
| addAll(int, Collection)           | O(n + m)                      | O(n + m)                      | Tie       |
| clear()                           | O(n) worst, O(1) average      | O(1)                          | ArrayList |
| contains(Object)                  | O(1)                          | O(1)                          | Tie       |
| containsAll(Collection)           | O(1)                          | O(1)                          | Tie       |
| equals(Object)                    | O(1)                          | O(1)                          | Tie       |
| get(int)                          | O(1)                          | O(1)                          | Tie       |
| hashCode()                        | O(1)                          | O(1)                          | Tie       |
| indexOf(Object)                   | O(1)                          | O(1)                          | Tie       |
| isEmpty()                         | O(1)                          | O(1)                          | Tie       |
| iterator()                        | O(1)                          | O(1)                          | Tie       |
| iterator().next()                 | O(1)                          | O(1)                          | Tie       |
| listIterator()                    | O(1)                          | O(1)                          | Tie       |
| listIterator(int)                 | O(1)                          | O(1)                          | Tie       |
| listIterator().next()             | O(1)                          | O(1)                          | Tie       |
| listIterator().previous()         | O(1)                          | O(1)                          | Tie       |
| listIterator().add(E)             | O(n) worst-case, O(1) average | O(n) worst-case, O(1) average | Tie       |
| listIterator().set(E)             | O(1)                          | O(1)                          | Tie       |
| listIterator().remove()           | O(n) worst-case               | O(1)                          | ArrayList |
| lastIndexOf(Object)               | O(1)                          | O(1)                          | Tie       |
| remove(int)                       | O(n) worst-case, O(1) average | O(1)                          | ArrayList |
| remove(Object)                    | O(n) worst-case, O(1) average | O(1)                          | Tie       |
| removeAll(Collection)             | O(n) worst-case, O(1) average | O(n) worst-case, O(1) average | Tie       |
| retainAll(Collection)             | O(n) worst-case, O(1) average | O(n) worst-case, O(1) average | Tie       |
| set(int, E)                       | O(1)                          | O(1)                          | Tie       |
| size()                            | O(1)                          | O(1)                          | Tie       |
| subList(int, int)                 | O(k)                          | O(1)                          | ArrayList |
| toArray()                         | O(n)                          | O(n)                          | Tie       |
| toArray(T[])                      | O(n) worst, O(1) average      | O(n) worst, O(1) average      | Tie       |
| toString()                        | O(n)                          | O(n)                          | Tie       |
| expand() (private)                | O(n)                          | O(n)                          | Tie       |
| reduce() (private)                | O(n)                          | O(n)                          | Tie       |
| insert(int, Collection) (private) | O(n + m)                      | O(n + m)                      | Tie       |

**Legend**:
- `n`: Number of elements in the list.
- `m`: Number of elements in the input collection.
- `k`: Number of elements in the sublist (`toIndex - fromIndex`).

# Performance Charts

![Combined Performance Charts](PerformanceTesting/add(int,%20T).png)
![Combined Performance Charts](PerformanceTesting/add(T).png)
![Combined Performance Charts](PerformanceTesting/addAll(Collection%3CT%3E).png)
![Combined Performance Charts](PerformanceTesting/addAll(int,%20Collection%3CT%3E).png)
![Combined Performance Charts](PerformanceTesting/clear().png)
![Combined Performance Charts](PerformanceTesting/contains(T).png)
![Combined Performance Charts](PerformanceTesting/containsAll(Collection%3CT%3E).png)
![Combined Performance Charts](PerformanceTesting/equals(Object).png)
![Combined Performance Charts](PerformanceTesting/get(int).png)
![Combined Performance Charts](PerformanceTesting/hashCode().png)
![Combined Performance Charts](PerformanceTesting/indexOf(Object).png)
![Combined Performance Charts](PerformanceTesting/isEmpty().png)
![Combined Performance Charts](PerformanceTesting/iterator().next().png)
![Combined Performance Charts](PerformanceTesting/lastIndexOf(Object).png)
![Combined Performance Charts](PerformanceTesting/listIterator().add(T).png)
![Combined Performance Charts](PerformanceTesting/listIterator().remove().png)
![Combined Performance Charts](PerformanceTesting/remove(int).png)
![Combined Performance Charts](PerformanceTesting/remove(T).png)
![Combined Performance Charts](PerformanceTesting/removeAll(Collection<T>).png)
![Combined Performance Charts](PerformanceTesting/retainAll(Collection%3CT%3E).png)
![Combined Performance Charts](PerformanceTesting/set(int,%20T).png)
![Combined Performance Charts](PerformanceTesting/size().png)
![Combined Performance Charts](PerformanceTesting/subList(int,%20int).png)
![Combined Performance Charts](PerformanceTesting/toArray().png)
![Combined Performance Charts](PerformanceTesting/toString().png)


















