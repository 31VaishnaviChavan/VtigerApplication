package testCase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.preCondition;
import com.crm.FileUtility.ReadFromExcel;
import com.crm.fileUtility.ReadFromExcelFile;
import com.crm.javautility.GeneratRandom;
import com.crm.pom.HomePage;
import com.crm.pom.Organization;

public class OrganizationTestCase extends preCondition {

	@Test
	public void testcase1() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp = new HomePage(null);
		assertTrue(hp.homename().isDisplayed(),"i am not in dws page");
		Reporter.log("I am in vtiger home page");
		hp.org();
		Organization org = new Organization(driver);
		org.plusOrg();
		String org_name = ReadFromExcelFile.ExcelFIle("Organization", 0, 0);
		//String org_name= ReadFromExcelFile.readexcel
				
		int dynamicNumbers = GeneratRandom.random();
		String expected_org = org_name+dynamicNumbers;
		org.accountNAme(org_name+dynamicNumbers);
		org.save();
		String actual_org = org.header().getText();
		assertTrue(actual_org.contains(expected_org));
		Thread.sleep(2000);
	}
}
