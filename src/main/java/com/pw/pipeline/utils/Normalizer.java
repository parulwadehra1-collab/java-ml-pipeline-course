package com.pw.pipeline.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

 public class Normalizer {

    private final FileLoader loader;
    private static final Logger logger = LogManager.getLogger(Normalizer.class);

    public Normalizer(FileLoader loader) {
        this.loader = loader;
    }

    public double scale(double value) {
        double min = loader.loadMin();
        double max = loader.loadMax();
        logger.debug("Scaling value: {} with min={} and max={}", value, min, max);
        double scaled = (value - min) / (max - min);
        logger.debug("Scaled result: {}", scaled);

        return scaled;
    }
}
