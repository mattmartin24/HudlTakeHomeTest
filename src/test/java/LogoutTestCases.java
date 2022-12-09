import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoutTestCases {
    @Test
    @Parameters({"validEmail", "validPassword"})
    public static void logoutTest(String validEmail, String validPassword) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.hudl.com");

        MainHomePage mainHomePage = new MainHomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        System.out.println("1. Click the Hudl homepage login button");
        mainHomePage.clickLoginRedirect();

        System.out.println("2. Input a valid email in the Email field");
        loginPage.inputEmail(validEmail);

        System.out.println("3. Input a valid password in the Password field");
        loginPage.inputPassword(validPassword);

        System.out.println("4. Click the Login button");
        loginPage.clickLogin();

        System.out.println("5. Validate that the user is redirected to the Hudl homepage after logging in");
        wait.until(ExpectedConditions.titleContains("Home"));
        String expectedURL = "https://www.hudl.com/home";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL,
                "The actual URL for the page does not match the expected URL");

        System.out.println("6. Click the user menu then click the Log Out button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPage.globalUserMenu));
        dashboardPage.clickLogout();

        System.out.println("7. Validate that the user is redirected to the main Hudl homepage after logging out");
        String loggedOutExpectedURL = "https://www.hudl.com/";
        String loggedOutActualURL = driver.getCurrentUrl();
        Assert.assertEquals(loggedOutActualURL, loggedOutExpectedURL,
                "The actual URL for the page does not match the expected URL");

        driver.quit();
    }
}
