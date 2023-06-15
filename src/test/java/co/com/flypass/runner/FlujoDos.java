package co.com.flypass.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/flujoDos.feature",
        glue = "co.com.flypass.stepDefinitions",
        tags="@flujodos",
        snippets = SnippetType.CAMELCASE
)
public class FlujoDos {
            private FlujoDos(){}
}
