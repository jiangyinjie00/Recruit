package com.yzu.recruit.dataaccess.base;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.io.Resources;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.util.StringUtils;

public class BaseUnitTest extends AbstractTestExecutionListener {

    private BasicDataSource currentDataSource;

    /**
     * The script name which would be run in BeforeClass method.
     */
    protected String scriptBeforeClass;

    /**
     * The script name which would be run in AfterClass method.
     */
    protected String scriptAfterClass;

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        currentDataSource = (BasicDataSource) testContext
                .getApplicationContext().getBean("dataSource");

        if (!StringUtils.isEmpty(scriptBeforeClass)) {
            executeScript(scriptBeforeClass, currentDataSource);
        }
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        if (!StringUtils.isEmpty(scriptBeforeClass)) {
            executeScript(scriptAfterClass, currentDataSource);
        }
    }

    private void executeScript(String scriptClass,
            BasicDataSource currentDataSource) throws IOException {

        InputStream fileInputStream = Resources
                .getResourceAsStream(scriptClass);
        Resource scriptResource = new InputStreamResource(fileInputStream);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(currentDataSource);
        JdbcTestUtils.executeSqlScript(jdbcTemplate, scriptResource, false);
    }

}
