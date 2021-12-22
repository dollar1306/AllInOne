package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage {
    @FindBy(id = "occupation")
    private WebElement occupation;

    @FindBy(id = "age")
    private WebElement age;

    @FindBy(id = "location")
    private WebElement location ;

    @FindBy(css = "input[value='Click Me']")
    private WebElement clickMe ;

    public void action(String sOccupation, String Age, String Location) {
        occupation.sendKeys(sOccupation);
        age.sendKeys(Age);
        location.sendKeys(Location);
        clickMe.click();
    }
}
