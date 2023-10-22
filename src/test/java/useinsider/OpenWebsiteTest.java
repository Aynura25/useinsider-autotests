package useinsider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenWebsiteTest {
    public static void main(String[] args) {
        // Устанавливаем путь к chromedriver
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        // Инициализация объекта WebDriver
        WebDriver driver = new ChromeDriver();

        // Открываем веб-сайт
        driver.get("https://useinsider.com/");

        // Проверяем, открыта ли домашняя страница Insider
        String expectedTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Домашняя страница Insider открыта успешно.");
        } else {
            System.out.println("Домашняя страница Insider не открыта.");
        }

        // Закрываем браузер
        driver.quit();
    }
}
