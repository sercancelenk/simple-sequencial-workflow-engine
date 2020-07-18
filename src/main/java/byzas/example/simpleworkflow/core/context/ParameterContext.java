package byzas.example.simpleworkflow.core.context;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */

@ToString
public class ParameterContext extends AbstractContext {

    public ParameterContext(Optional<Map<String, Object>> maybeParameters) {
        super(maybeParameters.orElseGet(HashMap::new));
    }

}