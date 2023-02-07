package io.github.racoondog.cdidlib.builders;

import io.github.racoondog.cdidlib.DeviceIdentifierBuilder;

import java.util.function.Consumer;

public class MacDeviceIdentifierBuilder extends DeviceIdentifierBuilder {
    @Override
    public DeviceIdentifierBuilder onMac(Consumer<MacDeviceIdentifierBuilder> consumer) {
        consumer.accept(this);
        return super.onMac(consumer);
    }
}
