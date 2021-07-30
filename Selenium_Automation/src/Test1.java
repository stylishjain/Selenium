import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;






public class Test1 {
	public static String  browser  ="Chrome";
	public static WebDriver driver;

	public static void main(String[] args)  throws InterruptedException {
	
	
		  ChromeOptions options = new ChromeOptions(); 
   

   if(browser.equals("Chrome")) {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\oshin.jain\\eclipse-workspace\\Selenium_Automation\\src\\utilities\\chromedriver.exe");
	   options.addArguments("--disable-notifications");
    driver= new ChromeDriver(options);
      
    		
   }
   else {
	   System.setProperty("webdriver.gecko.driver","C:\\Users\\oshin.jain\\eclipse-workspace\\Selenium_Automation\\src\\utilities\\geckodriver.exe");

	  driver =new FirefoxDriver();
   }
   driver.get("https://www.yatra.com/");
   driver.manage().window().maximize();
   Thread.sleep(2000);
   WebElement offerbtn = driver.findElement(By.xpath("//ul[@class=\"justified-menu desktop-navs settings-content responsivetabshow\"]/li[3]"));
 //  offerbtn.click();
 

   try{
	offerbtn.click();
	   }catch (Exception e) {
	   System.out.println("Offer element is not found.");
	   throw(e);
	   }
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   driver.getTitle().contains("Great Offers & Amazing Deals");
   
   String bodyText = driver.findElement(By.xpath("//h2[contains(text(),'Great Offers & Amazing Deals')]")).getText();
  try {
  if(bodyText.contains("Great Offers & Amazing Deals")) {
	System.out.println("cool");  
  }
  }
  catch(Exception e) {
	  throw(e);
  }
  if(driver.getTitle().contains("Domestic Flights Offers | Deals on Domestic Flight Booking | Yatra.com")) {
	  System.out.println("Title is Present");
  }
  else {
	  System.out.println("Not Present");
	  
  }
  WebElement holiday=driver.findElement(By.xpath("//*[@id=\"offer-box-shadow\"]/li[4]"));
  holiday.click();
  Thread.sleep(2000);

  List<WebElement> cart = driver.findElements(By.xpath("//*[@id=\"collapsibleSection\"]/section[1]/div[2]/div/section/div/div/ul/li"));
  //for(WebElement e:cart) {
  //for (WebElement e : cart) {



	
	//  }
	   
    
	//}

  driver.quit();
  driver.close();
  
	}
	
	
	

}  

