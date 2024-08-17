package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Hrmloginsteps {
WebDriver driver;
String url;
String Username;
String password;

@Given("I launch chrome browser")
public void i_launch_chrome_browser() throws IOException {
	driver=new ChromeDriver();
	driver.manage().window().maximize();  
    
}
@When("I open orange hrm page")
public void i_open_orange_hrm_page() throws IOException {
	driver.get("https://www.google.com");
	driver.navigate();
	driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");	
}
@Then("I verify that username and password")
public void i_verify_that_username_and_password() throws Exception {
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
    driver.findElement(By.id("btnLogin")).click();
driver.findElement(By.xpath("//b[text()='Admin']")).click();
driver.findElement(By.id("menu_admin_UserManagement")).click();
driver.findElement(By.id("searchSystemUser_userName")).sendKeys("sravani.guduru");
driver.findElement(By.name("searchSystemUser[employeeName][empName]")).sendKeys("sravani");
driver.findElement(By.name("btnAdd")).click();
driver.findElement(By.name("systemUser[employeeName][empName]")).sendKeys("Dastagiri Rohit");
driver.findElement(By.id("systemUser_userName")).sendKeys("Sravas");
driver.findElement(By.id("systemUser_password")).sendKeys("Qedgetech123!@#");
driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Qedgetech123!@#");
driver.findElement(By.id("btnSave")).submit();
Thread.sleep(50000);



//capture the screenshot
		String screenshotPath = "D:\\web tracker\\OrangeHrm\\path\\to\\save\\Screenshots1.png";
		Screenshotutilities.captureScreenshot(driver, screenshotPath);
}

@Then("close browser")
public void close_browser()  {
	driver.close();
}
	
//	//Load the excel file
//		String filePath = "D:\\web tracker\\OrangeHrm\\food Delivery for testcases.xlsx";
//	  String sheetName = "Sheet1";
//	  try {
//		propertiesutilities.loadExcel(filePath, sheetName);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	  
//	  //read  data from the excel file
//	  
//	  String url = propertiesutilities.getCellData(1, 0); 
//	  String Username =propertiesutilities.getCellData(1, 1);
//	  String password =propertiesutilities.getCellData(1, 2);
//	
//	try {
//		Thread.sleep(5000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//
//	//Capture result and write back to Excel
//
//	WebElement result = driver.findElement(By.id("result-stats"));
//	String resultText = result.getText();
//	propertiesutilities.setCellData(1, 2, resultText);
//	  
//	
//	try {
//		propertiesutilities.saveExcel("D:\\web tracker\\OrangeHrm\\food Delivery for testcases.xlsx");
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
	
    

@Then("I verify that  invalidusername and  invalidpassword")
public void i_verify_that_invalidusername_and_invalidpassword() {  {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin123");
	    driver.findElement(By.id("txtPassword")).sendKeys("Qedge1223!@#");
	    driver.findElement(By.id("btnLogin")).click();
}
}
}


