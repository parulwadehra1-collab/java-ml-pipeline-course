package com.pw.pipeline.preprocessing;

import java.util.List;

public class FraudPreprocessor {

    public List<String> clean(List<String> rawRecords) {
        // Here you might handle missing values, invalid rows, etc.
        // For the video we'll just pretend this step validates & cleans.
        return rawRecords;
    }
}