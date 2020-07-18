package byzas.example.simpleworkflow.core.workflowstep;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */

import byzas.example.simpleworkflow.core.context.AbstractContext;

import java.util.concurrent.CompletableFuture;

public interface WorkflowStep {
    String getName();

    CompletableFuture<Boolean> doAction(AbstractContext context);
}