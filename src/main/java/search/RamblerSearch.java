package search;

import Service.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RamblerSearch extends Search {

    public RamblerSearch() {
        searcherName = "rambler";
        nameForFindResults = "//input[@type='text']";
        tagName = "//a[@href='http://www.performance-lab.ru/']";
    }


    @Override
    protected void inputQuery(){
        Helper.driver.get("https://www.rambler.ru/");
        WebElement element = Helper.driver.findElement(By.xpath(nameForFindResults));
        element.sendKeys(query);
        element = Helper.driver.findElement(By.xpath("//button[@data-cerber-head='main::search::button']"));
        element.click();
    }
}
