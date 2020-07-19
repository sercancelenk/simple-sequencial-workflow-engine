package byzas.example.simpleworkflow.flows;

import byzas.example.simpleworkflow.flows.register.steps.CreateUserStep;
import byzas.example.simpleworkflow.flows.register.steps.SendMailStep;
import byzas.libs.workflow.engine.handler.StandardWorkflow;
import byzas.libs.workflow.engine.handler.Step;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */

@Configuration
public class FlowsConfig {
    @Bean
    public StandardWorkflow registerWorkflow() {
        Step step1 = new CreateUserStep();
        Step step2 = new SendMailStep();

        return new StandardWorkflow("Register Flow", Arrays.asList(step1, step2), true);
    }
}
