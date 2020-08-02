package org.example.untitled;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MailPage {
    final Path tokenFile = Paths.get(System.getProperty("user.home")).resolve("config");
    final String login = Files.readAllLines(tokenFile).get(0).trim();

    public MailPage() throws IOException {
    }

    public int lettersCount() {
        Predicate <WebElement> predicate = s -> s.getText().contains("Simbirsoft theme");
        return $$(".y6").filterBy(Condition.text("Simbirsoft theme")).shouldBe(CollectionCondition.allMatch("filter", predicate)).size();
    }

    public void sendMessage(int count) {
        $(".aic").click();
        $(byText("Loading")).waitUntil(disappears, 20000);
        $(By.name("to")).val(login).pressTab();
        $(By.name("subjectbox")).val("Simbirsoft theme").pressTab();
        if (count < 5)
            $(".editable").val("Найдено " + count + " письма").shouldHave(Condition.matchText("Найдено"));
        else
            $(".editable").val("Найдено " + count + " писем").shouldHave(Condition.matchText("Найдено"));
        $(".dC").click();
    }
}
