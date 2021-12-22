import PageObject.ClickPage;
import PageObject.FormPage;
import PageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestPageObject {

    WebDriver driver;
    LoginPage login;
    FormPage form;
    ClickPage click;


    @BeforeClass
    public void Run(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/webdriveradvance.html");

        login = PageFactory.initElements(driver, LoginPage.class);
        form = PageFactory.initElements(driver, FormPage.class);
        click = PageFactory.initElements(driver, ClickPage.class);
    }

    @AfterClass
    public void closeSession(){
        //driver.quit();
    }

    @Test
    public void test1(){

        login.ActionLogin("selenium","webdriver");
        form.action("Software Engineer","35","Givat Olga");
        assertTrue(click.button.isDisplayed());

    }
}
