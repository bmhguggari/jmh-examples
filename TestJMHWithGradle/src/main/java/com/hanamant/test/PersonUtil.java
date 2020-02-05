package com.hanamant.test;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 0)
@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public class PersonUtil {

    @Benchmark
    public boolean isAdult(Person person) {
        boolean adult = false;
        if(person == null || person.getAge() <=18 ) {
            adult = false;
        } else {
            adult = true;
        }
        return adult;
    }

}
