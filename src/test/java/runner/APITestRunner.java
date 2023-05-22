package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features", //Donde esta los features
        glue = "steps", //Donde esta las definiciones de los steps
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        tags = "@ALL"
)
public class APITestRunner {
}
