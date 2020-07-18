package byzas.example.simpleworkflow.core.context;

/**
 * @author ext0280263 on 18.07.2020
 * @project IntelliJ IDEA
 */
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Save states between different workflow action.
 *
 * @author igor.madjeric
 *
 */

@ToString
public class ParameterContext extends AbstractContext {

    public ParameterContext(Optional<Map<String, Object>> maybeParameters) {
        super(maybeParameters.orElseGet(HashMap::new));
    }

}