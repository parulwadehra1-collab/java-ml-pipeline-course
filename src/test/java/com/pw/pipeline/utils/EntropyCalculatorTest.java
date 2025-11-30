package com.pw.pipeline.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Arrays;

public class EntropyCalculatorTest {

    private static final Logger logger = LogManager.getLogger(EntropyCalculatorTest.class);

    @Test
    void testEntropyOfUniformDistribution() {
        double[] values = {0.25, 0.25, 0.25, 0.25};
        logger.info("Testing entropy for: " + Arrays.toString(values));
        double entropy = EntropyCalculator.compute(values);
        Assertions.assertEquals(2.0, entropy, 1e-6);

    }

    @Test
    void testEntropyWithZeros() {
        double[] values = {0.5, 0.5, 0.0};
        logger.info("Testing entropy for: " + Arrays.toString(values));
        double entropy = EntropyCalculator.compute(values);
        Assertions.assertEquals(1.0, entropy, 1e-6);
    }



}
