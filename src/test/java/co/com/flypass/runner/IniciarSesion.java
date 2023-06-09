package co.com.flypass.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = "co.com.flypass.stepDefinitions",
        tags="@iniciarSesion",
        snippets = SnippetType.CAMELCASE
)

public class IniciarSesion {
    private IniciarSesion(){}
}
