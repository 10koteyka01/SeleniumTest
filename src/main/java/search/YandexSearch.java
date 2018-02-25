package search;

public class YandexSearch extends Search {
    public YandexSearch() {
        searcherName = "yandex";
        nameForFindResults = "//input[@name='text']";
    }
}
