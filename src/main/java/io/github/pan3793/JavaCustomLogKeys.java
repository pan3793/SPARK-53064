package io.github.pan3793;

import org.apache.spark.internal.LogKey;

public class JavaCustomLogKeys {
  // Custom `LogKey` must be `implements LogKey`
  public static class CUSTOM_LOG_KEY implements LogKey { }

  // Singleton
  public static final CUSTOM_LOG_KEY CUSTOM_LOG_KEY = new CUSTOM_LOG_KEY();
}
