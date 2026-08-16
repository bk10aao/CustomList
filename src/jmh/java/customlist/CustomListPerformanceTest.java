package customlist;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class CustomListPerformanceTest {

    @Param({ "10000", "20000", "30000", "40000", "50000", "70000", "80000", "90000", "100000"})
    int size;

    private List<Integer> sampleList;
    private List<Integer> smallList;
    private List<Integer> subMatchList;

    @Setup(Level.Invocation)
    public void setUp() {
        sampleList = IntStream.range(0, size).boxed().collect(Collectors.toList());
        smallList = IntStream.range(0, Math.min(1000, size)).boxed().collect(Collectors.toList());
        subMatchList = sampleList.subList(0, size / 2);
    }

    @Benchmark
    public void customDefaultConstructor(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>();
        bh.consume(list);
    }

    @Benchmark
    public void customCapacityConstructor(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(size);
        bh.consume(list);
    }

    @Benchmark
    public void customCollectionConstructor(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        bh.consume(list);
    }

    @Benchmark
    public void customAdd(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        bh.consume(list);
    }

    @Benchmark
    public void customAddIndex(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        bh.consume(list);
    }

    @Benchmark
    public void customAddAll(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>();
        list.addAll(sampleList);
        bh.consume(list);
    }

    @Benchmark
    public void customAddAllIndex(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>();
        list.addAll(0, sampleList);
        bh.consume(list);
    }

    @Benchmark
    public void customClear(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        list.clear();
        bh.consume(list);
    }

    @Benchmark
    public void customContains(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        int cap = Math.min(size, 10000);
        for (int i = 0; i < cap; i++) {
            bh.consume(list.contains(i));
        }
    }

    @Benchmark
    public void customContainsAll(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        bh.consume(list.containsAll(smallList));
    }

    @Benchmark
    public void customGet(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        for (int i = 0; i < size; i++) {
            bh.consume(list.get(i));
        }
    }

    @Benchmark
    public void customIndexOf(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        int cap = Math.min(size, 10000);
        for (int i = 0; i < cap; i++) {
            bh.consume(list.indexOf(i));
        }
    }

    @Benchmark
    public void customIsEmpty(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        bh.consume(list.isEmpty());
    }

    @Benchmark
    public void customIteratorNext(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        for (Integer val : list) {
            bh.consume(val);
        }
    }

    @Benchmark
    public void customListIteratorAdd(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>();
        var lit = list.listIterator();
        for (int i = 0; i < size; i++) {
            lit.add(i);
        }
        bh.consume(list);
    }

    @Benchmark
    public void customListIteratorSet(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        var lit = list.listIterator();
        while (lit.hasNext()) {
            lit.next();
            lit.set(1);
        }
        bh.consume(list);
    }

    @Benchmark
    public void customListIteratorRemove(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        var lit = list.listIterator();
        while (lit.hasNext()) {
            lit.next();
            lit.remove();
        }
        bh.consume(list);
    }

    @Benchmark
    public void customLastIndexOf(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        int cap = Math.min(size, 10000);
        for (int i = 0; i < cap; i++) {
            bh.consume(list.lastIndexOf(i));
        }
    }

    @Benchmark
    public void customRemoveIndex(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        for (int i = size - 1; i >= 0; i--) {
            bh.consume(list.remove(i));
        }
    }

    @Benchmark
    public void customRemoveObject(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        for (int i = 0; i < size; i++) {
            bh.consume(list.remove(Integer.valueOf(i)));
        }
    }

    @Benchmark
    public void customRemoveAll(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        list.removeAll(subMatchList);
        bh.consume(list);
    }

    @Benchmark
    public void customRetainAll(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        list.retainAll(subMatchList);
        bh.consume(list);
    }

    @Benchmark
    public void customSet(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        for (int i = 0; i < list.size(); i++) {
            bh.consume(list.set(i, i));
        }
    }

    @Benchmark
    public void customSize(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        bh.consume(list.size());
    }

    @Benchmark
    public void customSubList(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        bh.consume(list.subList(0, Math.min(size, 1)).size());
    }

    @Benchmark
    public void customToArray(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        bh.consume(list.toArray());
    }

    @Benchmark
    public void customEquals(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        bh.consume(list.equals(sampleList));
    }

    @Benchmark
    public void customHashCode(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        bh.consume(list.hashCode());
    }

    @Benchmark
    public void customToString(Blackhole bh) {
        CustomList<Integer> list = new CustomList<>(sampleList);
        bh.consume(list.toString());
    }

    public static void main(String[] args) throws org.openjdk.jmh.runner.RunnerException {
        org.openjdk.jmh.runner.options.Options opt = new org.openjdk.jmh.runner.options.OptionsBuilder()
                .include(CustomListPerformanceTest.class.getSimpleName())
                .measurementIterations(5)
                .warmupIterations(3)
                .forks(1)
                .result("CustomList_performance_results.csv")
                .resultFormat(org.openjdk.jmh.results.format.ResultFormatType.CSV)
                .build();

        java.util.Collection<org.openjdk.jmh.results.RunResult> results = new org.openjdk.jmh.runner.Runner(opt).run();
        writeCustomCsv(results);
    }

    private static void writeCustomCsv(java.util.Collection<org.openjdk.jmh.results.RunResult> results) {
        try (java.io.FileWriter writer = new java.io.FileWriter("CustomList_jmh_performance.csv")) {
            writer.write("Benchmark;Size;Score (ns/op)\n");
            for (org.openjdk.jmh.results.RunResult result : results) {
                String benchmarkName = result.getParams().getBenchmark();
                String shortName = benchmarkName.substring(benchmarkName.lastIndexOf('.') + 1);

                double score = result.getPrimaryResult().getScore();
                String sizeVal = result.getParams().getParam("size");

                writer.write("\"" + shortName + "\";" + (sizeVal != null ? sizeVal : "N/A") + ";" + score + "\n");
            }
            System.out.println("JMH Performance report saved: CustomList_jmh_performance.csv");
        } catch (java.io.IOException e) {
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }
}