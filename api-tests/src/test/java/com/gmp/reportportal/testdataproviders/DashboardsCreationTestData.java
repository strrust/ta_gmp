package com.gmp.reportportal.testdataproviders;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.List;

import static com.gmp.reportportal.domain.dashboards.DashboardsTable.DASHBOARD_DEMO_NAME;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DashboardsCreationTestData {
    private static final String TEST_DESCRIPTION = "Test description";
    private static final String NAME_SIZE_ERROR_MESSAGE = "Incorrect Request. [Field 'name' should have size from '3' to '128'.] ";
    private static final String EMPTY_NAME_ERROR_MESSAGE = "Incorrect Request. [Field 'name' should not contain only white spaces and shouldn't be empty. Field 'name' should have size from '3' to '128'.] ";
    private static final String DUPLICATED_NAME_ERROR_MESSAGE = "Resource 'DEMO DASHBOARD' already exists. You couldn't create the duplicate.";
    private static final int NAME_ERROR_CODE = 4001;
    private static final int DUPLICATED_NAME_ERROR_CODE = 4091;

    public static List<Object[]> dashboardCreationNegativeCriteria() {
        return Arrays.asList(
                new Object[]{EMPTY, EMPTY, EMPTY_NAME_ERROR_MESSAGE, NAME_ERROR_CODE},
                new Object[]{RandomStringUtils.randomAlphabetic(2), TEST_DESCRIPTION, NAME_SIZE_ERROR_MESSAGE, NAME_ERROR_CODE},
                new Object[]{RandomStringUtils.randomAlphabetic(129), TEST_DESCRIPTION, NAME_SIZE_ERROR_MESSAGE, NAME_ERROR_CODE},
                new Object[]{EMPTY, TEST_DESCRIPTION, EMPTY_NAME_ERROR_MESSAGE, NAME_ERROR_CODE},
                new Object[]{DASHBOARD_DEMO_NAME, TEST_DESCRIPTION, DUPLICATED_NAME_ERROR_MESSAGE, DUPLICATED_NAME_ERROR_CODE}
        );
    }
}
