package io.github.racoondog.cdidlib;

public class DeviceIdentifier {
    private final DeviceIdentifierBuilder builder;
    private String cachedId = null;

    public DeviceIdentifier(DeviceIdentifierBuilder builder) {
        this.builder = builder;
    }

    public String get() {
        return cachedId == null ? generate() : cachedId;
    }

    public String generate() {
        return cachedId = builder.generate();
    }

    public static DeviceIdentifierBuilder builder() {
        return DeviceIdentifierBuilder.builder();
    }
}
