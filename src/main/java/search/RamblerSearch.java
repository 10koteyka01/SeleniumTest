package search;

import Service.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class RamblerSearch extends Search {

    public RamblerSearch() {
        searcherName = "rambler";
        nameForFindResults = "//input[@type='text']";
    }

    @Override
    protected WebElement findElementsByTagName(){
        inputQuery();
        Helper.switchWindow();
        List<WebElement> elementList = Helper.driver.findElements(By.tagName("a"));
        for (WebElement el : elementList){
            if (el.getText().equals("Перфоманс Лаб | Тестирование и QA")) {
                el.click();
                return el;
            }
        }
        return null;
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
