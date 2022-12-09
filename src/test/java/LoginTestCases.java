import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestCases {
    @Test
    @Parameters({"validEmail", "validPassword"})
    public static void happyPathLogin(String validEmail, String validPassword) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.hudl.com");

        MainHomePage mainHomePage = new MainHomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

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

        driver.quit();
    }

    @Test
    @Parameters({"invalidEmail", "validPassword"})
    public static void invalidEmailLogin(String invalidEmail, String validPassword) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.hudl.com");

        MainHomePage mainHomePage = new MainHomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        System.out.println("1. Click the Hudl homepage login button");
        mainHomePage.clickLoginRedirect();

        System.out.println("2. Input a valid email in the Email field");
        loginPage.inputEmail(invalidEmail);

        System.out.println("3. Input a valid password in the Password field");
        loginPage.inputPassword(validPassword);

        System.out.println("4. Click the Login button");
        loginPage.clickLogin();

        System.out.println("5. Verify that the login error message is displayed to the user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.errorDisplay));
        String expectedError = "We didn't recognize that email and/or password.Need help?";
        String actualError = driver.findElement(loginPage.errorDisplay).getText();
        Assert.assertEquals(actualError, expectedError,
                "The actual error message does not match the expected error message");

        driver.quit();
    }

    @Test
    @Parameters({"validEmail", "invalidPassword"})
    public static void invalidPasswordLogin(String validEmail, String invalidPassword) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.hudl.com");

        MainHomePage mainHomePage = new MainHomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        System.out.println("1. Click the Hudl homepage login button");
        mainHomePage.clickLoginRedirect();

        System.out.println("2. Input a valid email in the Email field");
        loginPage.inputEmail(validEmail);

        System.out.println("3. Input a valid password in the Password field");
        loginPage.inputPassword(invalidPassword);

        System.out.println("4. Click the Login button");
        loginPage.clickLogin();

        System.out.println("5. Verify that the login error message is displayed to the user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.errorDisplay));
        String expectedError = "We didn't recognize that email and/or password.Need help?";
        String actualError = driver.findElement(loginPage.errorDisplay).getText();
        Assert.assertEquals(actualError, expectedError,
                "The actual error message does not match the expected error message");

        driver.quit();
    }

    @Test
    public static void needHelpRedirect() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.hudl.com");

        MainHomePage mainHomePage = new MainHomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        System.out.println("1. Click the Hudl homepage login button");
        mainHomePage.clickLoginRedirect();

        System.out.println("2. Click the Need Help? link");
        loginPage.clickNeedHelp();

        System.out.println("3. Verify that the user is redirected to the Login Help page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.needHelpLink));
        String expectedURL = "https://www.hudl.com/login/help#";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL,
                "The actual URL for the page does not match the expected URL");

        driver.quit();
    }

    @Test
    public static void signUpRedirect() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.hudl.com");

        MainHomePage mainHomePage = new MainHomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        System.out.println("1. Click the Hudl homepage login button");
        mainHomePage.clickLoginRedirect();

        System.out.println("2. Click the Sign Up link");
        loginPage.clickSignUp();

        System.out.println("3. Verify that the user is redirected to the sign up page");
        wait.until(ExpectedConditions.titleContains("Sign up for Hudl"));
        String expectedURL = "https://www.hudl.com/register/signup";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL,
                "The actual URL for the page does not match the expected URL");

        driver.quit();
    }

}
