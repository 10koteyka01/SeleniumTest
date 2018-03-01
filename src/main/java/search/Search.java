package search;

import Service.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class Search {

    private String query;
    private String searcherName;
    private WebElement element;
    private Map<String, String> searchersMap;

    public Search(String searcherName, String query) {
        this.searcherName = searcherName;
        this.query = query;
    }

    public Search(String searcherName) {
        this.searcherName = searcherName;
    }

    {
        searchersMap = new HashMap();
        searchersMap.put("yandex", "//input[@name='text']");
        searchersMap.put("google", "//input[@title='Поиск']");
        searchersMap.put("rambler", "//input[@type='text']");
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

    private WebElement findElementsByTagName(){
        inputQuery();
        Helper.switchWindow();
        WebElement element = Helper.driver.findElement(By.xpath("//a[@href='http://www." + query + ".ru/']"));
        element.click();
        return element;
    }

    private void inputQuery(){
        Helper.driver.get("https://"+ searcherName + ".ru/");
        element = Helper.driver.findElement(By.xpath(searchersMap.get(searcherName)));
        element.sendKeys(query);
        startSearch();
    }

    private void startSearch(){
        if (searcherName.equals("rambler"))
            startSearchInBrowserWithButton();
        else
            startSearchInBrowserWithoutButton();
    }

    private void startSearchInBrowserWithButton(){
        element = Helper.driver.findElement(By.xpath("//button[@data-cerber-head='main::search::button']"));
        element.click();
    }

    private void startSearchInBrowserWithoutButton(){
        element.submit();
    }
}

