package io.github.racoondog.cdidlib.components;

import java.util.function.Supplier;

public class Component {
    private final String key;
    private final Supplier<String> valueSupplier;

    public Component(String key, Supplier<String> valueSupplier) {
        this.key = key;
        this.valueSupplier = valueSupplier;
    }

    public String getValue() {
        return this.valueSupplier.get();
    }

    public String getKey() {
        return this.key;
    }
}
