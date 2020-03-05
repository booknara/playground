package com.booknara.practice.kotlin.annotation;

import java.util.Date;

public class JvmOverload {
    public JvmOverload() {
        JvmOverloadKt.bar();    // Compile error without @JvmOverloads
        JvmOverloadKt.bar(1, 0.1, "Custom string");

        Event event1 = new Event();
        Event event2 = new Event("Birthday party"); // Compile error without @JvmOverloads
        Event event3 = new Event("Celebration", new Date(),true);
    }
}
