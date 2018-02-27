package search;

public class GoogleSearch extends Search {
    public GoogleSearch() {
        searcherName = "google";
        nameForFindResults = "//input[@title='Поиск']";
        tagName = "//a[@href='http://www.performance-lab.ru/']";
    }

}
