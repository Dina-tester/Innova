package pom.in;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.in.BaseClass;

public class Taskpage extends BaseClass {
	public Taskpage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[@href='/tasks']")	
	private static WebElement Task;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']//parent::a[@href='/tasks/new']")	
	private  WebElement NewTask;
	
	@FindBy(xpath = "//input[@name='title']")
	private  WebElement Title;
	
	@FindBy(xpath = "(//*[text()='Assigned To']//following-sibling::div[@role='listbox'])")
	private  WebElement AssignedTo;
	
	@FindBy(xpath = "(//div[@class='react-datepicker__input-container']//input[@type='text'])[1]")
	private  WebElement DueDate;
	
	
	@FindBy(xpath = "(//div[@class='react-datepicker__input-container']//input[@type='text'])[2]")
	private  WebElement closedate;
	
	@FindBy(xpath = "//div[@name='contact']")
	private  WebElement Contactno;
	
	@FindBy(xpath="//textarea[@name='description']")
	private  WebElement description;

	@FindBy(xpath="//*[@class='save icon']")
	private  WebElement savetask;
	
	
	@FindBy(xpath="//*[text()='AppoinmentBooking']")
	private  WebElement appoinmenttask;
	
	//Edit tasks
	@FindBy(xpath = "(//i[@class='edit icon'])[2]")
	private  WebElement editTasktable;
	
	
	@FindBy(xpath = "//label[text()='Type']//following-sibling::div")
	private  WebElement Typefield;
	

	@FindBy(xpath = "//label[text()='Status']//following-sibling::div")
	private  WebElement status;
	
	@FindBy(xpath = "//span[text()='Customer Support']")
	private  WebElement tasktypeselection;
	
	
	@FindBy(xpath = "//span[text()='Enquiring']")
	private  WebElement statusselection;
	
	
	
	@FindBy(xpath = "//td[text()='Customer Support']")
	private  WebElement verifyTypefield;
	
	
	public WebElement getVerifyTypefield() {
		return verifyTypefield;
	}
	public WebElement getTasktypeselection() {
		return tasktypeselection;
	}
	public WebElement getStatusselection() {
		return statusselection;
	}
	public WebElement getEditTasktable() {
		return editTasktable;
	}
	public WebElement getTypefield() {
		return Typefield;
	}
	public WebElement getStatus() {
		return status;
	}
	public WebElement getAppoinmenttask() {
		return appoinmenttask;
	}
	public WebElement getSavetask() {
		return savetask;
	}
	public WebElement getTask() {
		return Task;
	}
	public WebElement getNewTask() {
		return NewTask;
	}
	public WebElement getTitle() {
		return Title;
	}
	
	public WebElement getAssignedTo() {
		return AssignedTo;
	}
	public WebElement getDueDate() {
		return DueDate;
	}
	public WebElement getClosedate() {
		return closedate;
	}
	public WebElement getContactno() {
		return Contactno;
	}
	public WebElement getDescription() {
		return description;
	}
		
	
		
	
	}

