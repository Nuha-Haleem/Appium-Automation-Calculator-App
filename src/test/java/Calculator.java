import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class Calculator {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("sdk_gphone64_x86_64");
        options.setUdid("emulator-5554");
        options.setPlatformName("Android");
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void additionTest() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.google.android.calculator:id/digit_2"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.google.android.calculator:id/digit_0"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.google.android.calculator:id/digit_3"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.google.android.calculator:id/op_add"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.google.android.calculator:id/digit_1"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.google.android.calculator:id/digit_8"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.google.android.calculator:id/digit_9"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.google.android.calculator:id/eq"))).click();

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.google.android.calculator:id/result_final"))).getText();

        Assert.assertEquals(result, "392");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
