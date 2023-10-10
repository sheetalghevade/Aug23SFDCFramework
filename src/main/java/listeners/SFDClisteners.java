package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.BaseTest;
import utils.CommonUtils;

public class SFDClisteners extends BaseTest implements ITestListener{
	
	@Override
	
	public void onTestSuccess(ITestResult result) {
		BaseTest.test.pass(result.getName()+" Test Passed");
		try {
			BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshots(BaseTest.getDriver()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
    public void onTestFailure(ITestResult result) {
    	BaseTest.test.fail(result.getName()+" Test Failed");
    	try {
			BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshots(BaseTest.getDriver()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
