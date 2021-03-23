package tests;

import com.codeborne.selenide.Configuration;
import driver.LocalMobileDriver;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.appium.java_client.MobileBy.AccessibilityId;

public class LocalTests {

    @BeforeAll
    public static void configureSelenide() {
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @Test
    void gettingStarted() {
        open();

        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages"));

        $(AccessibilityId("Continue")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));

        $(AccessibilityId("Continue")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));

        $(AccessibilityId("Continue")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data"));

        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/view_announcement_text")).shouldHave(text("Customize your Explore feed You can now choose what to show on your feed, and also prioritize your favorite types of content."));


    }

}
