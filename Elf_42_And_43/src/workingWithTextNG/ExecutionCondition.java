package workingWithTextNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExecutionCondition {

	@Test
	public void createAccount() {
		Reporter.log("Frome Create Account", true);
	}
	@Test
	public void modifyAccount() {
		Reporter.log("Frome modify Account", true);
	}	
	@Test
	public void register() {
		Reporter.log("Frome register", true);
	}	
	@Test(dependsOnMethods="register")
	public void amountTransfer() {
		Reporter.log("Frome amount transfer", true);
	}	
	@Test
	public void deleteAccount() {
		Reporter.log("Frome delete Account", true);
	}
}
