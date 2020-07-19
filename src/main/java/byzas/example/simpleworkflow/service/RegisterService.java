package byzas.example.simpleworkflow.service;

import byzas.libs.workflow.engine.handler.Context;
import byzas.libs.workflow.engine.handler.ParameterContext;
import byzas.libs.workflow.engine.handler.StandardWorkflow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class RegisterService {
    private final StandardWorkflow registerWorkflow;

    public void registerUser() {
        Context context = new ParameterContext(Map.of("sercan", "celenk"));
        registerWorkflow.processWorkflow(context);
    }

    public void registerUserMono() {
        Context context = new ParameterContext(Map.of("sercan", "celenk"));
        registerWorkflow.processWorkflowMono(context).subscribe();
    }

    public void registerUserFuture() {
        Context context = new ParameterContext(Map.of("sercan", "celenk"));
        registerWorkflow.processWorkflowFuture(context);
    }
}
