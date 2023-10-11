package com.sbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class snapbasic {
public WebDriver driver;
	
	public void launchChromebrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.navigate().to(url);
	}

}
