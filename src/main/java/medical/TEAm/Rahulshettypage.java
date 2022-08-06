package medical.TEAm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class Rahulshettypage {
	
	WebDriver driver;
	
	Rahulshettypage(WebDriver ldriver){
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="(//*[contains(text(),\"Practice\")])[1]") public WebElement	first_practise;
	@FindBy(css = "input[id=\"name\"]") public WebElement name_field;
	@FindBy(css = "input[id=\"email\"]") public WebElement email_feild;
	
	public WebElement first_pratice() {
		return first_practise;
	}
	
	public WebElement name_field() {
		return name_field;
	}
	
	public WebElement email_field() {
		return email_feild;
	}
	
	

}
