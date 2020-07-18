package byzas.example.simpleworkflow.core.workflow;

import byzas.example.simpleworkflow.core.context.AbstractContext;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */
public interface IWorkflow {
    Mono<Boolean> processWorkflow(AbstractContext context);
}


