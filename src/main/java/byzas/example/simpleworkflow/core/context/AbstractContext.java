package byzas.example.simpleworkflow.core.context;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

/**
 * Context interface.
 * <p>
 * Class which extend this interface should be able to provide mechanism for keeping object in context.<br />
 * So they can be shared between action inside workflow.
 *
 * @author igor.madjeric
 */

@Log4j2
public abstract class AbstractContext {
    private final Map<String, Object> contextParameters;
    private Map<String, Object> loggingContextParameters;

    protected AbstractContext(Map<String, Object> parameters) {
        this.contextParameters = parameters;
        this.loggingContextParameters = new HashMap<>();
    }


    public Object getParametersAttribute(String name) {
        return this.contextParameters.get(name);
    }

    public void setParametersAttribute(String name, Object value) {
        this.contextParameters.put(name, value);
    }

    public Object getLoggingParametersAttribute(String name) {
        return this.contextParameters.get(name);
    }

    public void setLoggingParametersAttribute(String name, Object value) {
        this.contextParameters.put(name, value);
    }

    public void dumpLogs(){
        log.info("{}", this.loggingContextParameters);
    }

    public void dumpContextParameters(){
        log.info("{}", this.contextParameters);
    }
}