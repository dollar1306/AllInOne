package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(css = "input[name='username2']")
    public WebElement userName;

    @FindBy(css = "input[name='password2']")
    public WebElement pass;

    @FindBy(id = "submit")
    public WebElement btn;

    public void ActionLogin(String UserName, String Password){
        userName.sendKeys(UserName);
        pass.sendKeys(Password);
        btn.click();
    }
}
