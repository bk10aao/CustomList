import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomListPerformanceTest {

    private static final int RUNS = 5;
    private static final int[] SIZES = {0, 1000, 2500, 5000, 7500, 10000, 25000, 50000, 100000};
    private static final String[] METHOD_NAMES = {
            "add(T)", "add(int, T)", "addAll(Collection<T>)", "addAll(int, Collection<T>)",
            "clear()", "contains(T)", "containsAll(List<T>)", "get(int)",
            "indexOf(Object)", "isEmpty()", "iterator().next()", "listIterator().add(T)",
            "listIterator().set(T)", "listIterator().remove()", "lastIndexOf(Object)",
            "remove(int)", "remove(T)", "removeAll(Collection<T>)", "retainAll(Collection<T>)",
            "set(int, T)", "size()", "subList(int, int)", "toArray()", "equals(Object)",
            "hashCode()", "toString()"
    };

    public static void main(String[] args) {
        long[][] results = new long[SIZES.length][METHOD_NAMES.length];

        for (int si = 0; si < SIZES.length; si++) {
            int size = SIZES[si];
            System.out.println("Current size: " + size);
            for (int run = 0; run < RUNS; run++) {
                CustomList<Integer> list = new CustomList<>();
                List<Integer> sampleList = IntStream.range(0, size).boxed().collect(Collectors.toList());
                List<Integer> smallList = IntStream.range(0, Math.min(1000, size)).boxed().toList();

                long start, end;

                // 0. add(T)
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.add(i);
                end = System.nanoTime();
                results[si][0] += (end - start);

                System.out.println("1. add(int, T)");
                list.clear();
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.add(0, i);
                end = System.nanoTime();
                results[si][1] += (end - start);

                System.out.println("2. addAll(Collection<T>");
                list.clear();
                start = System.nanoTime();
                list.addAll(sampleList);
                end = System.nanoTime();
                results[si][2] += (end - start);

                System.out.println("3. addAll(int, Collection<T>)");
                list.clear();
                start = System.nanoTime();
                list.addAll(0, sampleList);
                end = System.nanoTime();
                results[si][3] += (end - start);

                System.out.println("4. clear()");
                list.clear();
                list.addAll(sampleList);
                start = System.nanoTime();
                list.clear();
                end = System.nanoTime();
                results[si][4] += (end - start);

                System.out.println("5. contains(T)");
                list.addAll(sampleList);
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.contains(i);
                end = System.nanoTime();
                results[si][5] += (end - start);

                System.out.println("6. containsAll(List<T>)");
                start = System.nanoTime();
                list.containsAll(smallList);
                end = System.nanoTime();
                results[si][6] += (end - start);

                System.out.println("7. get(int)");
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.get(i);
                end = System.nanoTime();
                results[si][7] += (end - start);

                System.out.println("8. indexOf(Object)");
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.indexOf(i);
                end = System.nanoTime();
                results[si][8] += (end - start);

                System.out.println("9. isEmpty()");
                start = System.nanoTime();
                list.isEmpty();
                end = System.nanoTime();
                results[si][9] += (end - start);

                System.out.println("10. iterator().next()");
                start = System.nanoTime();
                var iter = list.iterator();
                while (iter.hasNext()) iter.next();
                end = System.nanoTime();
                results[si][10] += (end - start);

                System.out.println("11. listIterator().add(T)");
                list.clear();
                var listIterAdd = list.listIterator();
                start = System.nanoTime();
                for (int i = 0; i < size; i++) {
                    listIterAdd.add(i);
                }
                end = System.nanoTime();
                results[si][11] += (end - start);

                System.out.println("12. listIterator().set(T)");
                list.clear();
                list.addAll(sampleList);
                var listIterSet = list.listIterator();
                start = System.nanoTime();
                while (listIterSet.hasNext()) {
                    listIterSet.next();
                    listIterSet.set(listIterSet.nextIndex());
                }
                end = System.nanoTime();
                results[si][12] += (end - start);

                System.out.println("13. listIterator().remove()");
                list.clear();
                list.addAll(sampleList);
                var listIterRemove = list.listIterator();
                start = System.nanoTime();
                while (listIterRemove.hasNext()) {
                    listIterRemove.next();
                    listIterRemove.remove();
                }
                end = System.nanoTime();
                results[si][13] += (end - start);

                System.out.println("14. lastIndexOf(Object)");
                list.addAll(sampleList);
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.lastIndexOf(i);
                end = System.nanoTime();
                results[si][14] += (end - start);

                System.out.println("15. remove(int)");
                list.clear();
                list.addAll(sampleList);
                start = System.nanoTime();
                for (int i = size - 1; i >= 0; i--) list.remove(i);
                end = System.nanoTime();
                results[si][15] += (end - start);

                System.out.println("16. remove(T)");
                list.addAll(sampleList);
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.remove(Integer.valueOf(i));
                end = System.nanoTime();
                results[si][16] += (end - start);

                System.out.println("17. removeAll(Collection<T>)");
                list.addAll(sampleList);
                List<Integer> removeList = sampleList.subList(size / 2, size);
                start = System.nanoTime();
                list.removeAll(removeList);
                end = System.nanoTime();
                results[si][17] += (end - start);

                System.out.println("18. retainAll(Collection<T>)");
                list.addAll(sampleList);
                List<Integer> retainList = sampleList.subList(0, size / 2);
                start = System.nanoTime();
                list.retainAll(retainList);
                end = System.nanoTime();
                results[si][18] += (end - start);

                System.out.println("19. set(int, T)");
                list.clear();
                list.addAll(sampleList);
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.set(i, i + 1);
                end = System.nanoTime();
                results[si][19] += (end - start);

                System.out.println("20. size()");
                start = System.nanoTime();
                list.size();
                end = System.nanoTime();
                results[si][20] += (end - start);

                System.out.println("21. subList(int, int)");
                list.addAll(sampleList);
                start = System.nanoTime();
                list.subList(0, size / 2);
                end = System.nanoTime();
                results[si][21] += (end - start);

                System.out.println("22. toArray()");
                start = System.nanoTime();
                list.toArray();
                end = System.nanoTime();
                results[si][22] += (end - start);

                System.out.println("23. equals(Object)");
                List<Integer> other = new ArrayList<>();
                other.addAll(sampleList);
                start = System.nanoTime();
                list.equals(other);
                end = System.nanoTime();
                results[si][23] += (end - start);

                System.out.println("24. hashCode()");
                start = System.nanoTime();
                list.hashCode();
                end = System.nanoTime();
                results[si][24] += (end - start);

                System.out.println("25. toString()");
                start = System.nanoTime();
                list.toString();
                end = System.nanoTime();
                results[si][25] += (end - start);
            }

            // Average results over runs
            for (int mi = 0; mi < METHOD_NAMES.length; mi++) {
                results[si][mi] /= RUNS;
            }
        }

        // Write CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customlist_performance.csv"))) {
            // Header
            writer.write("\"Size\"");
            for (String name : METHOD_NAMES) {
                writer.write(";\"" + name + "\"");
            }
            writer.newLine();

            // Data rows
            for (int i = 0; i < SIZES.length; i++) {
                writer.write(String.valueOf(SIZES[i]));
                for (int j = 0; j < METHOD_NAMES.length; j++) {
                    writer.write(";" + results[i][j]);
                }
                writer.newLine();
            }
            System.out.println("Performance results written to customlist_performance.csv");
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }
}