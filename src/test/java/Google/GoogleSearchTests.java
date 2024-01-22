package Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.SearchPage;
import utils.ReadTestDataFromExcelFile;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import java.time.Duration;

public class GoogleSearchTests {

    WebDriver driver;
    SearchPage Searches;
    ReadTestDataFromExcelFile fileReader;


    @BeforeMethod
    public void BaseCase() {
        // System.setProperty("webDriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void Case1() {
        Searches = new SearchPage(driver);
        fileReader= new ReadTestDataFromExcelFile();
        Searches.SearchForText(fileReader.excelSetup(0,0,1));
        assertEquals("شفاء لطلب كل احتياجاتك من الصيدلية أونلاين","شفاء لطلب كل احتياجاتك من الصيدلية أونلاين");

    }

    @Test(priority = 2)
    public void Case2() {
        Searches = new SearchPage(driver);
        fileReader= new ReadTestDataFromExcelFile();
        Searches.SelectOneOfDisplayedResult(fileReader.excelSetup(0,0,1));
        assertEquals("الأدوية","الأدوية");

    }

    @Test(priority = 3)
    public void Case3() {
        Searches = new SearchPage(driver);
        fileReader= new ReadTestDataFromExcelFile();
        Searches.SearchWithTextForImage(fileReader.excelSetup(0,0,1));
        assertTrue(Searches.IsEnableLink());
    }

    @AfterMethod
    public void TheClosebrowser(){
        driver.close();
    }
}