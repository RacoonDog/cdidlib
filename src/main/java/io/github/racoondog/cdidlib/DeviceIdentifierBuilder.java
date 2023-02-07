package io.github.racoondog.cdidlib;

import com.sun.jna.Platform;
import io.github.racoondog.cdidlib.builders.LinuxDeviceIdentifierBuilder;
import io.github.racoondog.cdidlib.builders.MacDeviceIdentifierBuilder;
import io.github.racoondog.cdidlib.builders.WindowsDeviceIdentifierBuilder;
import io.github.racoondog.cdidlib.components.Component;
import io.github.racoondog.cdidlib.components.PropertyComponent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DeviceIdentifierBuilder {
    protected final List<Component> components = new ArrayList<>();
    private Function<String, String> function = Function.identity();

    // Generic Components

    public DeviceIdentifierBuilder add(Component component) {
        components.add(component);
        return this;
    }

    public DeviceIdentifierBuilder addAccountName() {
        return add(new PropertyComponent("accountName", "user.name"));
    }

    public DeviceIdentifierBuilder addOs() {
        return add(new PropertyComponent("osVersion", "os.name", "os.version"));
    }

    // Access Platform-Specific Components

    public DeviceIdentifierBuilder onWindows(Consumer<WindowsDeviceIdentifierBuilder> consumer) {
        return this;
    }

    public DeviceIdentifierBuilder onLinux(Consumer<LinuxDeviceIdentifierBuilder> consumer) {
        return this;
    }

    public DeviceIdentifierBuilder onMac(Consumer<MacDeviceIdentifierBuilder> consumer) {
        return this;
    }

    // Internal

    public DeviceIdentifierBuilder format(Function<String, String> function) {
        this.function = function;
        return this;
    }

    public DeviceIdentifier build() {
        return new DeviceIdentifier(this);
    }

    public String generate() {
        components.sort(Comparator.comparing(Component::getKey));
        String str = components.stream().map(Component::getValue).collect(Collectors.joining(", "));
        return function.apply(str);
    }

    public static DeviceIdentifierBuilder builder() {
        if (Platform.isWindows()) return new WindowsDeviceIdentifierBuilder();
        if (Platform.isLinux()) return new LinuxDeviceIdentifierBuilder();
        if (Platform.isMac()) return new MacDeviceIdentifierBuilder();
        return new DeviceIdentifierBuilder();
    }
}
