package com.qait.action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HrisAction {
	
	
	String HrisUrl="https://hris.qainfotech.com/login.php";
	WebDriver driver=setup();
	
	public WebDriver setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pranaytaragi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
		
	}
	
	public void launchbrowser()
	{
		driver.get(HrisUrl);
		System.out.print("browser launched!!");
		
	}
	
	public void try_to_enter_UId_and_wrong_password()
	{
		
		driver.findElement(By.className("active ")).click();
		driver.findElement(By.id("txtUserName")).click();
        driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("pranaytaragi");
		driver.findElement(By.id("txtPassword")).click();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("WrongPassword");
		driver.findElement(By.id("txtPassword")).submit();
		driver.findElement(By.className("active ")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector(".alert-error")).getText().contains("Invalid Login"));
		
		
	}
	
	public void try_to_submit_with_empty_password()
	{
		
		driver.findElement(By.className("active ")).click();
		driver.findElement(By.id("txtUserName")).click();
        driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("pranaytaragi");
		driver.findElement(By.id("txtPassword")).click();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtPassword")).submit();
		String pass=driver.findElement(By.id("txtPassword")).getAttribute("style");

		Assert.assertTrue(pass.contains("red"));
	}
	public void submit_without_entering_anything()
	{
		
		driver.findElement(By.className("active ")).click();
		driver.findElement(By.id("txtUserName")).click();
        driver.findElement(By.id("txtUserName")).clear();
        driver.findElement(By.id("txtPassword")).click();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).submit();
		String UId=driver.findElement(By.id("txtUserName")).getAttribute("style");
		
		Assert.assertTrue(UId.contains("red; box-shadow: red 0px 1px 1px inset, red 0px 0px 4px"));
		
	}
	
	public void try_to_enter_correct_UId_and_password()
	{
		
        driver.findElement(By.className("active ")).click();
		driver.findElement(By.id("txtUserName")).click();
        driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("pranaytaragi");
		driver.findElement(By.id("txtPassword")).click();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("Pranay@321#");
		driver.findElement(By.xpath("//input[@class='btn pull-left']")).click();
		
	}

	public void checking_the_name()
	{
		driver.findElement(By.xpath("//a[@title='Time']")).click();
//		WebDriverWait wait=new WebDriverWait(driver, 100);
		String s=driver.findElement(By.xpath("//span[@class='ng-binding']")).getText();
		System.out.print(s);
		Assert.assertTrue(s.contains("Pranay Taragi"));
	}
	
	public void checking_the_month()
	{
		String month=driver.findElement(By.xpath("//span[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope moment-picker-input ng-not-empty ng-valid-min-date ng-valid-max-date']")).getText();
		Assert.assertTrue(month.contains("June 2018"));
	}
	
	public void clicking_on_13_june_2018() throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver, 200);
//        driver.wait(3);
		driver.findElement(By.xpath("//div[@class='small ng-scope']")).click();
		driver.findElement(By.xpath("//h4[@id='selectedDates']/..//button[@class='close text-peace']/span")).click();
	}
	
	public void click_on_logout_button()
	{
	    driver.findElement(By.xpath("//ul[@class='profile-btn']")).click();
	    driver.findElement(By.xpath("//i[@class='fa fa-sign-out']")).click();
	}

}
