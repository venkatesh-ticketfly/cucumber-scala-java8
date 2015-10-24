import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict=true, plugin={"pretty", "html:target/cucumber_html", "junit:target/cucumber_junit"})
public class RunTest {
}
