package byzas.example.simpleworkflow.flows.register.steps;

import byzas.example.simpleworkflow.core.context.AbstractContext;
import byzas.example.simpleworkflow.core.workflowstep.WorkflowStep;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */

@Log4j2
public class CreateUserStep extends WorkflowStep {
    @Override
    public String getName() {
        return "Create User Step";
    }

    @Override
    public Mono<Boolean> doActionMono(AbstractContext context) {
        log.info("User created");

        context.setParametersAttribute("parameter1", "parameter valud");
        context.dumpContextParameters();
        if (1 == 1) return Mono.error(new RuntimeException("Forced exception"));
        return Mono.just(true);
    }

    @Override
    public CompletableFuture<Boolean> doActionFuture(AbstractContext context) {
        log.info("User created");

        context.setParametersAttribute("parameter1", "parameter valud");
        context.dumpContextParameters();

        if (1 == 1) {
            CompletableFuture<Boolean> result = new CompletableFuture<>();
            result.completeExceptionally(new RuntimeException("Forced exception"));
            return result;
        }
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public Boolean doAction(AbstractContext context) {
        log.info("User created");

        context.setParametersAttribute("parameter1", "parameter valud");
        context.dumpContextParameters();

        return true;
    }
}
