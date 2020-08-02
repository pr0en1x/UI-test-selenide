package org.example.untitled;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    final Path tokenFile = Paths.get(System.getProperty("user.home")).resolve("config");
    final String login = Files.readAllLines(tokenFile).get(0).trim();
    final String password = Files.readAllLines(tokenFile).get(1).trim();

    public LoginPage() throws IOException {
    }

    public MailPage loginWithCorrectLoginAndPassword() throws IOException {
        $("#identifierId").val(login).pressEnter();
        $("#password input").val(password).pressEnter();
        $(byText("Loading")).waitUntil(disappears, 20000);
        return page(MailPage.class);
    }
}
