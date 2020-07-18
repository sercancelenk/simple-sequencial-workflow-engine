package byzas.example.simpleworkflow.core.workflow;

import byzas.example.simpleworkflow.core.workflowstep.WorkflowStep;

import java.util.List;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */
public class WorkFlow extends WorkflowImpl {


    public WorkFlow(String workFlowName, List<WorkflowStep> actions) {
        super(workFlowName, actions);
    }

}
