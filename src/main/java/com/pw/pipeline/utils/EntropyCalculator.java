package com.pw.pipeline.utils;

import java.util.Arrays;

public class EntropyCalculator {

    // Compute entropy of a probability distribution
    public static double compute(double[] values) {
        return Arrays.stream(values)
                .filter(v -> v > 0)   // ignore zero values
                .map(v -> -v * Math.log(v) / Math.log(2))
                .sum();
    }
}
