package Steps.in;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import Base.in.BaseClass;
import cucumber.api.java.en.*;
import pom.in.LoginPage;
import pom.in.Taskpage;

public class Stepdefinition extends BaseClass {

	@BeforeMethod
	@Given("I am in Cogmento CRM Login Page")
	public void i_am_in_Cogmento_CRM_Login_Page() {
		launchBrowser();
		launchUrl("https://ui.freecrm.com/");
		String LoginPageUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://ui.freecrm.com/", LoginPageUrl);
	}

	@When("I enter valid username and Password")
	public void i_enter_valid_username_and_Password() throws Throwable {
		LoginPage login = new LoginPage();
		Thread.sleep(4000);

		String Username = readfromExcel(1, 0, "Loginsheet");
		filltxtbox(login.getName(), Username);

		String Password = readfromExcel(1, 1, "Loginsheet");
		filltxtbox(login.getPassword(), Password);

		bclick(login.getLoginButton());
	}

	@Then("Verify the user Cogmento CRM HomePage")
	public void verify_the_user_Cogmento_CRM_HomePage() throws Throwable {
		String title = driver.getTitle();
		Assert.assertTrue(title.equals("Cogmento CRM"));
		close();
	}

	@When("I Enter invalid Username and Password")
	public void i_Enter_invalid_Username_and_Password() throws Throwable {
		LoginPage login = new LoginPage();
		Thread.sleep(1000);

		String Username = readfromExcel(2, 0, "Loginsheet");
		filltxtbox(login.getName(), Username);

		String Password = readfromExcel(2, 1, "Loginsheet");
		filltxtbox(login.getPassword(), Password);

		bclick(login.getLoginButton());
	}

	@Then("I will be in Cogmento CRM HomePage")
	public void i_will_be_in_Cogmento_CRM_HomePage() throws Throwable {
		LoginPage login = new LoginPage();
		Thread.sleep(2000);
		WebElement failerrmsg = login.getInvalidlogin();
		String text = failerrmsg.getText();
		Assert.assertEquals(text, "Invalid login");
		close();
		
	}
	
	@When("I click on Task tab and I fill and save TaskDetails in Create NewTask page")
	public void i_click_on_Task_tab_and_I_fill_and_save_TaskDetails_in_Create_NewTask_page() throws Throwable {
		LoginPage login = new LoginPage();Taskpage task=new Taskpage();	
		filltxtbox(login.getName(), "dlgcdina@gmail.com");
		filltxtbox(login.getPassword(), "Dinesh@01");
		bclick(login.getLoginButton());
		Thread.sleep(2000);	bclick(task.getTask());
		WebElement newTaskButton = task.getNewTask();bclick(newTaskButton);
		Thread.sleep(2000);
		
		String title = readfromExcel(1, 0, "Taskdetails");
		filltxtbox(task.getTitle(), title);
		
		String assignedTo = readfromExcel(1, 1, "Taskdetails");
		filltxtbox(task.getAssignedTo(), assignedTo);
		
		bclick(task.getDueDate());
		 WebElement dueDate = driver.findElement(By.xpath("//*[text()='11']"));
		 bclick(dueDate);
	
		 bclick(task.getClosedate());
		 WebElement closedate = driver.findElement(By.xpath("//*[text()='23']"));
		 bclick(closedate);
		 
		
		String description = readfromExcel(1, 5, "Taskdetails");
		filltxtbox(task.getDescription(), description);
		
		bclick(task.getSavetask());
			
	}

	@Then("verify created task is present in tasktable")
	public void verify_created_task_is_present_in_tasktable() throws Throwable {
		Taskpage task=new Taskpage();Thread.sleep(2000);	bclick(task.getTask());
		Thread.sleep(2000);
		WebElement tasktitle = task.getAppoinmenttask();
		String titlename = tasktitle.getText();
		Assert.assertEquals(titlename,"AppoinmentBooking");Thread.sleep(3000);
		close();
	}

	@Given("I am in taskdetails page")
	public void i_am_in_taskdetails_page() throws Throwable {
		launchBrowser();launchUrl("https://ui.freecrm.com/");
		LoginPage login = new LoginPage();Taskpage task=new Taskpage();
		Thread.sleep(2000);
		String Username = readfromExcel(1, 0, "Loginsheet");
		filltxtbox(login.getName(), Username);

		String Password = readfromExcel(1, 1, "Loginsheet");
		filltxtbox(login.getPassword(), Password);

		bclick(login.getLoginButton());;Thread.sleep(2000);bclick(task.getTask());
	
	}

	@When("I click on edit tasktable and edit taskdetails")
	public void i_click_on_edit_tasktable_and_edit_taskdetails() throws Throwable {
		Taskpage task=new Taskpage();Thread.sleep(2000);
		bclick(task.getEditTasktable());bclick(task.getTypefield());Thread.sleep(2000);
		bclick(task.getTasktypeselection());
		bclick(task.getStatus());
		bclick(task.getStatusselection());bclick(task.getSavetask());
	}

	@Then("verify the edited task view in tasklist")
	public void verify_the_edited_task_view_in_tasklist() throws Throwable {
		Taskpage task=new Taskpage();Thread.sleep(1000);	bclick(task.getTask());
		Thread.sleep(2000);
		WebElement verfiyedited = task.getVerifyTypefield();
		String validateeditedfield = verfiyedited.getText();
		Assert.assertEquals(validateeditedfield,"Customer Support");Thread.sleep(3000);
		close();
	}
	
	
}
