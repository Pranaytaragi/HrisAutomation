package com.hris.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.action.HrisAction;

public class Hristesting {
	HrisAction h=new HrisAction();
	@BeforeClass
	public void launch()
	{
		h.launchbrowser();
		
	}
	
	@Test
	public void Test01_enter_wrong_UId_and_password()
	{
		h.try_to_enter_UId_and_wrong_password();
	}
	
    @Test
    public void Test02_enter_UId_and_empty_password()
    {
	h.try_to_submit_with_empty_password();
	}
    
    @Test
    public void Test03_submit_without_entering_anything()
    {
    	h.submit_without_entering_anything();
    }
    
    @Test
  	public void Test04_enter_correct_UId_and_password()
  	{
  		h.try_to_enter_correct_UId_and_password();
  	}
    
    @Test
    public void Test05_checking_the_name()
    {
    	h.checking_the_name();
    	
    }
    @Test
    public void Test06_checking_the_month()
    {
    	h.checking_the_month();
    }
    @Test
    public void Test07_clicking_on_13_june_2018() throws InterruptedException 
    {
    	
    	h.clicking_on_13_june_2018();
    }
    @Test
    public void Test08_click_on_logout_button()
    {
    	h.click_on_logout_button();
    }



}
