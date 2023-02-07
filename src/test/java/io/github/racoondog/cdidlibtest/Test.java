package io.github.racoondog.cdidlibtest;

import io.github.racoondog.cdidlib.DeviceIdentifier;

public class Test {
    public static void main(String[] args) {
        DeviceIdentifier identifier = DeviceIdentifier.builder()
                .addAccountName()
                .addOs()
                .build();

        System.out.println(identifier.get());
    }
}
