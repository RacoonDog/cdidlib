package io.github.racoondog.cdidlib.components;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EnvironmentComponent extends Component {
    public EnvironmentComponent(String key, String envVar) {
        super(key, () -> System.getenv(envVar));
    }

    public EnvironmentComponent(String key, String... envVars) {
        super(key, () -> Arrays.stream(envVars).map(System::getenv).collect(Collectors.joining(" ")));
    }
}
