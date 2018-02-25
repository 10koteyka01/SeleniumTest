import SearchInPerformance.PerfSearch;
import Service.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import search.*;

import java.util.HashMap;
import java.util.Map;

public class SeleniumTest {

    private static Map<String, Search> searchMap = new HashMap<>();

    static {
        searchMap.put("yandex", new YandexSearch());
//        searchMap.put("google", new GoogleSearch());
//        searchMap.put("rambler", new RamblerSearch());
    }

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        Helper.driver = driver;
        for(Map.Entry entry: searchMap.entrySet()){
            Search searcher = (Search) entry.getValue();
            searcher.setQuery("performance-lab");
            PerfSearch perfSearch = new PerfSearch(searcher.getSearchResult(), searcher.getSearcherName());
            perfSearch.openPerfSyte();
        }
        driver.quit();
    }

}
