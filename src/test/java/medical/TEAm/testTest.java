package medical.TEAm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFFormulaEvaluator.SheetsFlushedException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testTest extends Baseclass {
	private static final String getdata = null;
	XSSFWorkbook work_book;
	XSSFSheet sheet;
	
	@Test(priority=-1)
	public void validate() {
		System.out.println("aravind");
	}
	
	@Test(priority=0)
	public void validating_signin() {
		Actions act=new Actions(driver);
		loginPage lPage=new loginPage(driver);
		//act.moveToElement(lPage.sighn_option()).build().perform();
		lPage.sighn_option().click();
	}	
	
	
	@DataProvider
	public Object[][] getdata(){
		Object[][] ob=new Object[1][1];
		ob[0][0]="aravindcherry16@gmail.com";
		
		
		//ob[0][1]="aravindawesome100@gmail.com";
		
		return ob;
	}
	
	@Test(priority=1)
	public void validate_reading_exceldata() throws IOException
	{
		FileInputStream fts =new FileInputStream("C:\\Users\\VOONNA ARAVIND VAMSI\\Desktop\\matter.xlsx");
		work_book=new XSSFWorkbook(fts);
		int no_of_sheets=work_book.getNumberOfSheets();
		for (int i=0;i<no_of_sheets;i++) {
			if (work_book.getSheetAt(i).getSheetName().equalsIgnoreCase("amazoncredentials")) {
				sheet=work_book.getSheetAt(i);
			}
			
		}
		
		
	
		
	}
	
	@Test(priority=2)
	public void validating_login() {
		//loginPage li=new loginPage(driver);
		int last_row=sheet.getLastRowNum();
		System.out.println(last_row);
		for (int i=0;i<=last_row;i++) {
			int last_cell=sheet.getRow(i).getLastCellNum();
			//System.out.println(last_cell);
		
			for (int j=0;j<last_cell;j++) {
				if(sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase("username")) {
					for(int p=i+1;p<=last_row;p++) {
						for(int k=0;k<last_cell;k++) {
							String usernameString=sheet.getRow(p).getCell(k).getStringCellValue();
							System.out.println(usernameString);
						}
					}
					
			}
			
			}
		}
		
	}
	
	@Test(priority=3,dataProvider="getdata")
	public void Testdata_provider(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		
		
	}
	
	

	


}

