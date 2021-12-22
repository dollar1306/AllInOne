package OpenBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class OpenBrowsers {
    private WebDriver driver;
    @Test
    public void OpenChrome(){

        WebDriverManager.chromedriver().setup();
        WebDriver Chromedriver = new ChromeDriver();
        Chromedriver.get("https://www.imdb.com/");
        Chromedriver.manage().window().maximize();
        Chromedriver.navigate().refresh();

        String ExpectedTitle = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
        String title = Chromedriver.getTitle();
        System.out.println("This is title: "+title);
        if(ExpectedTitle.equals(title)){
            System.out.println("The title equal");
        }
        else{
            System.out.println("title Not equal");
        }

        String ExpectedUrl = "https://www.imdb.com/";
        String Url = Chromedriver.getCurrentUrl();
        System.out.println("This is url: "+Url);
        if(ExpectedUrl.equals(Url)){
            System.out.println("The url equal");
        }
        else{
            System.out.println("url Not equal");
        }
    }
    @Test
    public void OpenFireFox(){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.co.il/");
        driver.manage().window().maximize();

        driver.navigate().to("https://www.bing.com/");
        driver.navigate().back();

        String title = driver.getTitle();
        System.out.println(title);


        if(driver.getPageSource().contains("bubble"))
            System.out.println("Exists");
        else
            System.out.println("Not Exists");
    }
}
