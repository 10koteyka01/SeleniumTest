package Service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Helper {

    public static WebDriver driver;

    public static void createFolder(String pathName, String folderName){
        File folder = new File(pathName + File.separator + folderName);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public static void writeWebElementsListToFile(List<WebElement> list, String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        for (WebElement element : list) {
            fw.write(element.getText() + "\n");
        }
        fw.flush();
        fw.close();
    }

    public static void switchWindow(){
        if (isMoreThanOneWindows()) windowSwitching();
    }

    private static void windowSwitching(){
        String currentWindow = driver.getWindowHandle();
        driver.close();
        for (String handle : driver.getWindowHandles()) {
            if(!handle.equalsIgnoreCase(currentWindow)){
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    private static boolean isMoreThanOneWindows(){
        return driver.getWindowHandles().size() > 1;
    }
}
