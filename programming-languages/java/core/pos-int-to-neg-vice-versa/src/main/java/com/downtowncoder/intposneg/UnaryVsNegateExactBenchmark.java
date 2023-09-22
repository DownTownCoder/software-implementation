package com.downtowncoder.intposneg;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * Comparison of throughput performance between the unary negation operator and Math.negateExact().
 * <p>
 * Benchmark                Mode  Cnt           Score           Error  Units
 * Main.negateExactNegate  thrpt   25  2456524511.733 ± 134146059.353  ops/s
 * Main.unaryNegate        thrpt   25  2297133004.478 ± 162809671.980  ops/s
 * <p>
 * Math.negateExact() appears to come out ahead. However, there is an overlap of -1376 ops/s between their respective throughputs +/- their errors.
 */
public class UnaryVsNegateExactBenchmark {
    /**
     *
     */
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    /**
     *
     */
    @Benchmark
    public void unaryNegate() {
        int x = 100;
        int y = -x;
    }

    /**
     *
     */
    @Benchmark
    public void negateExactNegate() {
        int x = 100;
        int y = Math.negateExact(x);
    }
}
