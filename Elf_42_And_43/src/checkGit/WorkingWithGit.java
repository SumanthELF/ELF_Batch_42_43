package checkGit;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class WorkingWithGit {

	@Test
	public void displayMessage() {
		System.out.println("Hi ");
		Reporter.log("Hello",true);
	}

}
