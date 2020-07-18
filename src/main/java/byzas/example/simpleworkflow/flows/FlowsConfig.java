package byzas.example.simpleworkflow.flows;

import byzas.example.simpleworkflow.core.workflow.IWorkflow;
import byzas.example.simpleworkflow.core.workflow.WorkFlow;
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
    public WorkFlow registerWorkflow(){
        WorkflowStep action1 = new CreateUserStep();
        WorkflowStep action2 = new SendMailStep();

        return new WorkFlow("Register Flow", Arrays.asList(action1, action2));
    }
}
