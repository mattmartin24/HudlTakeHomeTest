import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    //Alerts
    By errorDisplay = By.xpath("//p[@data-qa-id='error-display']");

    //Buttons
    By loginButton = By.xpath("//button[@id='logIn']");
    By needHelpLink = By.xpath("//a[@data-qa-id='need-help-link']");
    By signUpLink = By.xpath("//a[@href='/register/signup']");

    //Fields
    By emailField = By.xpath("//input[@id='email']");
    By passwordField = By.xpath("//input[@id='password']");

    //Actions
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public void clickNeedHelp() {
        driver.findElement(needHelpLink).click();
    }
    public void clickSignUp () {
        driver.findElement(signUpLink).click();
    }
    public void inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
}
