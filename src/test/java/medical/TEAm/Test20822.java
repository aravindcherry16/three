package medical.TEAm;




import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test20822 extends Baseclass {
	
	
	@DataProvider
	public Object[][] credentials(){
		Object[][] objects=new Object[1][1];
		objects[0][0]="aravind";
		objects[0][1]="aravindcherry16@gmail.com";
		
		return objects;
		
	}
	
	@Test(priority=1,dataProvider = "credentials")
	public void checking(String username,String password) {
		Rahulshettypage pr=new Rahulshettypage(driver);
		pr.first_practise.click();
		try {
			Thread.sleep(5000);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		String titleString=driver.getTitle();
		if(titleString.equals("https://rahulshettyacademy.com/practice-project")) {
			System.out.println("pass");
			
		}
		pr.name_field().sendKeys(username);
		pr.email_field().sendKeys(password);
		
	
		
		
		
	}

}
