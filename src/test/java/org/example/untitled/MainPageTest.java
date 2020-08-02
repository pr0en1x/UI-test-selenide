package org.example.untitled;

import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

@Listeners({ ScreenShooter.class})
public class MainPageTest extends BaseTest {
    @Step("Проверить, что количество писем увеличивается")
    @Test
    public void mainPageTest() throws IOException {
        LoginPage loginPage = open("/", LoginPage.class);
        MailPage mailPage = loginPage.loginWithCorrectLoginAndPassword();
        int lettersCount = mailPage.lettersCount();
        mailPage.sendMessage(lettersCount);
        Assert.assertTrue(mailPage.lettersCount() > lettersCount);
    }
}