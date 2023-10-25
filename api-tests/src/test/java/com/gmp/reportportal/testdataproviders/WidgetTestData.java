package com.gmp.reportportal.testdataproviders;

import java.util.Arrays;
import java.util.List;

public class WidgetTestData {

    public static List<Object[]> widgetParameters() {
        return Arrays.asList(
                new Object[]{"Searching by full dashboard name", "DEMO DASHBOARD"},
                new Object[]{"Searching by partial name", "DEMO"},
                new Object[]{"Searching by symbols", "BOA"},
                new Object[]{"Case-insensitive searching", "dAShboArd"},
                new Object[]{"Searching with space", "mo d"}
        );
    }
}
