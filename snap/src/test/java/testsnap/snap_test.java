package testsnap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.elementpath.snap_elementpath;
import com.sbase.snapbasic;
import com.sinputs.snap_inputs;

public class snap_test {
	snap_elementpath spath=new snap_elementpath();
	snap_inputs sinputs=new snap_inputs();
	snapbasic sbase=new snapbasic();
	
	@BeforeClass
	//verify the browser loads properly
	public void launchBrowser() {
		sbase.launchChromebrowser("https://accounts.snapchat.com/accounts/v2/signup");
		sbase.driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
	}
	@Test(priority = 1)
	
	public void verify_signup() {
		
		WebElement firstname=sbase.driver.findElement(By.xpath(spath.fnpath));
		firstname.isEnabled();
		firstname.isDisplayed();
		firstname.sendKeys(sinputs.firstname);
		
		WebElement lastname=sbase.driver.findElement(By.xpath(spath.lnpath));
		lastname.isEnabled();
		lastname.isDisplayed();
		lastname.sendKeys(sinputs.lastname);
		
		WebElement username=sbase.driver.findElement(By.xpath(spath.unpath));
		username.isEnabled();
		username.isDisplayed();
		username.sendKeys(sinputs.uname);
		
		WebElement email=sbase.driver.findElement(By.xpath(spath.mailpath));
		email.isEnabled();
		email.isDisplayed();
		email.sendKeys(sinputs.email);
		
		WebElement password=sbase.driver.findElement(By.xpath(spath.psspth));
		password.isEnabled();
		password.isDisplayed();
		password.sendKeys(sinputs.pass);
		
		WebElement showpassword=sbase.driver.findElement(By.xpath(spath.showpassspath));
		showpassword.isEnabled();
		showpassword.isDisplayed();
		showpassword.click();
		
		WebElement month=sbase.driver.findElement(By.xpath(spath.monthpath));
		month.isEnabled();
		month.isDisplayed();
		month.click();
		
		String dropdown="/html/body/div[2]/div/main/div[1]/div/div/form/div[6]/div/div[1]/select";
		List<WebElement>months=sbase.driver.findElements(By.xpath(dropdown));
		
		System.out.println("month : "+months.size());
		for(int i=1;i<months.size();i++) {
			
			System.out.println(months.get(i).getText());
			WebElement clk=months.get(3);
			clk.click();
			
		}
		WebElement day=sbase.driver.findElement(By.xpath(spath.daypath));
		day.isEnabled();
		day.isDisplayed();
		day.sendKeys(sinputs.day);
		
		WebElement year=sbase.driver.findElement(By.xpath(spath.yearpath));
		year.isEnabled();
		year.isDisplayed();
		year.sendKeys(sinputs.year);
				
	}
	@AfterClass
	//verify the page closes after login
	public void closeBrowser() {
		//cbas.driver.close();
	}

}
