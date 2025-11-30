package com.pw.pipeline.utils;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class SeedDemoTest {

    private static final Logger logger = LogManager.getLogger(SeedDemoTest.class);

    @Test
    void repeatedRuns() {
        SeedDemo demo = new SeedDemo();
        for (int i = 0; i < 5; i++) {
            logger.info("Run " + i + ": " + demo.withSeed(5.0));
        }
    }
}
