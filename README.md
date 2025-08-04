## Background

SPARK-53064 proposes a breaking change on custom log key of Structured Logging Framework,
but it still possible to write a CUSTOM_LOG_KEY compatible with both Spark 4.0 and SPARK-53064,
this might be helpful for Spark plugin authors.

```java
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
```

## Test

To verify the compatibility, build this project and submit it to Spark.

```shell
./mvnw clean package
```

```shell
spark-4.0.0-bin-hadoop3/bin/spark-submit \
  --conf spark.log.structuredLogging.enabled=true \
  --class io.github.pan3793.Main \
  target/SPARK-53064-1.0.jar
```

```shell
spark-4.1.0-SNAPSHOT-bin-SPARK-53064/bin/spark-submit \
  --conf spark.log.structuredLogging.enabled=true \
  --class io.github.pan3793.Main \
  target/SPARK-53064-1.0.jar
```
