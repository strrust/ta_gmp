package com.gmp.reportportal.junitsuite;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("ReportPortal API tests")
@SelectPackages("com.gmp.reportportal.tests")
public class JUnitApiSuite {
}
