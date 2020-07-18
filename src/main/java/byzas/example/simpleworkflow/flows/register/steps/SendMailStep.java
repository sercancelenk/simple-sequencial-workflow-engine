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
public class SendMailStep extends WorkflowStep {

    @Override
    public String getName() {
        return "Send Mail Step";
    }


    @Override
    public CompletableFuture<Boolean> doActionFuture(AbstractContext context) {
        log.info("Mail sended");
        log.info("Incoming parameter : parameter1 : " + context.getParametersAttribute("parameter1"));
        context.setParametersAttribute("mail", "sended");
        context.dumpContextParameters();
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public Mono<Boolean> doActionMono(AbstractContext context) {
        log.info("Mail sended");
        log.info("Incoming parameter : parameter1 : " + context.getParametersAttribute("parameter1"));
        context.setParametersAttribute("mail", "sended");
        context.dumpContextParameters();
        return Mono.just(true);
    }

    @Override
    public Boolean doAction(AbstractContext context) {
        log.info("Mail sended");
        log.info("Incoming parameter : parameter1 : " + context.getParametersAttribute("parameter1"));
        context.setParametersAttribute("mail", "sended");
        context.dumpContextParameters();
        return true;
    }
}
