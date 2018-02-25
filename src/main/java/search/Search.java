package search;

import Service.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Search {

    protected String query;
    protected String searcherName;
    protected String nameForFindResults;

    public void setQuery(String query){
        this.query = query;
    }




    public String getSearcherName(){
        return searcherName;
    }

    public WebElement getSearchResult() {
        return findElementsByTagName();
    }

    protected WebElement findElementsByTagName(){
        inputQuery();
        Helper.switchWindow();
        List<WebElement> elementList = Helper.driver.findElements(By.tagName("b"));
        for (WebElement el : elementList){
            if (el.getText().equals("performance-lab.ru")) {
                el.click();
                return el;
            }
        }
        return null;
    }

    protected void inputQuery(){
        Helper.driver.get("https://"+ searcherName + ".ru/");
        WebElement element = Helper.driver.findElement(By.xpath(nameForFindResults));
        element.sendKeys(query);
        element.submit();
    }
}
