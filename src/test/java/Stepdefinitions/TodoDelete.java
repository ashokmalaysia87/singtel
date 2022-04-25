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
import io.cucumber.core.cli.Main;
public class TodoDelete {

    String projpath;
	WebDriver driver;
	JavascriptExecutor js;
	@Given("User is on Todos management screen to Remove the Todos")
	public void user_is_on_todos_management_screen_to_Remove_the_Todos() {
	   
	   
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

	@When("User creates the Todos and Change the status of Todos to completed and Clear the Completed Todos")
	public void User_creates_the_Todos_and_Change_the_status_of_Todos_to_completed_and_Clear_the_Completed_Todos() throws InterruptedException , IOException
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
	driver.findElement(By.xpath("/html/body/section/section/ul/li/div/input")).click();
	driver.findElement(By.xpath("/html/body/section/footer/button")).click();		
	
	}
	}

	@Then("Completed and clear Todos are removed from the list")
	public void Completed_and_clear_Todos_are_removed_from_the_list() {
		//System.out.println("on Todo screen");
		  js.executeScript("alert('all todos are deleted');");   
	}
}

