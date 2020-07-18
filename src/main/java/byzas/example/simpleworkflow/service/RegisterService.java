package byzas.example.simpleworkflow.service;

import byzas.example.simpleworkflow.core.context.AbstractContext;
import byzas.example.simpleworkflow.core.context.ParameterContext;
import byzas.example.simpleworkflow.core.workflow.StandardWorkFlow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class RegisterService {
    private final StandardWorkFlow registerWorkflow;

    public void registerUser() {
        AbstractContext context = new ParameterContext(Optional.of(new HashMap<String, Object>() {{
            put("sercan", "celenk");
        }}));
        registerWorkflow.processWorkflow(context);
    }

    public void registerUserMono() {
        AbstractContext context = new ParameterContext(Optional.of(new HashMap<String, Object>() {{
            put("sercan", "celenk");
        }}));
        registerWorkflow.processWorkflowMono(context).subscribe();
    }
    public void registerUserFuture() {
        AbstractContext context = new ParameterContext(Optional.of(new HashMap<String, Object>() {{
            put("sercan", "celenk");
        }}));
        registerWorkflow.processWorkflowFuture(context);
    }
}
