package com.hanamant.test;

import org.junit.Test;
import org.openjdk.jmh.Main;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class PeronsUtilTest {

    @Test
    public void testBenchmark() {
        Options op = new OptionsBuilder()
                //.getResultFormat(ResultFormatType.JSON)
                .result("test.json")
                .forks(1)
                .build();

        try {
            new Runner(op).run();

        } catch(Exception ex) {}


    }
}
