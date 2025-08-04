package io.github.pan3793;

import org.apache.spark.internal.MDC;
import org.apache.spark.internal.SparkLogger;
import org.apache.spark.internal.SparkLoggerFactory;
import org.apache.spark.sql.SparkSession;

public class Main {
  static SparkLogger LOG = SparkLoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    SparkSession spark = SparkSession.builder().getOrCreate();
    LOG.info("Spark version is: {}", MDC.of(JavaCustomLogKeys.CUSTOM_LOG_KEY, spark.version()));
  }
}
