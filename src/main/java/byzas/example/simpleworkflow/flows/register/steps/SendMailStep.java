package byzas.example.simpleworkflow.flows.register.steps;

import byzas.libs.workflow.engine.handler.Context;
import byzas.libs.workflow.engine.handler.Step;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */

@Log4j2
public class SendMailStep implements Step {

    @Override
    public String getName() {
        return "Send Mail Step";
    }


    @Override
    public CompletableFuture<Boolean> doActionFuture(Context context) {
        log.info("Mail sended");
        log.info("Incoming parameter : parameter1 : " + context.getParametersAttribute("parameter1"));
        context.setParametersAttribute("mail", "sended");
        context.dumpContextParameters();
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public Mono<Boolean> doActionMono(Context context) {
        log.info("Mail sended");
        log.info("Incoming parameter : parameter1 : " + context.getParametersAttribute("parameter1"));
        context.setParametersAttribute("mail", "sended");
        context.dumpContextParameters();
        return Mono.just(true);
    }

    @Override
    public Boolean doAction(Context context) {
        log.info("Mail sended");
        log.info("Incoming parameter : parameter1 : " + context.getParametersAttribute("parameter1"));
        context.setParametersAttribute("mail", "sended");
        context.dumpContextParameters();
        return true;
    }
}
