package team.jit.workshop;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@State(Scope.Thread)
public class BenchmarkTest {

    private List<String> linkedList = new LinkedList<>();

    private List<String> arrayList = new ArrayList<>();

    {
        for (int i = 0; i < 100000; i++) {
            linkedList.add(""+i);
            arrayList.add(""+i);
        }
    }

    @Test
    public void runBenchmarks() throws Exception {
        Options options = new OptionsBuilder()
                .include(this.getClass().getName() + ".*")
                .mode(Mode.AverageTime)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(6)
                .threads(1)
                .measurementIterations(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(options).run();
    }

    private static String hello = "not another hello world";

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void arrayListTest() throws Exception {
        for (String s : linkedList) {

        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void linkedListTest() throws Exception {
        for (String s : arrayList) {

        }
    }

//    @Benchmark
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    public void stringsWithoutStringBuilder() throws Exception {
//        String hellos = "";
//        for (int i = 0; i < 1000; i++) {
//            hellos += hello;
//            if (i != 999) {
//                hellos += "\n";
//            }
//        }
//        assertTrue(hellos.startsWith((hello + "\n")));
//    }

//    @Benchmark
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    public void stringsWithStringBuilder() throws Exception {
//        StringBuilder hellosBuilder = new StringBuilder();
//        for (int i = 0; i < 1000; i++) {
//            hellosBuilder.append(hello);
//            if (i != 999) {
//                hellosBuilder.append("\n");
//            }
//        }
//        assertTrue(hellosBuilder.toString().startsWith((hello + "\n")));
//    }
}
