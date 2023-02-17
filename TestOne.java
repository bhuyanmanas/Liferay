package automation_one;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.*;


public class TestOne {

	//setting the driver executable
	System.setProperty("webdriver.chrome.driver", "D:/Selenium/chromedriver.exe");

	//Initiating your chromedriver
	WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://docs.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

	@Test
	public void fillform() {
		WebElement playerName = driver.findElement(By.name("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhatIsYourName$ssYl8vfT$0$$en_US"));
		playerName.click();
		playerName.clear();
		playerName.sendKeys("Ronaldo");
	        
		WebElement date = driver.findElement(By.className("form-control input-group-inset input-group-inset-after"));
		date.click();
		date.clear();
		date.sendKeys("12/02/2023");
		
		WebElement textArea = driver.findElement(By.className("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhyDidYouJoinTheTestingArea$7ppJBp8E$0$$en_US"));
		textArea.click();
		textArea.clear();
		textArea.sendKeys("Cristiano Ronaldo dos Santos Aveiro GOIH ComM is a Portuguese professional footballer who plays as a forward for and captains both Saudi Professional League club Al Nassr and the Portugal national team.");
		
		//Click Submit
		WebElement submit_button = driver.findElement(By.id("ddm-form-submit"));
		submit_button.click();
		
		//Verify the form is submitted
		WebElement form_submitted = driver.findElement(By.className("portlet-msg-success"));
		String form_submitted_text = form_submitted.getText();
		Assert.assertEquals(form_submitted_text, "Your request completed successfully.");
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}