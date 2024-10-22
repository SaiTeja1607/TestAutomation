package TestGroup.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
<<<<<<< HEAD
	int count=0;
	int maxTry=1;
	@Override
	public boolean retry(ITestResult result) {


=======

	@Override
	public boolean retry(ITestResult result) {

int count=0;
int maxTry=2;
>>>>>>> 131ac69e992059fb5dc68ca650a5340b5cc15257
if(count<maxTry)
{
	count++;
	return true;
	}
		return false;
	}

}
