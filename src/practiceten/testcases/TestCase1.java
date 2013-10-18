package practiceten.testcases;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import practicefour.Wait;
import practiceten.BrowsersType;
import practiceten.MutipleTasks;

public class TestCase1 extends MutipleTasks{

	private WebDriver driver;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user.dir");
	private Wait wait = null;
	

	@BeforeClass
	public void beforeClass(){
		String node = map.get("node1");
		BrowsersType browser = new BrowsersType();
		//driver = browser.setFirefox(node);
		//driver = browser.setChrome(node);
		driver = browser.setIE(node);
		
		wait =  new Wait(driver);
	}

	
	
	@Test
	public void selectItemFromDropDownList(){	
		
		//��¼jd�ٷ���վ
		driver.get("http://www.jd.com");
		wait.waitForElementPresent("//a[text()='[��¼]']");
		driver.findElement(By.xpath("//a[text()='[��¼]']")).click();		
		//��¼�û���Ϣ
		wait.waitForElementPresent("//input[@id='loginname']");
		driver.findElement(By.xpath("//input[@id='loginname']")).sendKeys("test201301@mailinator.com");
		driver.findElement(By.xpath("//input[@id='nloginpwd']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='loginsubmit']")).click();
		//��¼������Ϣ
		driver.findElement(By.xpath("//a[text()='�ҵĶ���']")).click();
		driver.findElement(By.xpath("//a[text()='�˻���Ϣ']")).click();	
		//ѡ���Ϻ���Ϊ����province
		Select province = new Select(driver.findElement(By.xpath("//select[@id='province']")));
		province.selectByVisibleText("�Ϻ�");
		wait.waitFor(3000);
		//��ӡ�Ϻ��µ���������
		Select city = new Select(driver.findElement(By.xpath("//select[@id='city']")));
		List<WebElement> allcitys = city.getOptions();
		for(WebElement eachcity:allcitys)
			System.out.println(eachcity.getText());
		
	}
	
	

	
	

	
	
	
	
	
	
	
	
	@AfterClass
	public void releaseFFDriver(){
		driver.quit();
	}
}
