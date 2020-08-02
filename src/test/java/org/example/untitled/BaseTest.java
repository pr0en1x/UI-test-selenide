package org.example.untitled;

import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Configuration.*;

public class BaseTest {
    @BeforeTest
    public static void setup() {
        timeout = 10000;
        baseUrl = "http://gmail.com";
        browser = "chrome";
        startMaximized = true;
    }
}
