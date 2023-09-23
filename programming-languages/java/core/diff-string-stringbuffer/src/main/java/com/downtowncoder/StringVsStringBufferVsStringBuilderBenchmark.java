package com.downtowncoder;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * Benchmark                                               Mode  Cnt          Score         Error  Units
 * StringVsStringBuilderBenchmark.stringBenchmark         thrpt   25  188564738.802 ± 1542780.050  ops/s
 * StringVsStringBuilderBenchmark.stringBufferBenchmark   thrpt   25  160116892.243 ± 1541623.616  ops/s
 * StringVsStringBuilderBenchmark.stringBuilderBenchmark  thrpt   25  161196644.753 ±  424474.061  ops/s
 */
public class StringVsStringBufferVsStringBuilderBenchmark {

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
    public void stringBenchmark() {

        String[] userNameParts = { "Coder", "Cat", "Down", "Top", "Town" };
        String userName = userNameParts[2] + userNameParts[4] + userNameParts[0];

        userName = userNameParts[0] + userNameParts[2] + userNameParts[4];
    }

    /**
     *
     */
    @Benchmark
    public void stringBufferBenchmark() {

        String[] userNameParts = { "Coder", "Cat", "Down", "Top", "Town" };
        StringBuffer userName = new StringBuffer();
        userName.append( userNameParts[2] ).append( userNameParts[4] ).append( userNameParts[0] );

        userName.delete( 8, userName.length() ).insert( 0, "Coder" );
    }

    /**
     *
     */
    @Benchmark
    public void stringBuilderBenchmark() {

        String[] userNameParts = { "Coder", "Cat", "Down", "Top", "Town" };
        StringBuilder userName = new StringBuilder();
        userName.append( userNameParts[2] ).append( userNameParts[4] ).append( userNameParts[0] );

        userName.delete( 8, userName.length() ).insert( 0, "Coder" );
    }
}
