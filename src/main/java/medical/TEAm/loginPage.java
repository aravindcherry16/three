package medical.TEAm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	loginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()=\"Hello, Sign in\"]") public WebElement sighn_inoptionElement;
	@FindBy(xpath="//input[@type=\"email\"]") public WebElement username_field;
	@FindBy (xpath="//input[@id=\"continue\"]") public WebElement continue_option;
	
	public WebElement sighn_option() {
		return sighn_inoptionElement;
	}
	
	public WebElement validating_username_field() {
		return username_field;
	}
	
	public WebElement validating_continue_option() {
		return continue_option;
	}

}
