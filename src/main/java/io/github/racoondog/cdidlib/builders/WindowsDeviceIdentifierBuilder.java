package io.github.racoondog.cdidlib.builders;

import io.github.racoondog.cdidlib.DeviceIdentifierBuilder;

import java.util.function.Consumer;

public class WindowsDeviceIdentifierBuilder extends DeviceIdentifierBuilder {
    @Override
    public DeviceIdentifierBuilder onWindows(Consumer<WindowsDeviceIdentifierBuilder> consumer) {
        consumer.accept(this);
        return super.onWindows(consumer);
    }
}
