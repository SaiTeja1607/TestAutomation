package TestGroup.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {

int count=0;
int maxTry=2;
if(count<maxTry)
{
	count++;
	return true;
	}
		return false;
	}

}
