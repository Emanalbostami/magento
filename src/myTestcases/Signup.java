package myTestcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Signup extends Parameters {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(priority = 1)
	public void myFirstTest() throws InterruptedException {

		driver.get("https://magento.softwaretestingboard.com/");

		driver.findElement(By.linkText("Create an Account")).click();

		// find the elements
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));

		WebElement createAccountButtonElement = driver
				.findElement(By.cssSelector("button[title='Create an Account'] span"));

		// interact with the elements

		FirstName.sendKeys(FirstNames[randomIndex]);
		LastName.sendKeys(lastNames[randomIndex]);
		Email.sendKeys(emailID);
		Password.sendKeys(CommonPassword);
		confirmPassword.sendKeys(CommonPassword);

		createAccountButtonElement.click();

		String WelcomeMsg = driver.findElement(By.className("message-success")).getText();

		assertEquals(WelcomeMsg, "Thank you for registering with Main Website Store.");

	}
	@Test(priority = 2)
	public void Logout() {
		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
		System.out.println(driver.getCurrentUrl());
		boolean Actual = driver.getCurrentUrl().contains("logoutSuccess");
		assertEquals(Actual, true);
	}
	@Test(priority = 3)
	public void LogInProcess() throws InterruptedException {
	driver.findElement(By.linkText("Sign In")).click();	
	driver.findElement(By.id("email")).sendKeys(emailID);
	driver.findElement(By.id("pass")).sendKeys(CommonPassword);
    driver.findElement(By.id("send2")).click();
    Thread.sleep(2000);
	boolean ActualWelcomeMessage= driver.findElement(By.cssSelector(".greet.welcome")).getText().contains("Welcome");
	assertEquals(ActualWelcomeMessage, true);
	}
	@Test(priority = 4)
	public void AddToCart() {
    driver.get("https://magento.softwaretestingboard.com/");
    Random rand =new Random();
    driver.findElements(By.tagName("a")).size();
    System.out.println(driver.findElements(By.tagName("a")).size());
    WebElement Footer= driver.findElement(By.cssSelector(".footer.content"));
    int TheAtag= Footer.findElements(By.tagName("a")).size();
    System.out.println(TheAtag);
	}



}
