package najah.edu;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\dell\\Downloads\\Sweet_lafa\\Sweet_lafa\\features", 
    plugin = { "summary", "html:target/cucumber/report.html" },
    monochrome = true,
    snippets = SnippetType.UNDERSCORE,
    glue = { "najah.edu" }
)
public class acceptance {
}

