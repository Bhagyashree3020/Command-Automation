package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import org.openqa.selenium.support.ui.Select;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Read_excel {
	static WebDriver driver;
	
	
	
	static {
	
        // System Property for Chrome Driver   
     System.setProperty("webdriver.chrome.driver","/home/akhilesh/Desktop/dependencies/chromedriver_linux64/chromedriver");  
       
          // Instantiate a ChromeDriver class.     
    driver=new ChromeDriver();  
     
     
     driver.manage().window().maximize();
        
     //driver.get("https://164.52.194.28:8181/miko3/IntentTesting.html"); // prod link
     //driver.get("https://usprod1.miko2.ai:8181/miko3/IntentTesting.html"); // prod link 
     driver.get("http://usprod1.miko2.ai:8080/miko3/IntentTesting.html");
     
     //driver.findElement(By.id("details-button")).click();
     //driver.findElement(By.id("proceed-link")).click();
     driver.findElement(By.id("useremail")).sendKeys("000A7B"); // bot number, turn off th bot for loading the resutls here
     driver.findElement(By.id("userpassword")).sendKeys("AFB901"); //this is password
     driver.findElement(By.id("login")).click();
//     Select lang =  new Select(driver.findElement(By.name("language")));
//     lang.selectByVisibleText("Hindi");
     try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

     
      
	}

	
	
	public static void main(String []args) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		  
		FileInputStream fis=new FileInputStream("/home/akhilesh/Desktop/dependencies/Blog New.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		for (int i=1; i<=241;i++)  
		{
		String ab = wb.getSheet("Web-Socket side").getRow(i).getCell(1).getStringCellValue();
		WebElement textfield = driver.findElement(By.id("messageText"));
		WebElement SendBtn = driver.findElement(By.id("send"));
		textfield.sendKeys(ab);
		Thread.sleep(1000);
		SendBtn.click();
		Thread.sleep(4000);
		textfield.clear();
		
		
		}
		
	}
}
