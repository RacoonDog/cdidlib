package io.github.racoondog.cdidlib.builders;

import io.github.racoondog.cdidlib.DeviceIdentifierBuilder;

import java.util.function.Consumer;

public class LinuxDeviceIdentifierBuilder extends DeviceIdentifierBuilder {
    @Override
    public DeviceIdentifierBuilder onLinux(Consumer<LinuxDeviceIdentifierBuilder> consumer) {
        consumer.accept(this);
        return super.onLinux(consumer);
    }
}
