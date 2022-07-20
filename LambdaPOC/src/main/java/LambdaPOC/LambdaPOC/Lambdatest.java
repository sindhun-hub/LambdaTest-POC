//This is maven project

package LambdaPOC.LambdaPOC; //<your package name>

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

public class Lambdatest {

	public RemoteWebDriver driver = null;
   String username = "anas.k";
	String accessKey = "BsFada2EwjrK5GiXFLeFGVooyMa5Hag43M81mR3noUDDP31KH6";
	
	@BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "Windows 10");
	     capabilities.setCapability("browserName", "Chrome");
	     capabilities.setCapability("version", "93.0"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("resolution","1024x768");
        capabilities.setCapability("build", "First Test");
        capabilities.setCapability("name", "Sample Test");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true);
        capabilities.setCapability("geoLocation","CN");// To capture console logs
    
        try {       
			driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);            
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        }
    }

	@Test(enabled = true)
	public void testScript() throws Exception {
				try {
					driver.get("https://www.rubrik.com/contact-sales");
					String defaultItem=driver.findElement(By.id("Country")).getAttribute("value");
					System.out.println("done " );
					System.out.println(defaultItem );
					driver.quit();					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
	}
}
