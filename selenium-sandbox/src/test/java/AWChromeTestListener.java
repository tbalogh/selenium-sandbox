import org.testng.*;
import org.testng.xml.XmlSuite;

import java.awt.event.InputMethodListener;
import java.util.List;

/**
 * Created by tbalogh on 5/9/17.
 */
public class AWChromeTestListener implements ITestListener {

    private static final int THREAD_COUNT = 2;

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
//        setupMultiThreads(iTestContext);
    }

    private void setupMultiThreads(ITestContext iTestContext) {
        System.out.println("Set thread count to " + THREAD_COUNT);
        iTestContext.getCurrentXmlTest().setParallel(XmlSuite.ParallelMode.METHODS);
        iTestContext.getCurrentXmlTest().setThreadCount(THREAD_COUNT);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}

