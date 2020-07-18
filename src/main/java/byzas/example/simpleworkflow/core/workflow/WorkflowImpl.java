package byzas.example.simpleworkflow.core.workflow;

import byzas.example.simpleworkflow.core.context.AbstractContext;
import byzas.example.simpleworkflow.core.exception.WorkflowException;
import byzas.example.simpleworkflow.core.workflowstep.WorkflowStep;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.Function;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */

@Log4j2
@Getter
abstract class WorkflowImpl implements IWorkflow {
    protected final List<WorkflowStep> actions;
    protected final String workFlowName;

    public WorkflowImpl(String workFlowName, List<WorkflowStep> actions) {
        this.actions = actions;
        this.workFlowName = workFlowName;
    }

    @Override
    public CompletableFuture<Boolean> processWorkflow(AbstractContext context) {
        List<WorkflowStep> actions = getWorkflowActions();
        log.info("[WORKFLOW] [{}] Started.", getWorkFlowName());
        return actions.stream()
                .reduce(CompletableFuture.completedFuture(true),
                        (f, method) -> f.thenApplyAsync(result -> {
                            try {
                                return result && method.doAction(context)
                                        .handle((r, t) -> {
                                            if (Optional.ofNullable(t).isPresent()) {
                                                log.info("[WORKFLOW-STEP] [{}] completed exceptionally.", method.getName());
                                                CompletableFuture<Boolean> rr = CompletableFuture.completedFuture(false);
                                                rr.completeExceptionally(new RuntimeException(t));
                                                return rr;
                                            }
                                            log.info("[WORKFLOW-STEP] [{}] completed successfully.", method.getName());
                                            return CompletableFuture.completedFuture(r);
                                        })
                                        .thenComposeAsync(Function.identity())
                                        .join();
                            } catch (Exception e) {
                                log.error("[WORKFLOW-ERROR] [{}] - [{}]", this.getWorkFlowName(), method.getName(), e);
                                throw new WorkflowException(e);
                            }
                        }),
                        (f1, f2) -> f1.thenCombine(f2, (result1, result2) -> result1 && result2))
                .handle((r, ex) -> {
                    if (ex instanceof CompletionException) {
                        log.info("[WORKFLOW] [{}] completed exceptionally.", getWorkFlowName());
                    } else {
                        log.info("[WORKFLOW] [{}] completed successfully.", getWorkFlowName());
                    }

                    return r;
                });
    }

    private List<WorkflowStep> getWorkflowActions() {
        List<WorkflowStep> actions = getActions();
        if (CollectionUtils.isEmpty(actions)) {
            log.error("There is no defined action for " + getWorkFlowName());
            throw new IllegalArgumentException("There is no defined action for " + getWorkFlowName());
        }
        return actions;
    }


}