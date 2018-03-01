import SearchInPerformance.PerfSearch;
import Service.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import search.*;

import java.util.ArrayList;
import java.util.List;

public class SeleniumTest {
    private static List<Search> searchList = new ArrayList();

    static {
        searchList.add(new Search("yandex", "performance-lab"));
        searchList.add(new Search("google", "performance-lab"));
        searchList.add(new Search("rambler", "performance-lab"));
    }

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        Helper.driver = driver;
        for(Search searcher : searchList){
            PerfSearch perfSearch = new PerfSearch(searcher.getSearchResult(), searcher.getSearcherName());
            perfSearch.openPerfSyte();
        }
        driver.quit();
    }

}
