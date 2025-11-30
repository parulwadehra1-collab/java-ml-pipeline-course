package com.pw.pipeline.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoisyCalculatorTest {

    private static final Logger logger = LogManager.getLogger(EntropyCalculatorTest.class);

    @Test
    void testRepeatedRuns_NoSeed() {
        NoisyCalculator calc = new NoisyCalculator();
        for (int i = 0; i < 3; i++) {
            double result = calc.computeWithNoise(5.0);
            logger.info("No seed — Run " + i + ": " + result);
        }
    }

    @Test
    void testRepeatedRuns_FixedSeed() {
        NoisyCalculator calc = new NoisyCalculator();
        for (int i = 0; i < 3; i++) {
            double result = calc.computeWithSeed(5.0);
            logger.info("With seed — Run " + i + ": " + result);
        }
    }

    @Test
    void testDatasetOrdering() {
        List<Integer> data = new ArrayList<>(List.of(3, 1, 2));

        // nondeterministic
        Collections.shuffle(data);
        logger.info("Shuffled: " + data);

        // deterministic
        Collections.sort(data);
        logger.info("Sorted: " + data);
    }

    @Test
    void testMockedIO() {
        FileLoader loader = Mockito.mock(FileLoader.class);

        Mockito.when(loader.loadMin()).thenReturn(0.0);
        Mockito.when(loader.loadMax()).thenReturn(10.0);

        Normalizer normalizer = new Normalizer(loader);
        double result = normalizer.scale(5.0);

        Assertions.assertEquals(0.5, result, 1e-6);
    }

}
