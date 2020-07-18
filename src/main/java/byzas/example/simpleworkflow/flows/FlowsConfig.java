package byzas.example.simpleworkflow.flows;

import byzas.example.simpleworkflow.core.workflow.StandardWorkFlow;
import byzas.example.simpleworkflow.core.workflowstep.WorkflowStep;
import byzas.example.simpleworkflow.flows.register.steps.CreateUserStep;
import byzas.example.simpleworkflow.flows.register.steps.SendMailStep;
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
    public StandardWorkFlow registerWorkflow() {
        WorkflowStep step1 = new CreateUserStep();
        WorkflowStep step2 = new SendMailStep();

        return new StandardWorkFlow("Register Flow", Arrays.asList(step1, step2), true);
    }
}
