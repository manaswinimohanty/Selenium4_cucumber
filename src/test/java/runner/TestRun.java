package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions( features = {"src/test/resources/feature"},
        plugin = {"pretty",
                "html:target/cucumberReports/Report.html",
                "json:target/cucumberReports/Report.json",
                "junit:target/cucumberReports/Report.xml"
                //  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                },
        glue = {"stepDef","hooks","api"},
        tags = "@apiRegistration"

)

public class TestRun extends AbstractTestNGCucumberTests {


/*    @DataProvider(parallel = true) // Enable parallel execution at scenario level
    public Object[][] scenarios() {
        return super.scenarios();
    }*/

}
