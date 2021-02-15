import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        System.out.println("Start Browser");
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver");
        webDriver = new ChromeDriver();

        System.out.println("Open website");
        webDriver.get("https://ithillel.ua/");
    }

    @After
    public void cleanUp() {
        System.out.println("Close browser");
        if(webDriver != null)
            webDriver.quit();
    }

    @Test
    public void someTest() {
        System.out.println("Check url");
        assertEquals("https://ithillel.ua/", webDriver.getCurrentUrl());

        System.out.println("Check title");
        assertEquals("Компьютерная школа Hillel в Киеве: курсы IT технологий", webDriver.getTitle());
    }

    @Test
    public void registerToCourse() {
        System.out.println("Click on Register button");
        webDriver.findElement(By.id("signCoursesButton")).click();

        System.out.println("Enter name");
        webDriver.findElement(By.id("signCourses")).findElement(By.id("modal_name")).click();
        webDriver.findElement(By.id("signCourses")).findElement(By.id("modal_name")).sendKeys("Ъ");

        System.out.println("Enter email");
        webDriver.findElement(By.id("signCourses")).findElement(By.id("modal_email")).click();
        webDriver.findElement(By.id("signCourses")).findElement(By.id("modal_email")).sendKeys("ivan@gmail.com");

        System.out.println("Enter phonenumber");
        webDriver.findElement(By.id("signCourses")).findElement(By.id("modal_phone")).click();
        webDriver.findElement(By.id("signCourses")).findElement(By.id("modal_phone")).sendKeys("+38 (012) 345-67-89");

        System.out.println("Check error message");
        assertTrue(webDriver.findElement(By.id("signCourses")).findElement(By.className("modal__error")).getText().contains("Обязательно выберите курс, на который хотите отправить заявку"));

    }
}