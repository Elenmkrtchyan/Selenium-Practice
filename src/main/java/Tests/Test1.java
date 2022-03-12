package Tests;

import Base.SeleniumBase;
import Pages.PageFirst;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test1 extends SeleniumBase {
    PageFirst pageFirst;

  @Test
    public void check(){
      pageFirst = new PageFirst(driver);
      pageFirst.categoriesAvailable();
      pageFirst.clickDressesButton();
      pageFirst.selectSortBy();
      pageFirst.availableItem();
      pageFirst.dressAvailable();
      pageFirst.mouseHover();
      pageFirst.clickCheckoutButton();
      pageFirst.checkDiscount(" -20% ");

  }




}
