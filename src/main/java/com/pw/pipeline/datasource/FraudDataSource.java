package com.pw.pipeline.datasource;

    import java.util.List;

public class FraudDataSource {

    public List<String> loadRawRecords() {
        // In a real pipeline this would read from CSV / DB / Kafka, etc.
        // Here we just return a tiny in-memory list for demonstration.
        return List.of(
                "txn1,1000,online,SAFE",
                "txn2,9500,card_present,FRAUD",
                "txn3,1200,online,SAFE"
        );
    }
}
