package arraybenchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;

@State(Scope.Benchmark)
public class WithInterface {
    public List<String> array = new ArrayList<>();

    @Benchmark
    public void benchmark(Blackhole bh) {
        array.add("Hello world!");

        for (int i = 0; i < Constants.ITERATIONS; i++) {
            bh.consume(array.get(0));
        }
    }
}
