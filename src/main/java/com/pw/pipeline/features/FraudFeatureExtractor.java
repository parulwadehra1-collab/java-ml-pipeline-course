package com.pw.pipeline.features;

import java.util.List;

public class FraudFeatureExtractor {

    public List<double[]> toFeatureVectors(List<String> cleanedRecords) {
        // For the demo we return dummy vectors.
        // In a real pipeline we’d parse amounts, channels, etc.
        return List.of(
                new double[]{1000.0, 0.0},
                new double[]{9500.0, 1.0},
                new double[]{1200.0, 0.0}
        );
    }
}
