package io.github.racoondog.cdidlib.components;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PropertyComponent extends Component {
    public PropertyComponent(String key, String property) {
        super(key, () -> System.getProperty(property));
    }

    public PropertyComponent(String key, String... properties) {
        super(key, () -> Arrays.stream(properties).map(System::getProperty).collect(Collectors.joining(" ")));
    }
}
