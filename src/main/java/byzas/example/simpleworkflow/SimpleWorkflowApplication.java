package byzas.example.simpleworkflow;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SimpleWorkflowApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleWorkflowApplication.class, args);
    }
}
