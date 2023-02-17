package automation_one;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.*;


public class TestTwo {

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
     
    
    // Test Illegal Char - Name Field 
	@Test
	public void fillform_nameField() {
		// Illegal characters in name
		WebElement playerName = driver.findElement(By.name("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhatIsYourName$ssYl8vfT$0$$en_US"));
		playerName.click();
		playerName.clear();
		playerName.sendKeys("Ronaldo& \" ? < > # { } % ~ ");
	        
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
		Assert.assertEquals(form_submitted_text, "Invalid text insertion");
	}
	
    // Test Illegal Char - Date Field 
	@Test
	public void fillform_dateField() {
		WebElement playerName = driver.findElement(By.name("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhatIsYourName$ssYl8vfT$0$$en_US"));
		playerName.click();
		playerName.clear();
		playerName.sendKeys("Ronaldo");
	    
		//Future Date - must not be allowed
		WebElement date = driver.findElement(By.className("form-control input-group-inset input-group-inset-after"));
		date.click();
		date.clear();
		date.sendKeys("12/02/3021");
		
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
		Assert.assertEquals(form_submitted_text, "Invalid text insertion");
	}
	
    // Test Illegal Char - TextArea Field 
	@Test
	public void fillform_textField() {
		WebElement playerName = driver.findElement(By.name("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhatIsYourName$ssYl8vfT$0$$en_US"));
		playerName.click();
		playerName.clear();
		playerName.sendKeys("Ronaldo");
	    
		WebElement date = driver.findElement(By.className("form-control input-group-inset input-group-inset-after"));
		date.click();
		date.clear();
		date.sendKeys("12/02/2023");
		
		WebElement textArea = driver.findElement(By.className("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhyDidYouJoinTheTestingArea$NRxkFhsV$0$$en_US"));
		textArea.click();
		textArea.clear();
		textArea.sendKeys("page.asp?id=1 or 1=1 -- true\r\n"
				+ "page.asp?id=1' or 1=1 -- true\r\n"
				+ "page.asp?id=1\" or 1=1 -- true\r\n"
				+ "page.asp?id=1 and 1=2 -- false");
		
		//Click Submit
		WebElement submit_button = driver.findElement(By.id("ddm-form-submit"));
		submit_button.click();
		
		//Verify the form is submitted
		WebElement form_submitted = driver.findElement(By.className("portlet-msg-success"));
		String form_submitted_text = form_submitted.getText();
		Assert.assertEquals(form_submitted_text, "Invalid text insertion");
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
		
}