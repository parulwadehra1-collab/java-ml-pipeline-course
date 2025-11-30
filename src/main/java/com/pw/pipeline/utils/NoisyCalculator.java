package com.pw.pipeline.utils;

import java.util.Random;

public class NoisyCalculator {

    public double computeWithNoise(double value) {
        Random rand = new Random();   // NO SEED → nondeterministic!
        return value + rand.nextDouble();
    }

    public double computeWithSeed(double value) {
        Random rand = new Random(42); // FIXED SEED → deterministic
        return value + rand.nextDouble();
    }
}
