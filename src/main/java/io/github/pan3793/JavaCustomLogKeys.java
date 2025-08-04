package io.github.pan3793;

import org.apache.spark.internal.LogKey;

// CUSTOM_LOG_KEY is compatible with both Spark 4.0 and SPARK-53064
public class JavaCustomLogKeys {
  // Custom `LogKey` must be `implements LogKey`
  public static class CUSTOM_LOG_KEY implements LogKey {
    @Override
    public String name() {
      return "custom_log_key";
    }
  }

  // Singleton
  public static final CUSTOM_LOG_KEY CUSTOM_LOG_KEY = new CUSTOM_LOG_KEY();
}
