package byzas.example.simpleworkflow.flows.register.steps;

import byzas.libs.workflow.engine.handler.Context;
import byzas.libs.workflow.engine.handler.ParameterContext;
import byzas.libs.workflow.engine.handler.Step;
import byzas.libs.workflow.engine.handler.WorkflowStep;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */

@Log4j2
public class CreateUserStep implements Step {
    @Override
    public String getName() {
        return "Create User Step";
    }

    @Override
    public Mono<Boolean> doActionMono(Context context) {
        log.info("User created");

        context.setParametersAttribute("parameter1", "parameter valud");
        context.dumpContextParameters();
        if (1 == 1) return Mono.error(new RuntimeException("Forced exception"));
        return Mono.just(true);
    }

    @Override
    public CompletableFuture<Boolean> doActionFuture(Context context) {
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
    public Boolean doAction(Context context) {
        log.info("User created");

        context.setParametersAttribute("parameter1", "parameter valud");
        context.dumpContextParameters();

        return true;
    }
}
