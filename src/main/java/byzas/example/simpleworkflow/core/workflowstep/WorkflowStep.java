package byzas.example.simpleworkflow.core.workflowstep;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */

import byzas.example.simpleworkflow.core.context.AbstractContext;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public abstract class WorkflowStep {
    public abstract String getName();

    public Mono<Boolean> doAction(AbstractContext context){
        //Not implemented
        return Mono.just(false);
    }
    public CompletableFuture<Boolean> doActionFuture(AbstractContext context){
        // Not implemented
        return CompletableFuture.completedFuture(false);
    }
}