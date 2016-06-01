package LolaAutomation.XeroDemoCompanyTest.Utils;

import org.apache.log4j.Logger;

/**
 * @author Lola
 * @email lolayan@outlook.com
 * 
 * 
 */
public class LogHelper {
	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger(LogHelper.class.getName());

	// This is to print log for the beginning of the test case, as we usually
	// run so many test cases as a test suite
	public static void startTestSuite(String sTestSuite) {
		Log.info(" * START Test Suite:" + sTestSuite + " * ");

	}

	// This is to print log for the ending of the test case
	public static void endTestSuite(String sTestSuite) {
		Log.info(" * END Test Suite:" + sTestSuite + " * ");

	}

	public static void startTest(String sTestName) {
		Log.info(" - START Test Case: " + sTestName + " - ");

	}

	// This is to print log for the ending of the test case
	public static void endTest(String sTestName) {
		Log.info(" - END Test Case: " + sTestName + " - ");
	}

	public static void startTestGroup(String sTestGroupName) {
		Log.info(" - START Test Group: " + sTestGroupName + " - ");
	}

	// This is to print log for the ending of the test case
	public static void endTestGroup(String sTestGroupName) {
		Log.info(" - END Test Group: " + sTestGroupName + " - ");
	}

	public static void startTestClass(String sTestClassName) {
		Log.info(" - START Test Class: " + sTestClassName + " - ");
	}

	// This is to print log for the ending of the test case
	public static void endTestClass(String sTestClassName) {
		Log.info(" - END Test Class: " + sTestClassName + " - ");
	}

	public static void startTestMethod(String sTestCaseName) {
		Log.info(" - START Test Method: " + sTestCaseName + " - ");
	}

	// This is to print log for the ending of the test case
	public static void endTestMethod(String sTestCaseName) {
		Log.info(" - END Test Method: " + sTestCaseName + " - ");
	}

	// Need to create these methods, so that they can be called
	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message) {
		Log.error(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}

}
