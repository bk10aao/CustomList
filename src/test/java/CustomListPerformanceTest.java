import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomListPerformanceTest {

    private static final int RUNS = 5;
    private static final int[] SIZES = {1000, 2500, 5000, 7500, 10000, 25000, 50000, 100000};
    private static final String[] METHOD_NAMES = {
            "add(T)", "addAll(Collection<T>)", "clear()", "contains(T)", "containsAll(List<T>)",
            "get(int)", "indexOf(Object)", "isEmpty()", "iterator().next()",
            "lastIndexOf(Object)", "remove(int)", "remove(T)", "removeAll(Collection<T>)",
            "retainAll(Collection<T>)", "set(int, T)", "size()", "subList(int, int)",
            "toArray()", "equals(Object)", "hashCode()", "toString()"
    };

    public static void main(String[] args) {
        long[][] results = new long[SIZES.length][METHOD_NAMES.length];

        for (int si = 0; si < SIZES.length; si++) {
            int size = SIZES[si];
            System.out.println("current size: " + size);
            for (int run = 0; run < RUNS; run++) {
                CustomList<Integer> list = new CustomList<>();

                List<Integer> sampleList = new ArrayList<>();
                for (int i = 0; i < size; i++) sampleList.add(i);

                long start, end;

                // 0. add(T)
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.add(i);
                end = System.nanoTime();
                results[si][0] += (end - start);

                // 1. addAll(Collection<T>)
                start = System.nanoTime();
                list.addAll(sampleList);
                end = System.nanoTime();
                results[si][1] += (end - start);

                // 2. clear()
                start = System.nanoTime();
                list.clear();
                end = System.nanoTime();
                results[si][2] += (end - start);

                list.addAll(sampleList);

                // 3. contains(T)
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.contains(i);
                end = System.nanoTime();
                results[si][3] += (end - start);

                // 4. containsAll(List<T>)
                start = System.nanoTime();
                list.containsAll(sampleList);
                end = System.nanoTime();
                results[si][4] += (end - start);

                // 5. get(int)
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.get(i);
                end = System.nanoTime();
                results[si][5] += (end - start);

                // 6. indexOf(Object)
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.indexOf(i);
                end = System.nanoTime();
                results[si][6] += (end - start);

                // 7. isEmpty()
                start = System.nanoTime();
                list.isEmpty();
                end = System.nanoTime();
                results[si][7] += (end - start);

                // 8. iterator().next()
                start = System.nanoTime();
                var iter = list.iterator();
                while (iter.hasNext()) iter.next();
                end = System.nanoTime();
                results[si][8] += (end - start);

                // 9. lastIndexOf(Object)
                start = System.nanoTime();
                for (int i = 0; i < size; i++) list.lastIndexOf(i);
                end = System.nanoTime();
                results[si][9] += (end - start);

                // 10. remove(int)
                int limit = size - size / 10;
                start = System.nanoTime();
                for (int i = limit; i < size; i++) list.remove(limit);
                end = System.nanoTime();
                results[si][10] += (end - start);

                list.clear();
                list.addAll(sampleList);

                // 11. remove(T)
                start = System.nanoTime();
                for (int i = limit; i < size; i++) list.remove(Integer.valueOf(i));
                end = System.nanoTime();
                results[si][11] += (end - start);

                list.clear();
                list.addAll(sampleList);

                // 12. removeAll(Collection<T>)
                List<Integer> removeList = sampleList.subList(limit, size);
                start = System.nanoTime();
                list.removeAll(removeList);
                end = System.nanoTime();
                results[si][12] += (end - start);

                list.clear();
                list.addAll(sampleList);

                // 13. retainAll(Collection<T>)
                List<Integer> retainList = sampleList.subList(0, limit);
                start = System.nanoTime();
                list.retainAll(retainList);
                end = System.nanoTime();
                results[si][13] += (end - start);

                // 14. set(int, T)
                start = System.nanoTime();
                for (int i = 0; i < limit; i++) list.set(i, i + 1);
                end = System.nanoTime();
                results[si][14] += (end - start);

                // 15. size()
                start = System.nanoTime();
                list.size();
                end = System.nanoTime();
                results[si][15] += (end - start);

                // 16. subList(int, int)
                start = System.nanoTime();
                var sub = list.subList(0, Math.min(100, list.size()));
                end = System.nanoTime();
                results[si][16] += (end - start);

                // 17. toArray()
                start = System.nanoTime();
                Object[] arr = list.toArray();
                end = System.nanoTime();
                results[si][17] += (end - start);

                // 18. equals(Object)
                CustomList<Integer> other = new CustomList<>();
                other.addAll(sampleList);
                start = System.nanoTime();
                list.equals(other);
                end = System.nanoTime();
                results[si][18] += (end - start);

                // 19. hashCode()
                start = System.nanoTime();
                list.hashCode();
                end = System.nanoTime();
                results[si][19] += (end - start);

                // 20. toString()
                start = System.nanoTime();
                list.toString();
                end = System.nanoTime();
                results[si][20] += (end - start);
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
