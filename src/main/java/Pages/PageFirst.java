package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PageFirst {
WebDriver driver;

    @FindBy (css ="a[title='Women']")
    WebElement womenButton;

    @FindBy (css = "#block_top_menu > ul > li:nth-child(2) > a")
    WebElement dressesButton;

    @FindBy (css = "#block_top_menu > ul > li:nth-child(3) > a")
    WebElement tshirtsButton;

    @FindBy (id = "selectProductSort")
    WebElement sortBy;

    @FindBy (className = "heading-counter")
    WebElement item;

    @FindBy (className = "product-name")
    List<WebElement> productNameList;


      @FindBy (css = ".button[data-id-product='7']")
      WebElement addToCard;

      @FindBy (css = "[title='Proceed to checkout']")
      WebElement checkoutButton;


      @FindBy (css = "#product_price_7_34_0 > span.price-percent-reduction.small")
      WebElement discount;




    public PageFirst (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void categoriesAvailable(){
       boolean fieldsVisibility = womenButton.isDisplayed() && dressesButton.isDisplayed() && tshirtsButton.isDisplayed();
        assertTrue("Categories are not available", fieldsVisibility);

    }

    public void clickDressesButton(){
        dressesButton.click();
    }

    public void selectSortBy() {
        Select select = new Select(sortBy);
        select.selectByValue("price:asc");
    }

    public void availableItem (){
        assertTrue("There aren't 5 products.", item.getText().equals("There are 5 products."));
    }
    public void dressAvailable () {

        for (int i = 0; i < productNameList.size(); i++) {
            if (productNameList.get(i).getText().equals("Printed Chiffon Dress")) {
                assertTrue("Isn't display", productNameList.get(i).isDisplayed());
                System.out.println("Printed Chiffon Dress is available");
            }
        }
    }
   public void mouseHover(){
    Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(By.xpath("//*[@id='center_column']/ul/li[5]/div/div[1]/div/a[1]/img"))).perform();
    actions.moveToElement(addToCard).perform();
    addToCard.click();
}

 public void clickCheckoutButton (){
  checkoutButton.click()  ;
    }


    public void checkDiscount (String expectedTitle) {
        String actualTitle = discount.getText();
        Assert.assertEquals(actualTitle, expectedTitle, "There is no discount");
    }

}
