package byzas.example.simpleworkflow;

import byzas.example.simpleworkflow.core.context.AbstractContext;
import byzas.example.simpleworkflow.core.context.ParameterContext;
import byzas.example.simpleworkflow.core.workflow.WorkFlow;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class SimpleWorkflowApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SimpleWorkflowApplication.class, args);
    }

    private final WorkFlow registerWorkflow;

    @Override
    public void run(String... args) throws Exception {

        AbstractContext context = new ParameterContext(Optional.of(new HashMap<String, Object>(){{put("sercan", "celenk");}}));
        registerWorkflow.processWorkflow(context);
    }
}
