package com.pw.pipeline.utils;

import java.util.Random;

public class SeedDemo {

    public double withNoSeed(double value) {
        Random r = new Random();
        return value + r.nextDouble();
    }

    public double withSeed(double value) {
        Random r = new Random(42);
        return value + r.nextDouble();
    }
}
