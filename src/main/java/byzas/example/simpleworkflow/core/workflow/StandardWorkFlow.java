package byzas.example.simpleworkflow.core.workflow;

import byzas.example.simpleworkflow.core.workflowstep.WorkflowStep;

import java.util.List;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */

public class StandardWorkFlow extends WorkflowImpl {
    public StandardWorkFlow(String workFlowName, List<WorkflowStep> steps) {
        super(workFlowName, steps);
    }
}
