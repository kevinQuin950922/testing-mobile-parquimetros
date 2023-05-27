package co.com.flypass.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/flujoUno.feature",
        glue = "co.com.flypass.stepDefinitions",
        tags="@test",
        snippets = SnippetType.CAMELCASE
)
public class FlujoUno {
            private FlujoUno(){}
}
