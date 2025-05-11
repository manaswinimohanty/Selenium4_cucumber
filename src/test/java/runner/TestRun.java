package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( features = {"src/test/resources/feature"},
        plugin = {"pretty",
                "html:target/cucumberReports/Report.html",
                "json:target/cucumberReports/Report.json",
                "junit:target/cucumberReports/Report.xml"
                //  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                },
        glue = {"stepDef","hooks"},
        tags = "@smoke"

)

public class TestRun extends AbstractTestNGCucumberTests {
}
