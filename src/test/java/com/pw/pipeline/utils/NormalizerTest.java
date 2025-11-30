package com.pw.pipeline.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

class NormalizerTest {

    @Test
    void testFlakyNormalizerDueToRandomMax() {
        FileLoader loader = Mockito.mock(FileLoader.class);

        Mockito.when(loader.loadMin()).thenReturn(0.0);
        Mockito.when(loader.loadMax()).thenReturn(10.0);

        Normalizer normalizer = new Normalizer(loader);
        double result = normalizer.scale(5.0);

        Assertions.assertEquals(0.5, result, 1e-6);
    }
}
