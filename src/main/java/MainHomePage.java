import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainHomePage {
    public static WebDriver driver;
    public MainHomePage(WebDriver driver) {
        this.driver=driver;
    }

    //Buttons
    By loginButton = By.xpath("//a[@data-qa-id='login']");

    //Actions
    public void clickLoginRedirect() {
        driver.findElement(loginButton).click();
    }
}
