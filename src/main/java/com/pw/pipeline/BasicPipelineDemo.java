package com.pw.pipeline;

import com.pw.pipeline.datasource.FraudDataSource;
import com.pw.pipeline.preprocessing.FraudPreprocessor;
import com.pw.pipeline.features.FraudFeatureExtractor;
import com.pw.pipeline.model.DummyFraudModel;
import com.pw.pipeline.evaluation.FraudEvaluator;

public class BasicPipelineDemo {

    public static void main(String[] args) {
        // 1. Data ingestion
        var dataSource = new FraudDataSource();
        var rawRecords = dataSource.loadRawRecords();

        // 2. Preprocessing
        var preprocessor = new FraudPreprocessor();
        var cleanedRecords = preprocessor.clean(rawRecords);

        // 3. Feature transformation
        var featureExtractor = new FraudFeatureExtractor();
        var featureVectors = featureExtractor.toFeatureVectors(cleanedRecords);

        // 4. Model training / loading
        var model = new DummyFraudModel(); // imagine this is a Tribuo model

        // 5. Evaluation
        var evaluator = new FraudEvaluator();
        evaluator.printSummary();

        System.out.println("Pipeline completed end-to-end with 5 distinct stages.");
    }
}
