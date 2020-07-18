package byzas.example.simpleworkflow.core.workflowstep;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */

import byzas.example.simpleworkflow.core.context.AbstractContext;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public abstract class WorkflowStep {
    public abstract String getName();

    public Mono<Boolean> doActionMono(AbstractContext context) {
        //Not implemented
        return Mono.error(new RuntimeException("Mono not implemented"));
    }

    public CompletableFuture<Boolean> doActionFuture(AbstractContext context) {
        // Not implemented
        CompletableFuture<Boolean> result = CompletableFuture.completedFuture(false);
        result.completeExceptionally(new RuntimeException("Future Not implemented"));
        return result;
    }

    public Boolean doAction(AbstractContext context) {
        // Not implemented
        throw new RuntimeException("Not implemented");
    }
}