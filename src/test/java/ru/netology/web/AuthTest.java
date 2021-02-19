package ru.netology.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.web.DataGenerator.Registration.generateBlockedUser;

public class AuthTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldSendFormValid() {
        UserInfo validUserInfo = DataGenerator.Registration.generateValidUser();
        $("[data-test-id=login] input").setValue(validUserInfo.getLogin());
        $("[data-test-id=password] input").setValue(validUserInfo.getPassword());
        $("button[data-test-id=action-login]").click();
        $(".App_appContainer__3jRx1").shouldBe(visible).shouldHave(text("Личный кабинет"));
    }

    @Test
    void shouldSendFormBlockedUser() {
        UserInfo blockedUserInfo = generateBlockedUser();
        $("[data-test-id=login] input").setValue(blockedUserInfo.getLogin());
        $("[data-test-id=password] input").setValue(blockedUserInfo.getPassword());
        $("button[data-test-id=action-login]").click();
        $("[data-test-id=error-notification]").shouldBe(visible).shouldHave(text("Ошибка"));
    }
}


