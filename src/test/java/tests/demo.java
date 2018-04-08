package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import libraryUtils.BaseTest;

public class demo extends BaseTest {

	
	@Test
	public void test() {
		
		System.out.println("Demo test");
		Reporter.log("Demo test", 1);
		
	}
}
