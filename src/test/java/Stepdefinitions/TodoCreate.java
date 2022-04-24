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

public class TodoCreate {
    String projpath;
	WebDriver driver;
	JavascriptExecutor js;
	@Given("User is on Todos management screen")
	public void user_is_on_todos_management_screen() {
	   
	   
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

	@When("User creates the Todos and hit the Enter button")
	public void user_creates_the_todos_and_hit_the_enter_button() throws InterruptedException , IOException
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
	}
	}

	@Then("Created Todos are listed as items in the same screen")
	public void created_todos_are_listed_as_items_in_the_same_screen() {
		//System.out.println("on Todo screen");
		  js.executeScript("alert('all todos are listed');");   
	}
}
