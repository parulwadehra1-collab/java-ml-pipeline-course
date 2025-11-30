package com.pw.pipeline.utils;

public class Normalizer {

    private final FileLoader loader;

    public Normalizer(FileLoader loader) {
        this.loader = loader;
    }

    public double scale(double value) {
        double min = loader.loadMin();
        double max = loader.loadMax();
        return (value - min) / (max - min);
    }
}
