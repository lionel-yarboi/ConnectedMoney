import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/resources",
        plugin = {"pretty", "html:src/test/java/reports", "json:src/test/java/reports/cucumber_report.json", "rerun:target/rerun.txt"},
        strict = true,
        tags = {"~@Ignore", "~@Manual", "~@QA", "@accountList"},
        snippets = SnippetType.CAMELCASE
)
/**
 * Created by Yarboi on 13/12/2016.
 */

public class RunCucumberTests {
}
