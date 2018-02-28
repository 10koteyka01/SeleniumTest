import SearchInPerformance.PerfSearch;
import Service.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import search.*;

import java.util.HashMap;
import java.util.Map;

public class SeleniumTest {

    private static Map<String, Search> searchMap = new HashMap<>();

    static {
        searchMap.put("yandex", new Search("yandex", "performance-lab", "//input[@name='text']", "//a[@href='http://www.performance-lab.ru/']"));
        searchMap.put("google", new Search("google", "performance-lab", "//input[@title='Поиск']", "//a[@href='http://www.performance-lab.ru/']"));
        searchMap.put("rambler", new Search("rambler", "performance-lab", "//input[@type='text']", "//a[@href='http://www.performance-lab.ru/']"));
    }

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        Helper.driver = driver;
        for(Map.Entry entry: searchMap.entrySet()){
            Search searcher = (Search) entry.getValue();
//            searcher.setQuery("performance-lab");
            PerfSearch perfSearch = new PerfSearch(searcher.getSearchResult(), searcher.getSearcherName());
            perfSearch.openPerfSyte();
        }
        driver.quit();
    }

}
