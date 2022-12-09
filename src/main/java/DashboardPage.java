import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    public static WebDriver driver;
    public DashboardPage(WebDriver driver) {
        this.driver=driver;
    }

    //Buttons
    By globalUserMenu = By.xpath("//div[@class='hui-globalusermenu']");
    By logoutButton = By.xpath("//a[@data-qa-id='webnav-usermenu-logout']");

    //Fields

    //Actions
    public void clickLogout() {
        driver.findElement(globalUserMenu).click();
        driver.findElement(logoutButton).click();
    }
}

