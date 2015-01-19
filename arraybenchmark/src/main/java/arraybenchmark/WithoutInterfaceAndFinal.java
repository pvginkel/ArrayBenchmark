package arraybenchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;

public class WithoutInterfaceAndFinal {
    @Benchmark
    public void benchmark(Blackhole bh) {
        new Data().test(bh);
    }

    private static class Data {
        public final ArrayList<String> array = new ArrayList<>();

        public void test(Blackhole bh) {
            array.add("Hello world!");

            for (int i = 0; i < Constants.ITERATIONS; i++) {
                bh.consume(array.get(0));
            }
        }
    }
}
