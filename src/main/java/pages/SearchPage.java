package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ActionsMethods;
public class SearchPage extends ActionsMethods{
    private By searchTextFiled = By.id("APjFqb");
    private By ChefaaLink = By.partialLinkText("شفاء لطلب كل احتياجاتك من الصيدلية أونلاين");

    private By ImageButton = By.xpath("//span[@class='FMKtTb UqcIvb'][contains(text(),'صور')]");
    private By ImageSelected = By.xpath("//span[contains(@class,'NZmxZe rQEFy')]");
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void SearchForText(String text){

        setText(searchTextFiled,text);
    }
    public void SelectOneOfDisplayedResult(String text) {
        setText(searchTextFiled,text);
        waitElementVisability(ChefaaLink,120);
        clickLink(ChefaaLink);

    }

    public void SearchWithTextForImage(String text) {
        setText(searchTextFiled,text);
        waitElementVisability(ImageButton,120);
        clickLink(ImageButton);


    }
    public boolean IsEnableLink(){
        waitElementVisability(ImageSelected,120);
        return driver.findElement(ImageSelected).isEnabled();

    }

}
