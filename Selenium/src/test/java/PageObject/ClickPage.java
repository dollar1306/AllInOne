package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ClickPage {
    @FindBy(css = "button[type='button']")
    public WebElement button;
}
