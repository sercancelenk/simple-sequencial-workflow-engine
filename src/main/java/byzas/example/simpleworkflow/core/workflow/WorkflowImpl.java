package byzas.example.simpleworkflow.core.workflow;

import byzas.example.simpleworkflow.core.context.AbstractContext;
import byzas.example.simpleworkflow.core.workflowstep.WorkflowStep;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletionException;

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
    public Mono<Boolean> processWorkflow(AbstractContext context) {
        List<WorkflowStep> actions = getWorkflowActions();
        log.info("[WORKFLOW] [{}] Started.", getWorkFlowName());
        log.info("[{}] Steps", getWorkFlowName());
        actions.stream().forEach(action -> log.info("- {}", action.getName()));
        log.info("----------------------------------------------------");
        return actions.stream()
                .reduce(Mono.just(true),
                        (f, method) -> f.flatMap(result -> {
                            if (result) {
                                log.info("[WORKFLOW-STEP] [{}] started.", method.getName());
                                return method.doAction(context)
                                        .onErrorResume(t -> {
                                            log.info("[WORKFLOW-STEP] [{}] completed exceptionally.", method.getName());
                                            return Mono.error(new RuntimeException(t));
                                        })
                                        .doOnSuccess(d -> {
                                            log.info("[WORKFLOW-STEP] [{}] completed successfully.", method.getName());
                                        });

                            } else {
                                return Mono.just(false);
                            }
                        }),
                        (f1, f2) -> f1.zipWith(f2, (result1, result2) -> result1 && result2))
                .doOnError(t -> {
                    log.error("[WORKFLOW] [{}] completed exceptionally.", getWorkFlowName(), t.getCause());
                })
                .doOnSuccess(d -> {
                    log.info("[WORKFLOW] [{}] completed successfully.", getWorkFlowName());
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