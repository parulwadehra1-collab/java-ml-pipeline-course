package com.pw.pipeline.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

class NormalizerTest {

    @Test
    void testFlakyNormalizerDueToRandomMax() {
        FileLoader loader = Mockito.mock(FileLoader.class);

        // Randomly choose max = 10 or max = 12 to simulate inconsistent environment
        Random random = new Random();
        double max = random.nextBoolean() ? 10.0 : 12.0;

        Mockito.when(loader.loadMin()).thenReturn(0.0);
        Mockito.when(loader.loadMax()).thenReturn(max);

        Normalizer normalizer = new Normalizer(loader);
        double result = normalizer.scale(5.0);

        // Expect exactly 0.5 assuming max = 10.0
        Assertions.assertEquals(0.5, result, 1e-6);
    }
}
