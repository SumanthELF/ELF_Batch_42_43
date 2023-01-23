package workingWithTextNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Contacts_001 {

	@Test(priority=-1)
	public void createContact() {
		Reporter.log("FROM CREATE CONTACT",true);
	}
	@Test(priority=-8)
	public void modifyContact() {
		Reporter.log("FROM MODIFY CONTACT",true);
	}
	@Test(priority=-6)
	public void deleteContact() {
		Reporter.log("FROM DELETE CONTACT",true);
	}
	@Test(priority=5)
	public void editContact() {
		Reporter.log("FROM EDIT CONTACT",true);
	}
	@Test
	public void addContact() {
		Reporter.log("FROM ADD CONTACT",true);
	}
	@Test
	public void removeContact() {
		Reporter.log("FROM REMOVE CONTACT",true);
	}
}
