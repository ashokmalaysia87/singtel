package Stepdefinitions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.io.*;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TodoViewActive {
    String projpath;
	WebDriver driver;
	JavascriptExecutor js;
	@Given("User is on Todos management screen to view active")
	public void User_is_on_Todos_management_screen_to_view_active() {
	   
	   
	   projpath = System.getProperty("user.dir");
	   System.setProperty("webdriver.chrome.driver", projpath+"/src/test/resources/drivers/chromedriver.exe");
	   driver = new ChromeDriver();
	   System.out.println(projpath+"/src/test/resources/drivers/chromedriver.exe");
	   
	   
	   driver.navigate().to("https://todomvc.com/examples/vue");
	   
	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	   
	   driver.manage().window().maximize();
	   System.out.println("user is on Todo screen");
	   
	}

	@When("User creates the Todos and hit the Enter button and change the 1st Todo to completed and Click on Active button")
	public void User_creates_the_Todos_and_hit_the_Enter_button_and_change_the_1st_Todo_to_completed_and_Click_on_Active_button() throws InterruptedException , IOException
	{
		System.out.println("on Todo screen");
	WebElement todobox = driver.findElement(By.xpath("/html/body/section/header/input"));
		driver.findElement(By.xpath("/html/body/section/header/input")).click();
		 js = (JavascriptExecutor) driver;  
		
	
	File Src = new File(projpath+"/src/test/resources/testdata/Todos.xlsx");
		FileInputStream fis = new FileInputStream(Src);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sht = wb.getSheetAt(0);
	int i=0;
	for (i=0;i<4;i++)
	{
	String todovalue = sht.getRow(i).getCell(0).getStringCellValue();
	System.out.println(todovalue);
	js.executeScript("arguments[0].value='"+todovalue+"'", todobox);
	driver.findElement(By.xpath("/html/body/section/header/input")).sendKeys(Keys.SPACE);
	driver.findElement(By.xpath("/html/body/section/header/input")).sendKeys(Keys.ENTER);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	driver.findElement(By.xpath("/html/body/section/section/ul/li[1]/div/input")).click();
	driver.findElement(By.xpath("/html/body/section/footer/ul/li[2]/a")).click();		
	
	}

	@Then("Active Todos are only listed in Todos list")
	public void Active_Todos_are_only_listed_in_Todos_list() {
		//System.out.println("on Todo screen");
		  js.executeScript("alert('Active todos are listed');");   
	}
}
