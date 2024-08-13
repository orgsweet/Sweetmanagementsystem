package najah.edu.acceptance_tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Myfeatures", 
    plugin = { "summary", "html:target/cucumber/report.html" },
    monochrome = true,
    snippets = SnippetType.UNDERSCORE,
    glue = { "najah.edu.acceptance_tests" }
)
public class acceptanceTest {
}

