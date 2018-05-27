package step_definitions;

import com.hsbc.rbwm.digital.pfm.test.collaborators.RegistrationOrchestration;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

@CucumberStep
public class RegistrationStep implements En {

    @Autowired
    private RegistrationOrchestration registrationOrchestration;

    public RegistrationStep() {

        Given("^I have successfully authenticated user:$", (DataTable userCredentials) -> {

            try {
                registrationOrchestration.authenticateUser(userCredentials);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        });

    }

}