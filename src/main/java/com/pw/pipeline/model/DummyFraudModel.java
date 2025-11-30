package com.pw.pipeline.model;

public class DummyFraudModel {

    public String predict(double[] features) {
        // Super simple rule: if amount > 5000 => FRAUD else SAFE.
        return features[0] > 5000 ? "FRAUD" : "SAFE";
    }
}
