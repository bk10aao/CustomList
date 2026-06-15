import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomListPerformanceTest {

    private static final int WARMUP_RUNS = 3;
    private static final int RUNS = 5;
    private static final int[] SIZES = {5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};

    private static final String[] METHOD_NAMES = {
            "add(T)", "add(int, T)", "addAll(Collection)", "addAll(int, Collection)",
            "clear()", "contains(T)", "containsAll(Collection)", "get(int)",
            "indexOf(Object)", "isEmpty()", "iterator().next()", "listIterator().add(T)",
            "listIterator().set(T)", "listIterator().remove()", "lastIndexOf(Object)",
            "remove(int)", "remove(T)", "removeAll(Collection)", "retainAll(Collection)",
            "set(int, T)", "size()", "subList(int, int)", "toArray()", "equals(Object)",
            "hashCode()", "toString()"
    };

    private static long blackholeToken = 0;

    public static void main(String[] args) {
        long[][][] results = new long[SIZES.length][METHOD_NAMES.length][2];

        System.out.println("--- Starting JIT Warmup Phase ---");
        runBenchmarkSuite(null, WARMUP_RUNS);
        System.out.println("--- Warmup Complete. Running Active Benchmarks ---");

        results = runBenchmarkSuite(results, RUNS);

        writeResultsToCsv(results);
        System.out.println("Blackhole anti-optimization verification token: " + blackholeToken);
    }

    private static long[][][] runBenchmarkSuite(long[][][] targetResults, int iterations) {
        long[][][] runDelta = (targetResults != null) ? targetResults : new long[SIZES.length][METHOD_NAMES.length][2];
        boolean isWarmup = (targetResults == null);

        for (int si = 0; si < SIZES.length; si++) {
            int size = SIZES[si];
            if (isWarmup && size > 5000) continue;

            System.out.println("Processing collection size element layer: " + size);

            List<Integer> sampleList = IntStream.range(0, size).boxed().collect(Collectors.toList());
            List<Integer> smallList = IntStream.range(0, Math.min(1000, size)).boxed().collect(Collectors.toList());
            List<Integer> subMatchList = sampleList.subList(0, size / 2);

            for (int run = 0; run < iterations; run++) {
                runListInstanceSuite(runDelta, si, size, sampleList, smallList, subMatchList, true);
                runListInstanceSuite(runDelta, si, size, sampleList, smallList, subMatchList, false);
            }

            if (!isWarmup) {
                for (int mi = 0; mi < METHOD_NAMES.length; mi++) {
                    runDelta[si][mi][0] /= iterations;
                    runDelta[si][mi][1] /= iterations;
                }
            }
        }
        return runDelta;
    }

    private static void runListInstanceSuite(long[][][] deltaMap, int si, int size, List<Integer> sampleList, List<Integer> smallList, List<Integer> subMatchList, boolean isCustom) {
        List<Integer> target = isCustom ? new CustomList<>() : new ArrayList<>();
        int typeIdx = isCustom ? 0 : 1;
        long start, end;
        int cap = Math.min(size, 10000);

        // 0. add(T)
        target.clear(); start = System.nanoTime(); for (int i = 0; i < size; i++) target.add(i); end = System.nanoTime(); deltaMap[si][0][typeIdx] += (end - start);
        // 1. add(int, T)
        target.clear(); start = System.nanoTime(); for (int i = 0; i < size; i++) target.add(0, i); end = System.nanoTime(); deltaMap[si][1][typeIdx] += (end - start);
        // 2. addAll
        target.clear(); start = System.nanoTime(); target.addAll(sampleList); end = System.nanoTime(); deltaMap[si][2][typeIdx] += (end - start);
        // 3. addAll(int, Collection)
        target.clear(); start = System.nanoTime(); target.addAll(0, sampleList); end = System.nanoTime(); deltaMap[si][3][typeIdx] += (end - start);
        // 4. clear
        target.addAll(sampleList); start = System.nanoTime(); target.clear(); end = System.nanoTime(); deltaMap[si][4][typeIdx] += (end - start);

        target.addAll(sampleList);

        // 5. contains(T)
        start = System.nanoTime(); for (int i = 0; i < cap; i++) if (target.contains(i)) blackholeToken++; end = System.nanoTime(); deltaMap[si][5][typeIdx] += (end - start);
        // 6. containsAll
        start = System.nanoTime(); if (target.containsAll(smallList)) blackholeToken++; end = System.nanoTime(); deltaMap[si][6][typeIdx] += (end - start);
        // 7. get(int)
        start = System.nanoTime(); for (int i = 0; i < size; i++) blackholeToken += target.get(i); end = System.nanoTime(); deltaMap[si][7][typeIdx] += (end - start);
        // 8. indexOf
        start = System.nanoTime(); for (int i = 0; i < cap; i++) blackholeToken += target.indexOf(i); end = System.nanoTime(); deltaMap[si][8][typeIdx] += (end - start);
        // 9. isEmpty
        start = System.nanoTime(); if (target.isEmpty()) blackholeToken++; end = System.nanoTime(); deltaMap[si][9][typeIdx] += (end - start);
        // 10. iterator
        start = System.nanoTime(); var it = target.iterator(); while(it.hasNext()) blackholeToken += it.next(); end = System.nanoTime(); deltaMap[si][10][typeIdx] += (end - start);

        // 11. listIterator().add(T)
        target.clear(); var lit = target.listIterator(); start = System.nanoTime(); for(int i=0; i<size; i++) lit.add(i); end = System.nanoTime(); deltaMap[si][11][typeIdx] += (end - start);

        // 12-13. ListIterator ops
        target.clear(); target.addAll(sampleList);
        lit = target.listIterator(); start = System.nanoTime(); while(lit.hasNext()){ lit.next(); lit.set(1); } end = System.nanoTime(); deltaMap[si][12][typeIdx] += (end - start);
        lit = target.listIterator(); start = System.nanoTime(); while(lit.hasNext()){ lit.next(); lit.remove(); } end = System.nanoTime(); deltaMap[si][13][typeIdx] += (end - start);

        // 14. lastIndexOf
        target.clear(); target.addAll(sampleList);
        start = System.nanoTime(); for(int i=0; i<cap; i++) blackholeToken += target.lastIndexOf(i); end = System.nanoTime(); deltaMap[si][14][typeIdx] += (end - start);
        // 15. remove(int)
        start = System.nanoTime(); for(int i=size-1; i>=0; i--) target.remove(i); end = System.nanoTime(); deltaMap[si][15][typeIdx] += (end - start);
        // 16. remove(T)
        if(size <= 50000) { target.addAll(sampleList); start = System.nanoTime(); for(int i=0; i<size; i++) target.remove(Integer.valueOf(i)); end = System.nanoTime(); deltaMap[si][16][typeIdx] += (end - start); }

        // 17-18. RemoveAll/RetainAll
        target.clear(); target.addAll(sampleList);
        start = System.nanoTime(); target.removeAll(subMatchList); end = System.nanoTime(); deltaMap[si][17][typeIdx] += (end - start);
        start = System.nanoTime(); target.retainAll(subMatchList); end = System.nanoTime(); deltaMap[si][18][typeIdx] += (end - start);

        // 19. set(int, T) - FIXED TO PREVENT DEAD CODE ELIMINATION
        target.clear(); target.addAll(sampleList);
        start = System.nanoTime();
        for(int i=0; i<target.size(); i++) {
            // Using hashcode() on the returned object forces the compiler to run the 'set' operation
            blackholeToken += target.set(i, i).hashCode();
        }
        end = System.nanoTime();
        deltaMap[si][19][typeIdx] += (end - start);

        // 20-25. Remaining
        start = System.nanoTime(); blackholeToken += target.size(); end = System.nanoTime(); deltaMap[si][20][typeIdx] += (end - start);
        start = System.nanoTime(); blackholeToken += target.subList(0, Math.min(size, 1)/2 + (size>0?0:0)).size(); end = System.nanoTime(); deltaMap[si][21][typeIdx] += (end - start);
        start = System.nanoTime(); blackholeToken += target.toArray().length; end = System.nanoTime(); deltaMap[si][22][typeIdx] += (end - start);
        start = System.nanoTime(); if(target.equals(sampleList)) blackholeToken++; end = System.nanoTime(); deltaMap[si][23][typeIdx] += (end - start);
        start = System.nanoTime(); blackholeToken += target.hashCode(); end = System.nanoTime(); deltaMap[si][24][typeIdx] += (end - start);
        start = System.nanoTime(); blackholeToken += target.toString().length(); end = System.nanoTime(); deltaMap[si][25][typeIdx] += (end - start);
    }

    private static void writeResultsToCsv(long[][][] results) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customlist_performance.csv"))) {
            writer.write("\"Size\";\"add(T)\";\"add(int, T)\";\"addAll(Collection<T>)\";\"addAll(int, Collection<T>)\";\"clear()\";\"contains(T)\";\"containsAll(List<T>)\";\"get(int)\";\"indexOf(Object)\";\"isEmpty()\";\"iterator().next()\";\"listIterator().add(T)\";\"listIterator().set(T)\";\"listIterator().remove()\";\"lastIndexOf(Object)\";\"remove(int)\";\"remove(T)\";\"removeAll(Collection<T>)\";\"retainAll(Collection<T>)\";\"set(int, T)\";\"size()\";\"subList(int, int)\";\"toArray()\";\"equals(Object)\";\"hashCode()\";\"toString()\"");
            writer.newLine();
            for (int i = 0; i < SIZES.length; i++) {
                StringBuilder row = new StringBuilder();
                row.append(SIZES[i]);
                for (int j = 0; j < METHOD_NAMES.length; j++) {
                    row.append(";").append(results[i][j][0]);
                }
                writer.write(row.toString());
                writer.newLine();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}