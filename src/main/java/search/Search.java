package search;

import Service.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Search {

    protected String query;
    protected String searcherName;
    protected String nameForFindResults;
    protected String tagName;

    public Search(String... parameters) {
        searcherName = parameters[0];
        query = parameters[1];
        nameForFindResults = parameters[2];
        tagName = parameters[3];
    }

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
        WebElement element = Helper.driver.findElement(By.xpath(tagName));
        element.click();
        return element;
    }

    protected void inputQuery(){
        Helper.driver.get("https://"+ searcherName + ".ru/");
        WebElement element = Helper.driver.findElement(By.xpath(nameForFindResults));
        element.sendKeys(query);
        if (searcherName.equals("rambler")){
            element = Helper.driver.findElement(By.xpath("//button[@data-cerber-head='main::search::button']"));
            element.click();
        } else
            element.submit();
    }
}
