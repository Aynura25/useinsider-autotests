package useinsider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsiderTest {
    public static void main(String[] args) {
        // Устанавливаем путь к chromedriver
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        // Инициализация объекта WebDriver
        WebDriver driver = new ChromeDriver();

        // Открываем веб-сайт
        driver.get("https://useinsider.com/");

        // Находим и кликаем по "Company" в меню
        WebElement links = driver.findElement(By.id("navbarDropdownMenuLink"));
        WebElement companyMenu = links.findElement(By.xpath("//a[text()='Company']"));
        companyMenu.click();

        // Находим и кликаем по "Careers"
        WebElement careersMenuItem = driver.findElement(By.xpath("//a[text()='Careers']"));
        careersMenuItem.click();


        // Проверяем, открыта ли страница "Careers"
        String expectedTitle = "Insider Careers";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Страница Careers открыта успешно.");
        } else {
            System.out.println("Страница Careers не открыта.");
        }

        // Проверяем наличие блоков на странице "Careers"
        WebElement locationsBlock = driver.findElement(By.id("locations"));
        WebElement teamsBlock = driver.findElement(By.id("teams"));
        WebElement lifeAtInsiderBlock = driver.findElement(By.id("life-at-insider"));

        if (locationsBlock.isDisplayed() && teamsBlock.isDisplayed() && lifeAtInsiderBlock.isDisplayed()) {
            System.out.println("Блоки Locations, Teams и Life at Insider отображаются на странице Careers.");
        } else {
            System.out.println("Не все блоки отображаются на странице Careers.");
        }

        // Закрываем браузер
        driver.quit();
    }
}
