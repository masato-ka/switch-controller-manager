package ka.masato.switchcontroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SwitchControllManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwitchControllManagerApplication.class, args);
    }

    @GetMapping
    public String get(){
        return "FooBar";
    }

    @GetMapping(path="/kicking")
    public String kicking(){
        return "Kicked";
    }
}

