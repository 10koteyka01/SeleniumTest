package SearchInPerformance;

import Service.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class PerfSearch {


    private WebElement element;
    private String nameSearcher;
    private String pathFolder = "C:\\Users\\Zver\\Desktop\\";
    private String folderName = "PerfContent";

    public PerfSearch(WebElement element, String nameSearcher) {
        this.element = element;
        this.nameSearcher = nameSearcher;
    }

    public void setPathFolder(String pathFolder){
        this.pathFolder = pathFolder;
    }


    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public void openPerfSyte(){
        Helper.switchWindow();
        openAutomationPage();
        Helper.createFolder(pathFolder, folderName);
        writeContainingToFile();
    }

    private void openAutomationPage(){
        element = Helper.driver.findElement(By.partialLinkText("Автоматизация тестирования"));
        element.click();
    }

    private void writeContainingToFile(){
        try {
            Helper.writeWebElementsListToFile(Helper.driver.findElements(By.tagName("p")), fileNameConstructor());
        } catch (IOException e) {
           System.err.println(e);
        }
    }

    private String fileNameConstructor(){
        return pathFolder + folderName + "\\" + Helper.driver.getClass().getSimpleName() + "." + nameSearcher + ".txt";
    }
}
