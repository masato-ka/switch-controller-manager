package ka.masato.switchcontroll;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.PubSubAdmin;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubSubController {

    @Value("${crontask.topic}")
    private String topicName;
    @Value("${crontask.message}")
    private String message;

    private final PubSubTemplate pubSubTemplate;
    private final PubSubAdmin pubSubAdmin;

    public PubSubController(PubSubTemplate pubSubTemplate, PubSubAdmin pubSubAdmin) {
        this.pubSubTemplate = pubSubTemplate;
        this.pubSubAdmin = pubSubAdmin;
    }

    @GetMapping(path="/postMessage")
    public String postMessage(){
        this.pubSubTemplate.publish(this.topicName, this.message);
        return "success";
    }

}
