package PageObjectModel.NTTData.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import PageObjectModel.NTTData.context.PublicContext;

public class RetryingTestCases implements IRetryAnalyzer {
	int count = 0;
	int maxTry = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if (count < maxTry) {
				result.setStatus(ITestResult.FAILURE);
				count++;
				return true;
			}
			else
			{
				PublicContext.test.fail("execution has exteted Retry count.");
			}
		}
		else
		{
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}
